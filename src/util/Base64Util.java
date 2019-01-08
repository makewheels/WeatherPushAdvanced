package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import sun.misc.BASE64Encoder;

public class Base64Util {

	/**
	 * base64编码
	 * 
	 * @param filepath
	 * @return
	 */
	public static String fileToBase64(String filepath) {
		byte[] bytes = null;
		try {
			InputStream inputStream = new FileInputStream(filepath);
			bytes = new byte[inputStream.available()];
			inputStream.read(bytes);
			inputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new BASE64Encoder().encode(bytes);
	}

}
