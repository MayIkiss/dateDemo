package com.example.wangguanghong.datemode;


import com.example.wangguanghong.datemode.Utils.CalendarUtil;

import java.util.Date;

public class DateUtil {

	/**
	 * 
	 * @param year 从0开始
	 * @param month
	 * @param day
	 * @param last
	 * @return
	 */
	public static Date getDateLast(int year, int month, int day, int last){
		Date targetDate = new Date(year - 1900, month - 1, day);
		long addTime =(((long)last) * 24 * 3600 * 1000);
		long currentTime  = targetDate.getTime();
		long lastTime =currentTime + addTime;
		Date date = new Date(lastTime);
		return date;
	}
	
	public static boolean isDate(int year,int month,int day){
		int maxDay = CalendarUtil.getMonthMaxDay(year,month);
		return day <= maxDay;
	}
}
