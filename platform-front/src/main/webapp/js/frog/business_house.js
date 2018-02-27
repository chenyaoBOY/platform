

$(function () {
})


var check_flag = true;
var xqrjl=0;//小区容积率 0：大于等于1.0   1：小于1.0
var house_location=0;//小区位置  0：五环内 1：5-6环  1：六环外
var ghzdj=0;//过户指导价  0：小于网签价  1：大于网签价
var house_year=0;//房屋年数 0：满五唯一 1：满两年  2：不满两年
var customer_count=0;//客户购房数量 0：首套  1：非首套
var house_common_status = 0;//0：普通  1：非普
var fee_price=0;//计税值
var geshui=0;
var qishui=0;
var zzs=0;
var proxy_fee=0;//佣金
var max_loan=0;//最大贷款额
function calculate_fee() {
    //信息框-例3

    //表单校验
    if(!checkForm()){
        layer.msg('这位客官,表格填写有误呢！');
        return ;
    }
    house_common_status = 0;//0：普通  1：非普
    fee_price=0;//计税值
     geshui=0;
     qishui=0;
     zzs=0;
     proxy_fee=0;//佣金
    max_loan=0;//最大贷款额

    var house_price = Number($("#house_price").val());
    //1.判断计税价格  网签价和过户指导价 较大者
    if(ghzdj==0){
        fee_price = Number($("#webPricePredict").val());
    }else{
        fee_price=Number($("#guide_price").val());
    }
    //2.判断房屋是否为非普
    house_common_status=judgeHouseCommonStatus();
    //3.计算增值税
    if(house_year!=2){
        if(house_common_status==1){
            // 差额征收=差额/1.05×5.6%
            // 差额=计税价格-原购房价格(原购房发票或契税发票价)
            zzs=sub(fee_price,$("#originalValue").val())/1.05*5.6/100;
        }
    }else{
        // 全额征收 =计税价格/1.05×5.6%
        zzs = fee_price/1.05*5.6/100;
    }
    //4.计算契税
    if(ghzdj==0){//若网签价＞最低过户指导价， 则契税=(网签价-本次增值税)×税率
        if(customer_count==0){
            if(Number($("#house_area").val())>90){
                qishui = sub(fee_price,zzs)*0.015;
            }else{
                qishui = sub(fee_price,zzs)*0.01;
            }
        }else{
            qishui = sub(fee_price,zzs)*0.03;
        }
    }else{//若最低过户指导价＞网签价，  则契税=最低过户指导价/1.05×税率
        if(customer_count==0){
            if(Number($("#house_area").val())>90){
                qishui = fee_price/1.05*0.015;
            }else{
                qishui = fee_price/1.05*0.01;
            }
        }else{
            qishui = fee_price/1.05*0.03;
        }
    }

    //5.计算个人所得税

    if(house_year==0){
        geshui == 0;
    }else{
        if($("#originalValue").val()==''){//全额征收
            if(ghzdj==0){//若网签价＞最低过户指导价 则个人所得税=（网签价-本次增值税）×1%；
                geshui = sub(fee_price,zzs)*0.01;
            }else{//若最低过户指导价＞网签价 则个人所得税=最低过户指导价/1.05×1%。
                geshui = fee_price/1.05*0.01;
            }
        }else{//差额征收 *20%
            if(ghzdj==0){//若网签价＞最低过户指导价 差额=网签价-本次增值税及附加-原值-原契税-网签价×10%-贷款利息
                geshui = (fee_price*0.9-zzs-Number($("#originalValue").val()))*0.2
            }else{//若最低过户指导价＞网签价 最低过户指导价/1.05-原值-原契税-附加- 最低过户指导价×10%-贷款利息
                geshui = (fee_price/1.05-zzs-Number($("#originalValue").val())-fee_price*0.1)*0.2
            }
        }
    }
    var tdcrj=0;
    if($("#tdcrj_status").val()==1){
        tdcrj=fee_price*0.03;
    }

    var total_fee = qishui+geshui+zzs+tdcrj;
    var allFee = house_price+total_fee;

    //6.计算佣金
    if($("#proxy_fee").val()!=''){
        proxy_fee =house_price*Number($("#proxy_fee").val())/100;
        allFee=add(allFee,proxy_fee);
    }
    
    //7.计算贷款 贷款额度比较 贷款额是根据网签和评估值的最低中的相关贷款比例来算的
    if(customer_count == 0){
        var minLoan =house_price*0.9*0.65;
        var minLoan2 = mul($("#webPricePredict").val(),0.65);
        if(minLoan<minLoan2){
            max_loan =Number(num_format(minLoan,2));
        }else{
            max_loan =Number(num_format(minLoan2,2));
        }
    }else{
        var minLoan =house_price*0.9*0.4;
        var minLoan2 = mul($("#webPricePredict").val(),0.4);
        if(minLoan<minLoan2){
            max_loan =Number(num_format(minLoan,2));
        }else{
            max_loan =Number(num_format(minLoan2,2));
        }
    }

    var first_pay = sub(allFee,max_loan);
    var data = (max_loan * 0.004083 * Math.pow( (1+0.004083),300) ) / ( Math.pow( (1+0.004083),300 ) -1)*10000;
    var every_month_pay =data;

    //首月还本付息金额=（本金/还款月数）+本金×月利率
    var firstMoth = add(div(max_loan,300),mul(max_loan,0.004083));
    //每月还本付息金额=（本金/还款月数）+（本金-累计已还本金）×月利率
    var secondMoth = add(div(max_loan,300),mul(sub(max_loan,div(max_loan,300)),0.004083));
    var  dif = (firstMoth-secondMoth)*10000;



    //8.费用统计
    $('#geshui').text(Number(geshui).toFixed(2)+"   万元");
    $('#qishui').text(Number(qishui).toFixed(2)+"   万元");
    $('#zzs').text(Number(zzs).toFixed(2)+"   万元");
    $('#total_money').text(Number(house_price).toFixed(2)+"   万元");//售价
    $('#total_price').text(num_format(allFee,2)+"   万元");//总计
    $('#proxy_price').text(num_format(proxy_fee,2)+"   万元");
    $('#total_fee').text(Number(total_fee).toFixed(2)+"   万元");//费用小计
    $('#max_loan').text(num_format(max_loan,2)+"   万元");
    $('#first_pay').text(num_format(first_pay,2)+"   万元");
    $('#every_month_pay').text(num_format(every_month_pay,2)+"   元/月");
    $('#every_month_pay2').text(num_format(mul(firstMoth,10000),2)+"   元/月"+'每月递减'+Number(dif).toFixed(2));
    $('#count_pay').text("300 期");
    $('#tdcrj').text(num_format(tdcrj,2)+"   万元");

}

