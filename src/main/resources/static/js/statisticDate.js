// 基于准备好的dom，初始化echarts实例
var subChart1 = echarts.init(document.getElementById("sub1"));
var subChart2 = echarts.init(document.getElementById("sub2"));
var subChart3 = echarts.init(document.getElementById("sub3"));
var subChart5 = echarts.init(document.getElementById("changeWithTime"));
var subChart6 = echarts.init(document.getElementById("emerCountByStatus"));

// 指定图表的配置项和数据
subChart1.setOption({
    color: ['#3398DB'],
    tooltip : {
        trigger: 'axis',
        axisPointer : {            // 坐标轴指示器，坐标轴触发有效
            type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
        }
    },
    legend: {
        data: ['normal']
    },
    grid: {
        left: '3%',
        right: '4%',
        bottom: '3%',
        top: '3%',
        containLabel: true
    },
    xAxis : [
        {
            type : 'category',
            data : ['ULLC','KAG','L','RR','RD','FER','UKRS','KV','PVS','CKCS','KGG','TS','MI','CI'],
            axisTick: {
                alignWithLabel: false
            }
        }
    ],
    yAxis : [
        {
            type : 'value'
        }
    ],
    series : [
        {
            name:'normal',
            type:'bar',
            barWidth: '60%',
            data:[]
        }
    ]
});
subChart2.setOption({
    color: ['#EE7621'],
    tooltip : {
        trigger: 'axis',
        axisPointer : {            // 坐标轴指示器，坐标轴触发有效
            type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
        }
    },
    legend: {
        data: ['warning']
    },
    grid: {
        left: '3%',
        right: '4%',
        bottom: '3%',
        top: '3%',
        containLabel: true
    },
    xAxis : [
        {
            type : 'category',
            data : ['ULLC','KAG','L','RR','RD','FER','UKRS','KV','PVS','CKCS','KGG','TS','MI','CI'],
            axisTick: {
                alignWithLabel: false
            }
        }
    ],
    yAxis : [
        {
            type : 'value'
        }
    ],
    series : [
        {
            name:'warning',
            type:'bar',
            barWidth: '60%',
            data:[]
        }
    ]
});
subChart3.setOption({
    color: ['#CD0000'],
    tooltip : {
        trigger: 'axis',
        axisPointer : {            // 坐标轴指示器，坐标轴触发有效
            type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
        }
    },
    legend: {
        data: ['error']
    },
    grid: {
        left: '3%',
        right: '4%',
        bottom: '3%',
        top: '3%',
        containLabel: true
    },
    xAxis : [
        {
            type : 'category',
            data : ['ULLC','KAG','L','RR','RD','FER','UKRS','KV','PVS','CKCS','KGG','TS','MI','CI'],
            axisTick: {
                alignWithLabel: false
            }
        }
    ],
    yAxis : [
        {
            type : 'value'
        }
    ],
    series : [
        {
            name:'error',
            type:'bar',
            barWidth: '60%',
            data:[]
        }
    ]
});
subChart5.setOption({
    tooltip : {
        trigger: 'axis'
    },
    legend: {
        data:['ULLC','KAG','L','RR','RD','FER','UKRS','KV','PVS','CKCS','KGG','TS','MI','CI']
    },
    calculable : true,
    xAxis : [
        {
            type : 'category',
            boundaryGap : false,
            data : ['1/12','2/12','3/12','4/12','5/12','6/12','7/12','8/12','9/12','10/12','11/12','1']
        }
    ],
    yAxis : [
        {
            type : 'value',
//                axisLabel : {
//                    formatter: '{value} °C'
//                }
        }
    ],
    series : [
        {
            name:'ULLC',
            type:'line',
            data:[],
            markLine : {
                data : [
                    {type : 'average', name: '平均值'}
                ]
            }
        },
        {
            name:'KAG',
            type:'line',
            data:[],
            markLine : {
                data : [
                    {type : 'average', name : '平均值'}
                ]
            }
        },
        {
            name:'L',
            type:'line',
            data:[],
            markLine : {
                data : [
                    {type : 'average', name : '平均值'}
                ]
            }
        },
        {
            name:'RR',
            type:'line',
            data:[],
            markLine : {
                data : [
                    {type : 'average', name : '平均值'}
                ]
            }
        },
        {
            name:'RD',
            type:'line',
            data:[],
            markLine : {
                data : [
                    {type : 'average', name : '平均值'}
                ]
            }
        },
        {
            name:'FER',
            type:'line',
            data:[],
            markLine : {
                data : [
                    {type : 'average', name : '平均值'}
                ]
            }
        },
        {
            name:'UKRS',
            type:'line',
            data:[],
            markLine : {
                data : [
                    {type : 'average', name : '平均值'}
                ]
            }
        },
        {
            name:'KV',
            type:'line',
            data:[],
            markLine : {
                data : [
                    {type : 'average', name : '平均值'}
                ]
            }
        },
        {
            name:'PVC',
            type:'line',
            data:[],
            markLine : {
                data : [
                    {type : 'average', name : '平均值'}
                ]
            }
        },
        {
            name:'CKCS',
            type:'line',
            data:[],
            markLine : {
                data : [
                    {type : 'average', name : '平均值'}
                ]
            }
        },
        {
            name:'KGG',
            type:'line',
            data:[],
            markLine : {
                data : [
                    {type : 'average', name : '平均值'}
                ]
            }
        },
        {
            name:'TS',
            type:'line',
            data:[],
            markLine : {
                data : [
                    {type : 'average', name : '平均值'}
                ]
            }
        },
        {
            name:'MI',
            type:'line',
            data:[],
            markLine : {
                data : [
                    {type : 'average', name : '平均值'}
                ]
            }
        },
        {
            name:'CI',
            type:'line',
            data:[],
            markLine : {
                data : [
                    {type : 'average', name : '平均值'}
                ]
            }
        }
    ]
});
subChart6.setOption({
    title : {
        x:'center'
    },
    tooltip : {
        trigger: 'item',
        formatter: "{a} <br/>{b} : {c} ({d}%)"
    },
    legend: {
        // orient: 'vertical',
        left: 'center',
        data: ['其他','Token','初始化','选取','库存','验证码','参数','积分','联璧']
    },
    series : [
        {
            name: 'emergency',
            type: 'pie',
            radius : '55%',
            center: ['50%', '50%'],
            data:[
                {value:[], name:'其他'},
                {value:[], name:'Token'},
                {value:[], name:'初始化'},
                {value:[], name:'选取'},
                {value:[], name:'库存'},
                {value:[], name:'验证码'},
                {value:[], name:'参数'},
                {value:[], name:'积分'},
                {value:[], name:'联璧'}
            ],
            itemStyle: {
                emphasis: {
                    shadowBlur: 10,
                    shadowOffsetX: 0,
                    shadowColor: 'rgba(0, 0, 0, 0.5)'
                }
            }
        }
    ]
});


