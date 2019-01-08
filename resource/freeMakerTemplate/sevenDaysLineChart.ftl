<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8"/>
		<meta name="viewport" content="width=device-width, initial-scale=1">

		<script src="https://img.hcharts.cn/highcharts/highcharts.js"></script>
        <script src="https://img.hcharts.cn/highcharts/highcharts-3d.js"></script>
        <script src="https://img.hcharts.cn/highcharts/modules/exporting.js"></script>
        <script src="https://img.hcharts.cn/highcharts-plugins/highcharts-zh_CN.js"></script>
	</head>
	<body>
		<center>
			<div id="sevenDaysLineChart" style="max-width:800px;height:400px"></div>
			<script>
				Highcharts.chart('sevenDaysLineChart', {
					title: {
						text: '未来7天气温走势 powered by spring'
					},
					subtitle: {
						text: '诶我就问你屌不屌？'
					},
					yAxis: {
						title: {
							text: '温度（°C）'
						}
					},
					legend: {
						layout: 'vertical',
						align: 'right',
						verticalAlign: 'middle'
					},
					plotOptions: {
						series: {
							label: {
								connectorAllowed: false
							},
							pointStart: 1
						},
						line: {
					        dataLabels: {
					            enabled: true,
					            style: {
									fontSize: '20px'
								}
					        }
					    }
					},
					series: [
								{
									name: '白天',
									data: ${tempDay}
								},
								{
									name: '夜晚',
									data: ${tempNight}
								}
					],
					responsive: {
						rules: [{
							condition: {
								maxWidth: 500
							},
							chartOptions: {
								legend: {
									layout: 'horizontal',
									align: 'center',
									verticalAlign: 'bottom'
								}
							}
						}]
					}
				});
			</script>
		</center>
	</body>
</html>