function judgeHouseCommonStatus() {
    if(house_year == 2){
        return 0;
    }
    if(xqrjl==1){
        return 1;
    }
    if(Number($("#house_area").val())>140){
        return 1;
    }
    var house_price = fee_price;
    var avg = div(house_price,$("#house_area").val());
    if(house_location==0){//39600  4680000
        if(house_price>468&&avg>3.96){
            return 1;
        }
    }else if(house_location==1){//31680 3744000
        if(house_price>374.4&&avg>3.168){
            return 1;
        }
    }else if(house_location==2){//23760  2808000
        if(house_price>280.8&&avg>2.376){
            return 1;
        }
    }
    return 0;
}
$(function () {
    $('.in_tip').hide();
})
function checkForm() {
    var b1 = checkNullAndNum($("#house_price"));
    var b2 = checkNullAndNum($("#house_area"));
    var b3 = checkWebPrice($("#webPricePredict"));
    var b4=true;
    if(ghzdj==1){
        b4 = checkGuidPrice($("#guide_price"));
    }
    var b5 = checkNumber($("#proxy_fee"));
    var b6 = checkNumber($("#originalValue"));
    if(b1&&b2&&b3&&b4&&b5&&b6){
        return true;
    }else{
        return false;
    }
}

/****************************表单检查************************************/
function checkNullAndNum(ele) {
    var reg = /^\d+(\.\d+)?$/;
    var value=$(ele).val();
    if(value == ''){
        tip(ele,'此项必填哦！');
        return false;
    }
    if(!reg.test(value)){
        tip(ele,'仅支持数字哦！');
        return false;
    }
    $(ele).parent().next().hide();
    return true;
}
function checkNumber(ele) {
    var reg = /^\d+(\.\d+)?$/;
    var value=$(ele).val();
    if(value!='' && !reg.test(value)){
        tip(ele,'仅支持数字哦！');
        return false;
    }
    $(ele).parent().next().hide();
    return true;
}
function checkWebPrice(ele) {
    var reg = /^\d+(\.\d+)?$/;
    var value=$(ele).val();

    if(ghzdj==0){
        if(value == ''){
            tip(ele,'此项必填哦！');
            return false;
        }
    }
    if(value!='' && !reg.test(value)){
        tip(ele,'仅支持数字哦！');
        return false;
    }
    $(ele).parent().next().hide();
    return true;
}
function checkGuidPrice(ele) {
    var reg = /^\d+(\.\d+)?$/;
    var value=$(ele).val();
    if(ghzdj==1){//过户指导价为计税价
        if(value == ''){
            tip(ele,'此项必填哦！');
            return false;
        }
        if(!reg.test(value)){
            tip(ele,'仅支持数字哦！');
            return false;
        }
        // var webPrice = $("#webPricePredict").val();
        // if(webPrice!=''&& Number(webPrice)>Number(value)){
        //     tip(ele,'需大于网签价！');
        //     return false;
        // }
    }
    $(ele).parent().next().hide();
    return true;
}
function tip(ele,txt) {
    $(ele).parent().next().text(txt);
    $(ele).parent().next().show();
}


