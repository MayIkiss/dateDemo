package com.example.wangguanghong.datemode;

import java.io.Serializable;

/**
 * Created by wangguanghong on 2016/12/16.
 */
public class DateItem implements Serializable{
    private String date;
    private int type;//判断月份，日期和是否为空

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
