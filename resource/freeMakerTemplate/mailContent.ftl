<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8"/>
	</head>
	<body>
		<center>
			<img src="${iconSrc}"/>
			<b>
				<span style="font-size:30px;color:#003399;">${tempRealTime}</span><br /><br />
			</b>
			<table>
				<tr>
					<td>
						<span style="font-size:18px;">空气质量：</span>
						<span style="font-size:24px;color:#E53333;">${airQuality}</span>
					</td>
					<td>
						<span style="font-size:18px;">&nbsp;pm2.5：</span>
						<span style="font-size:24px;color:#E53333;">${pm25}</span>
					</td>
				</tr>
				<tr>
					<td>
						<span style="font-size:18px;">日出：</span>
						<span style="font-size:24px;color:#009900;">${sunRise}</span>
					</td>
					<td>
						<span style="font-size:18px;">&nbsp;日落：</span>
						<span style="font-size:24px;color:#009900;">${sunSet}</span>
					</td>
				</tr>
				<tr>
					<td>
						<span style="font-size:24px;color:#CD00CD;">${windDir}${windLevel}级</span>
					</td>
					<td>
						<span style="font-size:18px;">&nbsp;风速：</span>
						<span style="font-size:24px;color:#CD00CD;">${windSpeed}</span>
					</td>
				</tr>
			</table>
			<span style="font-size:20px;color:#FFD700;">${tips}</span><br /><br />
			<span style="font-size:20px;">${forecast2}</span><br />
			<span style="font-size:20px;">${forecast3}</span><br />
			<span style="font-size:20px;">${forecast4}</span><br /><br />
			<a href="${link_sevenDaysLineChart}">点击查看未来7天走势</a>
		</center>
	</body>
</html>