//***************************layui核心********************************************************
var path =platform.path;
//侧边栏 滑动效果
layui.use('element', function() {
    var element = layui.element;

});

//重置表单
function resetForm() {
    $('#house_price').val('');
    $('#house_area').val('');
    $('#webPricePredict').val('');
    $('#originalValue').val('');
    $('#proxy_fee').val('');
    $('#guide_price').val('');
}
//*************************************************************************************************
/*浮点数加减乘除*/
/*加法*/
function add(a, b) {
    var c, d, e;
    try {
        c = a.toString().split(".")[1].length;
    } catch (f) {
        c = 0;
    }
    try {
        d = b.toString().split(".")[1].length;
    } catch (f) {
        d = 0;
    }
    return e = Math.pow(10, Math.max(c, d)), (mul(a, e) + mul(b, e)) / e;
}

/*减法*/
function sub(a, b) {
    var c, d, e;
    try {
        c = a.toString().split(".")[1].length;
    } catch (f) {
        c = 0;
    }
    try {
        d = b.toString().split(".")[1].length;
    } catch (f) {
        d = 0;
    }
    return e = Math.pow(10, Math.max(c, d)), (mul(a, e) - mul(b, e)) / e;
}

/*乘法*/
function mul(a, b) {
    var c = 0,
        d = a.toString(),
        e = b.toString();
    try {
        c += d.split(".")[1].length;
    } catch (f) {
    }
    try {
        c += e.split(".")[1].length;
    } catch (f) {
    }
    return Number(d.replace(".", "")) * Number(e.replace(".", "")) / Math.pow(10, c);
}

/*除法*/
function div(a, b) {
    var c, d, e = 0,
        f = 0;
    try {
        e = a.toString().split(".")[1].length;
    } catch (g) {
    }
    try {
        f = b.toString().split(".")[1].length;
    } catch (g) {
    }
    return c = Number(a.toString().replace(".", "")), d = Number(b.toString().replace(".", "")), mul(c / d, Math.pow(10, f - e));
}

function num_format(n,m){
    var s3 = Number(n).toFixed(m);
    n = s3.toString();
    var re=/\d{1,3}(?=(\d{3})+$)/g;
    var n1=n.replace(/^(\d+)((\.\d+)?)$/,function(s,s1,s2){return s1.replace(re,"$&,")+s2;});
    return n1;
}

function feedback() {
    layer.open({
        type: 1
        ,title: false //不显示标题栏
        ,closeBtn: false
        ,area: '600px;'
        ,shade: 0.8
        ,id: 'LAY_layuipro' //设定一个id，防止重复弹出
        ,resize: false
        ,btn: ['提交反馈', '取消']
        ,btnAlign: 'c'
        ,moveType: 1 //拖拽模式，0或者1
        ,content:
            '<div style="height:250px;padding: 40px; line-height: 22px; background-color: #393D49; color: #fff; font-weight: 300;">' +
            '<span>若计算有误,请告知我们,万分感谢！</span>' +
                '<div style="padding-top: 5px">' +
                    '<textarea style="    background-color: transparent;\n' +
            '    height: 203px;\n' +
            '    width: 517px;color: white" id="feed_content" placeholder="问题描述(给您带来的不便，十分抱歉...)"></textarea>'+
                 '</div>'+
            '</div>'
        ,success: function(layero){
            var btn = layero.find('.layui-layer-btn');
            btn.find('.layui-layer-btn0').attr({
                href: 'javascript:submitFeedback();'
            });
        }
    });
}

function submitFeedback() {
    var value = $("#feed_content").val();
    if(value == ''){
        layer.msg("客官，您还没有填写错误描述哦！");
    }else{
        $.ajax({
            type    : 'POST',
            async   : false,
            url     : platform.path + '/back/saveFeedbackData.do',
            data    :{"content":value,"pagename":$('#pagename').val()},
            dataType:'json',
            success :function (data) {
                if(data.success){
                    layer.msg('提交成功！');
                }else{
                    layer.msg('啊哦！客官，您的网络可能出了点问题呢！');
                }
            },
            error:function () {
                $(".wait-wrap").remove();
                layer.msg('啊哦！客官，您的网络可能出了点问题呢！');
            }
        })
    }
}

function payMoney() {
    layer.open({
        type: 1
        ,title: false //不显示标题栏
        ,closeBtn: false
        ,area: '300px;'
        ,shade: 0.8
        ,id: 'LAY_layuipro' //设定一个id，防止重复弹出
        ,resize: false
        ,btn: ['确定']
        ,btnAlign: 'c'
        ,moveType: 1 //拖拽模式，0或者1
        ,content:
        '<div style="height:250px;padding: 51px; line-height: 22px; background-color: #393D49; color: #fff; font-weight: 300;">' +
            '<div style="margin-bottom: 10px;">' +
                '<span>若91青蛙于您有益，欢迎赞赏！</span>'+
            '</div>'+

            "<img src='"+path+"/images/pay_weixin.jpg' alt='' width='194px'>"+
            '<div style="margin-top: 10px;">' +
                 '<span style="margin-left: 66px">微信支付</span>'+
            '</div>'+

        '</div>'
        ,success: function(layero){
            var btn = layero.find('.layui-layer-btn');
            btn.find('.layui-layer-btn0').attr({
                href: 'javascript:payMoneyTip();'
            });
        }
    });
}
function payMoneyTip() {
    layer.msg('客官美意，感激涕零！');
}

function showFeed() {
    layer.open({
        type: 1
        ,title: false //不显示标题栏
        ,closeBtn: false
        ,area: '600px;'
        ,shade: 0.8
        ,id: 'LAY_layuipro' //设定一个id，防止重复弹出
        ,resize: false
        ,btn: ['提交反馈', '取消']
        ,btnAlign: 'c'
        ,moveType: 1 //拖拽模式，0或者1
        ,content:
        '<div style="height:250px;padding: 40px; line-height: 22px; background-color: #393D49; color: #fff; font-weight: 300;">' +
        '<span>欢迎客官提出宝贵建议！</span>' +
        '<div style="padding-top: 5px">' +
        '<textarea style="    background-color: transparent;\n' +
        '    height: 203px;\n' +
        '    width: 517px;color: white" id="feed" placeholder="请输入您的意见或建议！"></textarea>'+
        '</div>'+
        '</div>'
        ,success: function(layero){
            var btn = layero.find('.layui-layer-btn');
            btn.find('.layui-layer-btn0').attr({
                href: 'javascript:submitFeed();'
            });
        }
    });
}
function submitFeed() {
    var value = $("#feed").val();
    if(value == ''){
        layer.msg("客官，您还没有填写建议呢！");
    }else{
        $.ajax({
            type    : 'POST',
            async   : false,
            url     : platform.path + '/back/saveFeedbackData.do',
            data    :{"content":value,"pagename":"意见反馈"},
            dataType:'json',
            success :function (data) {
                if(data.success){
                    layer.msg('提交成功！');
                }else{
                    layer.msg('啊哦！客官，您的网络可能出了点问题呢！');
                }
            },
            error:function () {
                $(".wait-wrap").remove();
                layer.msg('啊哦！客官，您的网络可能出了点问题呢！');
            }
        })
    }
}