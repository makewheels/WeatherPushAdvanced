package util;

import java.util.ArrayList;
import java.util.List;

/**
 * 要通知的列表
 * 
 * @author Administrator
 *
 */
public class NotifyList {

	/**
	 * 邮箱列表
	 * 
	 * @return
	 */
	public static List<String> getMailList() {
		List<String> list = new ArrayList<>();
		list.add("finalbird@foxmail.com");
		// list.add("tongbuwangpan@163.com");
		// list.add("174582555@qq.com");
		// list.add("daqingdayou@163.com");
		return list;
	}

	/**
	 * 手机列表
	 * 
	 * @return
	 */
	public static List<String> getPhoneList() {
		List<String> list = new ArrayList<>();
		list.add("13351190738");
		// list.add("17745293025");
		return list;
	}
}
