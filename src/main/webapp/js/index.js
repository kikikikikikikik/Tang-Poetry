//var是variable
//document是js中的html文档对象
//document.getElementById('main')找到html文档中的id为main的元素
//echarts.init()初始化画布元素
var myChart = echarts.init(document.getElementById('main'));

var option = {
    // 图标的标题
    title: {
        text: 'ECharts 入门示例'
    },
    tooltip: {},
    legend: {
        data:['销量']
    },
    // 横坐标
    xAxis: {
        data: ["衬衫","羊毛衫","雪纺衫","裤子","高跟鞋","袜子"]
    },
    yAxis: {},
    series: [{
        name: '销量',
        type: 'bar',    // bar 代表柱状图
        data: [5, 20, 36, 10, 10, 20] // 对应的每一个的数据
    }]
};

myChart.setOption(option);
