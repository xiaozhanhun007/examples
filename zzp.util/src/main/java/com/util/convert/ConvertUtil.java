package com.util.convert;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 转换工具类
 * 
 * @author karyzeng
 * @since 2018.09.07
 *
 */
public class ConvertUtil {
	
	private static SimpleDateFormat smft = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	public static <T> String convertInsertParam(T t) {
		if (t != null) {
			Class clazz = t.getClass();
			if (clazz.equals(String.class) || clazz.equals(Integer.class)) {
				String value = t.toString();
				return "'" + value + "'";
			} else if (clazz.equals(Date.class)) {
				Date value = (Date) t;
				return "'" + smft.format(value) + "'";
			}
		}
		return "NULL";
	}
	
	public static void main(String[] args) {
		int a = 12;
		String b = "zzz";
		Date date = new Date();
		Integer d = new Integer(56);
		System.out.println(convertInsertParam(a));
		System.out.println(convertInsertParam(b));
		System.out.println(convertInsertParam(date));
		System.out.println(convertInsertParam(d));
		System.out.println(convertInsertParam(null));
	}
	
}
