
$(function () {
    $('.feedback_table').hide();
})
var myChart = echarts.init(document.getElementById('main'));
//默认加载商品房访问量
$.ajax({
    type    : 'POST',
    async   : false,
    url     : platform.path + '/back/getJsonData.do',
    data    :"",
    dataType:'json',
    success :function (data) {
        var str = JSON.stringify(data);
        data = str.replace(/\{/g,"[").replace(/\}/g,"]").replace(/\:/g,",");
        console.log(data)

        data = JSON.parse(data);

        myChart.setOption(option = {
            title: {
                text: '访问量统计图'
            },
            tooltip: {
                trigger: 'axis'
            },
            xAxis: {
                data: data.map(function (item) {
                    return item[0];
                })
            },
            yAxis: {
                splitLine: {
                    show: false
                }
            },
            toolbox: {
                left: 'center',
                feature: {
                    dataZoom: {
                        yAxisIndex: 'none'
                    },
                    restore: {},
                    saveAsImage: {}
                }
            },
            dataZoom: [{
                startValue: '2018-2-20'
            }, {
                type: 'inside'
            }],
            visualMap: {
                top: 10,
                right: 10,
                pieces: [{
                    gt: 0,
                    lte: 50,
                    color: '#096'
                }, {
                    gt: 50,
                    lte: 100,
                    color: '#ffde33'
                }, {
                    gt: 100,
                    lte: 150,
                    color: '#ff9933'
                }, {
                    gt: 150,
                    lte: 200,
                    color: '#cc0033'
                }, {
                    gt: 200,
                    lte: 300,
                    color: '#660099'
                }, {
                    gt: 300,
                    color: '#7e0023'
                }],
                outOfRange: {
                    color: '#999'
                }
            },
            series: {
                name: '访问量',
                type: 'line',
                data: data.map(function (item) {
                    return item[1];
                }),
                markLine: {
                    silent: true,
                    data: [{
                        yAxis: 50
                    }, {
                        yAxis: 100
                    }, {
                        yAxis: 150
                    }, {
                        yAxis: 200
                    }, {
                        yAxis: 300
                    }]
                }
            }
        });
    },
    error:function () {
        $(".wait-wrap").remove();
        layer.msg('获取数据失败！');
    }
})

//图表数据获取
function showChart(param) {
    $('#main').show();
    $.ajax({
        type    : 'POST',
        async   : false,
        url     : platform.path + '/back/getJsonData.do',
        data    :{"pageName":param},
        dataType:'json',
        success :function (data) {
            var str = JSON.stringify(data);
            data = str.replace(/\{/g,"[").replace(/\}/g,"]").replace(/\:/g,",");
            console.log(data)

            data = JSON.parse(data);

            myChart.setOption(option = {
                title: {
                    text: '访问量统计图'
                },
                tooltip: {
                    trigger: 'axis'
                },
                xAxis: {
                    data: data.map(function (item) {
                        return item[0];
                    })
                },
                yAxis: {
                    splitLine: {
                        show: false
                    }
                },
                toolbox: {
                    left: 'center',
                    feature: {
                        dataZoom: {
                            yAxisIndex: 'none'
                        },
                        restore: {},
                        saveAsImage: {}
                    }
                },
                dataZoom: [{
                    startValue: '2018-2-20'
                }, {
                    type: 'inside'
                }],
                visualMap: {
                    top: 10,
                    right: 10,
                    pieces: [{
                        gt: 0,
                        lte: 50,
                        color: '#096'
                    }, {
                        gt: 50,
                        lte: 100,
                        color: '#ffde33'
                    }, {
                        gt: 100,
                        lte: 150,
                        color: '#ff9933'
                    }, {
                        gt: 150,
                        lte: 200,
                        color: '#cc0033'
                    }, {
                        gt: 200,
                        lte: 300,
                        color: '#660099'
                    }, {
                        gt: 300,
                        color: '#7e0023'
                    }],
                    outOfRange: {
                        color: '#999'
                    }
                },
                series: {
                    name: '访问量',
                    type: 'line',
                    data: data.map(function (item) {
                        return item[1];
                    }),
                    markLine: {
                        silent: true,
                        data: [{
                            yAxis: 50
                        }, {
                            yAxis: 100
                        }, {
                            yAxis: 150
                        }, {
                            yAxis: 200
                        }, {
                            yAxis: 300
                        }]
                    }
                }
            });
        },
        error:function () {
            $(".wait-wrap").remove();
            layer.msg('获取数据失败！');
        }
    })
}


function showFeedbackList() {
    $('.feedback_table').show();
    $('#main').hide();

    layui.use('table', function(){
        var table = layui.table;

        table.render({
            elem: '#feedback_table'
            ,url: platform.path + '/back/getFeedbackData.do'
            ,cols: [[
                {field:'id',title: 'ID', sort: true}
                ,{field:'date',  title: '反馈时间',sort: true}
                ,{field:'pagename',  title: '反馈页面', sort: true}
                ,{field:'content', title: '反馈内容', minWidth: 150,sort: true}
            ]]
            ,page: true
        });
    });
}