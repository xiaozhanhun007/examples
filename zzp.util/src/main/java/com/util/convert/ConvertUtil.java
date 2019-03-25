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

	/**
	 * 将各种类型的数据转换成用原生SQL的insert语句可以用的value
	 * 
	 * @param t 
	 * 
	 * @return 如果t为null，则返回"NULL"对应SQL的NULL，如果不为空，则将其转换为"'value'"的格式
	 */
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
	
	/**
	 * 1、去除字符串的空格，制表符，换行等符号
	 * 2、将中文逗号"，"转换成","
	 * 
	 * @param str
	 * @return String
	 */
	public static String trimSpace(String str) {
    	if (str == null) return null;
		String tempVal = str.trim();
		tempVal = tempVal.replaceAll("，", ",");//处理中文逗号
		tempVal = tempVal.replaceAll("\\r|\\n|\\s|\\t", "");//去掉换行和字符串中间空格
		return tempVal;
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

		//=========================
		System.out.println(trimSpace("  dd  zzz  dddgg   				"));
	}
	
}