//***********************************************************************************

    layui.use('form', function() {
        var form = layui.form;

        form.on('checkbox(xqrj1)', function(data){//小区容积率
            setCheckBox(data,'xqrj2',form);
            if(data.elem.checked){
                xqrjl=0;
            }else{
                xqrjl=1;
            }
        });
        form.on('checkbox(xqrj2)', function(data){
            setCheckBox(data,'xqrj1',form);
            if(data.elem.checked){
                xqrjl=1;
            }else{
                xqrjl=0;
            }
        });
        form.on('checkbox(customer_zz1)', function(data){//客户资质
            setCheckBox(data,'customer_zz2',form);
            if(data.elem.checked){
                customer_count=0;
            }else{
                customer_count=1;
            }
        });
        form.on('checkbox(customer_zz2)', function(data){//客户资质
            setCheckBox(data,'customer_zz1',form);
            if(data.elem.checked){
                customer_count=1;
            }else{
                customer_count=0;
            }
        });
        form.on('checkbox(ghzdj1)', function(data){//过户指导价
            setCheckBox(data,'ghzdj2',form);
            if(data.elem.checked){
                ghzdj=0;
                $(".guide_price_div").hide();
                $(".webPricePredictDiv").show();
            }else{
                ghzdj=1;
                $(".guide_price_div").show();
                $(".webPricePredictDiv").hide();
            }
        });
        form.on('checkbox(ghzdj2)', function(data){//过户指导价
            setCheckBox(data,'ghzdj1',form);
            if(data.elem.checked){
                ghzdj=1;
                $(".guide_price_div").show();
                $(".webPricePredictDiv").hide();
            }else{
                ghzdj=0;
                $(".guide_price_div").hide();
                $(".webPricePredictDiv").show();
            }
        });
        form.on('select(house_location)', function(data){//小区位置
            house_location=data.value;
        });
        form.on('select(house_status)', function(data){//房屋年数
            house_year=data.value;
            if(data.value == 2){
                $('.qishui').hide();
            }else{
                $('.qishui').show();
            }
        });

    });

function setCheckBox(data,bId,form) {
    if(data.elem.checked){//勾选
        $('#'+bId).next().attr('class','layui-unselect layui-form-checkbox');
        $('#'+bId).removeAttr('checked');
        form.render('checkbox', bId);
    }else{//未勾选
        $('#'+bId).next().attr('class','layui-unselect layui-form-checkbox layui-form-checked');
        $('#'+bId).attr('checked',true);
        form.render('checkbox', bId);
    }

}
