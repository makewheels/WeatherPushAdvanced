package example;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.aliyun.fc.runtime.Context;
import com.aliyun.fc.runtime.StreamRequestHandler;

import bean.aqi.AqiRoot;
import bean.realtimeweather.RealTimeWeather;
import bean.weather15days.Forecast;
import bean.weather15days.Weather15Days;
import freemaker.FreeMarkerGenerator;
import util.Base64Util;
import util.ChartHelper;
import util.NotifyList;
import util.QcloudCosUtil;
import util.TimeUtil;
import util.WeatherUtil;
import util.mail.AliyunMailUtil;

public class Hello implements StreamRequestHandler {

	@Override
	public void handleRequest(InputStream input, OutputStream output, Context context) throws IOException {
		long start = System.currentTimeMillis();

		System.out.println("Weather push mission start " + start);
		String cityId = "305";
		// 天气实况
		RealTimeWeather realTimeWeather = JSON.parseObject(WeatherUtil.getRealTimeWeather(cityId),
				RealTimeWeather.class);
		// 空气质量指数
		AqiRoot aqiRoot = JSON.parseObject(WeatherUtil.getAqi(cityId), AqiRoot.class);
		// 15天天气预报
		Weather15Days weather15Days = JSON.parseObject(WeatherUtil.getWeather15Days(cityId), Weather15Days.class);

		// 组织邮件内容
		Map<String, String> map = new HashMap<>();
		// 实时天气图标
		String icon = realTimeWeather.getData().getCondition().getIcon();
		String iconPath = Hello.class.getResource("/icon/W" + icon + ".png").getPath();
		map.put("iconSrc", "data:image/png;base64," + Base64Util.fileToBase64(iconPath));
		List<Forecast> forecastList = weather15Days.getData().getForecast();
		// 今天的天气预报
		Forecast forecast1 = forecastList.get(1);
		// tips
		map.put("tips", realTimeWeather.getData().getCondition().getTips());
		// 晴 -8 ~ 3°C
		map.put("tempRealTime", "&nbsp;&nbsp;" + forecast1.getConditionDay() + "&nbsp;&nbsp;" + forecast1.getTempNight()
				+ "&nbsp;~&nbsp;" + forecast1.getTempDay() + "°C");
		// 空气质量：41 pm2.5：16
		map.put("airQuality", aqiRoot.getData().getAqi().getValue());
		map.put("pm25", aqiRoot.getData().getAqi().getPm25());
		// 日出：07:34 日落：16:54
		map.put("sunRise", realTimeWeather.getData().getCondition().getSunRise().substring(11, 16));
		map.put("sunSet", realTimeWeather.getData().getCondition().getSunSet().substring(11, 16));
		// 北风3级 风速：4.4
		map.put("windDir", forecast1.getWindDirDay());
		map.put("windLevel", forecast1.getWindLevelDay());
		map.put("windSpeed", forecast1.getWindSpeedDay());
		// 未来三天天气预报
		Forecast forecast2 = forecastList.get(2);
		Forecast forecast3 = forecastList.get(3);
		Forecast forecast4 = forecastList.get(4);
		map.put("forecast2", forecast2.getPredictDate() + "&nbsp;&nbsp;" + forecast2.getTempNight() + "&nbsp;~&nbsp;"
				+ forecast2.getTempDay() + "°C");
		map.put("forecast3", forecast3.getPredictDate() + "&nbsp;&nbsp;" + forecast3.getTempNight() + "&nbsp;~&nbsp;"
				+ forecast2.getTempDay() + "°C");
		map.put("forecast4", forecast4.getPredictDate() + "&nbsp;&nbsp;" + forecast4.getTempNight() + "&nbsp;~&nbsp;"
				+ forecast2.getTempDay() + "°C");
		// 准备未来7天气温变化图表
		Map<String, String> chartMap = new HashMap<>();
		String[] tempNightArr = new String[7];
		String[] tempDayArr = new String[7];
		for (int i = 2; i <= 8; i++) {
			tempNightArr[i - 2] = forecastList.get(i).getTempNight();
			tempDayArr[i - 2] = forecastList.get(i).getTempDay();
		}
		chartMap.put("tempNight", ChartHelper.arrayToString(tempNightArr));
		chartMap.put("tempDay", ChartHelper.arrayToString(tempDayArr));
		// 保存到腾讯云对象存储
		String key = TimeUtil.getFilenameTime() + ".html";
		byte[] bytes = FreeMarkerGenerator.generateSevenDaysLineChartHtml(chartMap).getBytes();
		QcloudCosUtil.saveToQcloud(new ByteArrayInputStream(bytes), "/chartHtml/" + key, bytes.length);
		// 设置跳转链接
		map.put("link_sevenDaysLineChart", "http://static.qbserver.cn/chartHtml/" + key);
		// 读邮件列表
		List<String> mailList = NotifyList.getMailList();
		// 逐个发邮件
		for (String mail : mailList) {
			AliyunMailUtil.send(mail,
					TimeUtil.getDate() + " " + realTimeWeather.getData().getCity().getName() + " 天气预报",
					FreeMarkerGenerator.generateRootHtml(map));
		}
		System.out.println("Weather push mission end cost " + (System.currentTimeMillis() - start) + " millis");
	}

	public static void main(String[] args) {
		try {
			new Hello().handleRequest(null, null, null);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