subChart1.showLoading();
subChart2.showLoading();
subChart3.showLoading();
subChart5.showLoading();
subChart6.showLoading();
function getData() {
    var start_day = $('#startdate').val();
    var end_day = $('#enddate').val();
    $.ajax({
        type: "post",
        dataType: "json",
        url: '/sc/apiTransfer',
        data: {"date": start_day, "size": end_day},
        success: function (data) {
            subChart1.hideLoading();
//              异步加载数据
            subChart1.setOption({
                series : [
                    {
                        name:'normal',
                        data:data.normal
                    }
                ]
            });
            subChart2.hideLoading();
            subChart2.setOption({
                series : [
                    {
                        name:'warning',
                        data:data.userMistake
                    }
                ]
            });
            subChart3.hideLoading();
            subChart3.setOption({
                series : [
                    {
                        name:'error',
                        data:data.programError
                    }
                ]
            });
        }
    });
}
getData();

function getEmerChangeWithTime() {
    var start_day = $('#startdate').val();
    var end_day = $('#enddate').val();
    $.ajax({
        type: "post",
        dataType: "json",
        url: '/sc/emerChangeWithTime',
        data: {"date": start_day, "size": end_day},
        success: function (data) {
            subChart5.hideLoading();
            subChart5.setOption({
                series: [
                    {
                        name:'ULLC',
                        data:data.emerCountByTime[0]
                    },
                    {
                        name:'KAG',
                        data:data.emerCountByTime[1]
                    },
                    {
                        name:'L',
                        data:data.emerCountByTime[2]
                    },
                    {
                        name:'RR',
                        data:data.emerCountByTime[3]
                    },
                    {
                        name:'RD',
                        data:data.emerCountByTime[4]
                    },
                    {
                        name:'FER',
                        data:data.emerCountByTime[5]
                    },
                    {
                        name:'UKRS',
                        data:data.emerCountByTime[6]
                    },
                    {
                        name:'KV',
                        data:data.emerCountByTime[7]
                    },
                    {
                        name:'PVS',
                        data:data.emerCountByTime[8]
                    },
                    {
                        name:'CKCS',
                        data:data.emerCountByTime[9]
                    },
                    {
                        name:'KGG',
                        data:data.emerCountByTime[10]
                    },
                    {
                        name:'TS',
                        data:data.emerCountByTime[11]
                    },
                    {
                        name:'MI',
                        data:data.emerCountByTime[12]
                    },
                    {
                        name:'CI',
                        data:data.emerCountByTime[13]
                    }
                ]
            });
        }
    });
}
getEmerChangeWithTime();

function getEmerCountByStatus() {
    var start_day = $('#startdate').val();
    var end_day = $('#enddate').val();
    $.ajax({
        type: "post",
        dataType: "json",
        url: '/sc/emerCountByStatus',
        data: {"date": start_day, "size": end_day},
        success: function (data) {
            subChart6.hideLoading();
            subChart6.setOption({
                series : [
                    {
                        name: 'emergency',
                        data:[
                            {value:data.ecbs[1][0], name:'其他'},
                            {value:data.ecbs[1][1], name:'Token'},
                            {value:data.ecbs[1][2], name:'初始化'},
                            {value:data.ecbs[1][3], name:'选取'},
                            {value:data.ecbs[1][4], name:'库存'},
                            {value:data.ecbs[1][5], name:'验证码'},
                            {value:data.ecbs[1][6], name:'参数'},
                            {value:data.ecbs[1][7], name:'积分'},
                            {value:data.ecbs[1][8], name:'联璧'}
                        ]
                    }
                ]
            });
        }
    });
}
getEmerCountByStatus();