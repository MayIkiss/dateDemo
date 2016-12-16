package com.example.wangguanghong.datemode;

import java.io.Serializable;
import java.util.Date;

public class VDate implements Serializable {

	private static final long serialVersionUID = 1L;
	private int mYear;
	private int mMonth;
	private int mDay;

	private VDate(){
		
	}
	
	public VDate(Date date){
		super();
		setDate(date.getYear() + 1900, date.getMonth() + 1, date.getDate());
	}

	/**
	 * 
	 * @param year
	 * @param mouth
	 * @param day
	 * @return if the params is not right for a date,return false
	 */
	private boolean setDate(int year,int mouth,int day){
		if(!checkDate(year, mouth, day)){
			return false;
		}
		mYear = year;
		mMonth = mouth;
		mDay = day;
		return true;
	}

	public int getDay(){
		return mDay;
	}
	
	public int getMonth(){
		return mMonth;
	}
	
	public int getYear(){
		return mYear;
	}
	
	private boolean checkDate(int year,int month,int day){
		return DateUtil.isDate(year, month, day);
	}
}
