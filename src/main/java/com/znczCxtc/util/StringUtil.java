package com.znczCxtc.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class StringUtil {

	public static String decode(String s,String enc) {
		//https://www.cnblogs.com/zh-1721342390/p/9266999.html
		String str=null;
		try {
			str=URLDecoder.decode(s,enc);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			return str;
		}
	}
}
