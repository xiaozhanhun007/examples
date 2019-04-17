package com.util.date;

import com.github.houbb.paradise.common.util.StringUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 时间工具类
 * 
 * @author zzp
 * @since 2018.09.30
 *
 */
public class DateUtil {
	
	private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	private static SimpleDateFormat timeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	public static String FORMAT_yyyy_MM_dd_HH_mm_ss = "yyyy-MM-dd HH:mm:ss";
	public static String FORMAT_yyyy_MM_dd_HH_mm = "yyyy-MM-dd HH:mm";
	public static String FORMAT_yyyy_MM_dd = "yyyy-MM-dd";
	public static String FORMAT_yyyy_MM = "yyyy-MM";
	public static String FORMAT_MM = "MM";
	public static String FORMAT_dd = "dd";
	public static String FORMAT_yyyy = "yyyy";
	public static String FORMAT_yyyyMMddHHmmss = "yyyyMMddHHmmss";
	public static String FORMAT_yyyyMMdd = "yyyyMMdd";
	public static String FORMAT_yyyy_MM_dd_HH = "yyyy-MM-dd HH";
	public static String FORMAT_yyMMdd = "yyMMdd";
	public static String FORMAT_HH_mm_ss = "HH:mm:ss";

	public static void main(String[] args) {
//		System.out.println(getLastMonthFirstDay());
//		System.out.println(getLastMonthLastDay());
//		System.out.println(getDayByNum("2018-09-30", -7));
		System.out.println(getMonthLastDay("2018-08-1-01"));
	}
	
	/**
	 * 获得上一个月的第一天
	 * 
	 * @return String
	 */
	public static String getLastMonthFirstDay() {
		try {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(dateFormat.parse("2018-05-15"));
			calendar.add(Calendar.MONTH, -1);
			calendar.set(Calendar.DAY_OF_MONTH, 1);
			return dateFormat.format(calendar.getTime());
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 获得上一个月的最后一天
	 * 
	 * @return String
	 */
	public static String getLastMonthLastDay() {
		try {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(dateFormat.parse("2018-05-15"));
			calendar.set(Calendar.DAY_OF_MONTH, 1); 
			calendar.add(Calendar.DATE, -1);
			return dateFormat.format(calendar.getTime());
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 根据date来获取当前月的最后一天
	 * 
	 * @param date 日期字符串
	 * 
	 * @return String
	 */
	public static String getMonthLastDay(String date) {
		try {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(dateFormat.parse(date));
			calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
			return dateFormat.format(calendar.getTime());
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 
	 * @param dateStr
	 * @param num
	 * @return
	 */
	public static String getDayByNum(String dateStr, int num) {
		try {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(dateFormat.parse(dateStr));
			calendar.add(Calendar.DATE, num);
			return dateFormat.format(calendar.getTime());
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 将分钟数转换成X天 Xh Xmin的格式
	 *
	 * @param num 分钟数
	 * @return String
	 */
	public static String convertMinToStr(long num) {
		long minute = 0;
		long hour = 0;
		long day = 0;

		if (num > 0) {
			minute = num % 60;
			num -= minute;
			if (num > 0) {
				num /= 60;
				hour = num % 24;
				num -= hour;
				if (num > 0) {
					day = num / 24;
				}
			}
		}

		if (day > 0) {
			return day + "天" + hour + "h" + minute + "min";
		} else if (hour > 0) {
			return hour + "h" + minute + "min";
		} else {
			return minute + "min";
		}
	}

	/**
	 * 将字符串转换为Date
	 * @param dateString
	 * @param format
	 * @return Date
	 */
	public static Date convertStringToDate(String dateString, String format) {
		Date date = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			if (!StringUtil.isBlank(dateString)) {
				date = sdf.parse(dateString);
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	
}
