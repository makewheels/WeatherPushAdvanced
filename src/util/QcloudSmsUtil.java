package util;

import java.util.ArrayList;

import com.github.qcloudsms.SmsSingleSender;
import com.github.qcloudsms.SmsSingleSenderResult;

/**
 * 腾讯云短信工具类
 * 
 * @author Administrator
 *
 */
public class QcloudSmsUtil {

	/**
	 * 发短信
	 * 
	 * @param phone
	 * @param tmplId
	 * @param params
	 */
	public static void sendSms(String phone, int tmplId, ArrayList<String> params) {
		try {
			int appid = 1400069913;
			String appkey = "ecec3065a185125dfc79feac7759802a";
			String signId = "丰众软件";
			SmsSingleSender singleSender = new SmsSingleSender(appid, appkey);
			SmsSingleSenderResult result = singleSender.sendWithParam("86", phone, tmplId, params, signId, "", "");
			System.out.println("qcloud-sms-send-to:" + phone + ", fee:" + result.getFee() + ", sid:" + result.getSid());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
