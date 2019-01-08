package util;

import java.util.List;

/**
 * 图表工具类
 * 
 * @author Administrator
 *
 */
public class ChartHelper {

	/**
	 * 数组转字符串列表
	 * 
	 * @param arr
	 *            数组
	 * @param quote
	 *            引号
	 * @return
	 */
	public static String arrayToString(int[] arr, String quote) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("[");
		for (int each : arr) {
			if (quote == null) {
				stringBuilder.append(each + ",");
			} else {
				stringBuilder.append(quote + each + quote + ",");
			}
		}
		stringBuilder.deleteCharAt(stringBuilder.length() - 1);
		stringBuilder.append("]");
		return stringBuilder.toString();
	}

	/**
	 * 数组转字符串列表
	 * 
	 * @param arr
	 *            数组
	 * @param quote
	 *            引号
	 * @return
	 */
	public static String arrayToString(double[] arr, String quote, String format) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("[");
		for (double each : arr) {
			String string = "";
			if (format != null) {
				string = String.format(format, each);
			} else {
				string = each + "";
			}
			if (quote == null) {
				stringBuilder.append(string + ",");
			} else {
				stringBuilder.append(quote + string + quote + ",");
			}
		}
		stringBuilder.deleteCharAt(stringBuilder.length() - 1);
		stringBuilder.append("]");
		return stringBuilder.toString();
	}

	/**
	 * 数组转字符串列表
	 * 
	 * @param arr
	 *            数组
	 * @return
	 */
	public static String arrayToString(int[] arr) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("[");
		for (int each : arr) {
			stringBuilder.append(each + ",");
		}
		stringBuilder.deleteCharAt(stringBuilder.length() - 1);
		stringBuilder.append("]");
		return stringBuilder.toString();
	}

	/**
	 * 数组转字符串列表
	 * 
	 * @param arr
	 *            数组
	 * @return
	 */
	public static String arrayToString(double[] arr, String format) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("[");
		for (double each : arr) {
			String string = "";
			if (format != null) {
				string = String.format(format, each);
			} else {
				string = each + "";
			}
			stringBuilder.append(string + ",");
		}
		stringBuilder.deleteCharAt(stringBuilder.length() - 1);
		stringBuilder.append("]");
		return stringBuilder.toString();
	}

	/**
	 * 数组转字符串列表
	 * 
	 * @param arr
	 *            数组
	 * @return
	 */
	public static String arrayToString(String[] arr) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("[");
		for (String each : arr) {
			stringBuilder.append(each + ",");
		}
		stringBuilder.deleteCharAt(stringBuilder.length() - 1);
		stringBuilder.append("]");
		return stringBuilder.toString();
	}

	/**
	 * 集合转字符串
	 * 
	 * @param list
	 *            集合
	 * @param quote
	 *            引号
	 * @return
	 */
	public static String listToString(List<Integer> list, String quote) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("[");
		for (Integer each : list) {
			if (quote == null) {
				stringBuilder.append(each + ",");
			} else {
				stringBuilder.append(quote + each + quote + ",");
			}
		}
		stringBuilder.deleteCharAt(stringBuilder.length() - 1);
		stringBuilder.append("]");
		return stringBuilder.toString();
	}

	/**
	 * 集合转字符串
	 * 
	 * @param list
	 *            集合
	 * @param quote
	 *            引号
	 * @return
	 */
	public static String listToString(List<Double> list, String quote, String format) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("[");
		for (Double each : list) {
			String string = "";
			if (format != null) {
				string = String.format(format, each);
			} else {
				string = each + "";
			}
			if (quote == null) {
				stringBuilder.append(string + ",");
			} else {
				stringBuilder.append(quote + string + quote + ",");
			}
		}
		stringBuilder.deleteCharAt(stringBuilder.length() - 1);
		stringBuilder.append("]");
		return stringBuilder.toString();
	}
}
