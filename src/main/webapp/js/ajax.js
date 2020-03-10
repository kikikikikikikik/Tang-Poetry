$.ajax({
    method:"get",
    url:"static_rank.json",
    dataType:"json",
    success:function(data){
        var names = [];
        var counts = [];
        for(var i in data){
            names.push(data[i][0]);
            counts.push(data[i][1]);
        }
        console.log(names);
        console.log(counts);
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
                data: names
            },
            yAxis: {},
            series: [{
                name: '销量',
                type: 'bar',    // bar 代表柱状图
                data: counts // 对应的每一个的数据
            }]
        };

        myChart.setOption(option);
    }
});