package com.example.wangguanghong.datemode;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.wangguanghong.datemode.Utils.CalendarUtil;

public class MainActivity extends AppCompatActivity {
    private VDate mToday;
    private long today;
    private int mShowDays=100;
    private List<DateItem> list=new ArrayList<>();
    private RecyclerView mRecyclerView;
    private DateAdapter mDateAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initShowDate();
    }

    private void initView() {
        mRecyclerView=(RecyclerView)findViewById(R.id.date);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this,7));
    }

    private void initShowDate() {
        Calendar calendar=Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY,0);
        calendar.set(Calendar.MINUTE,0);
        calendar.set(calendar.SECOND,0);
        today=calendar.getTimeInMillis();
        mToday=new VDate(new Date(today));
        for(int i=1;i< CalendarUtil.getWeek(mToday.getYear(),mToday.getMonth(),mToday.getDay());i++){//从本周开始展示，加入月初判断
            DateItem dateitem=new DateItem();
            if(mToday.getDay()-CalendarUtil.getWeek(mToday.getYear(),mToday.getMonth(),mToday.getDay())+i>0){
                dateitem.setDate((mToday.getDay()-CalendarUtil.getWeek(mToday.getYear(),mToday.getMonth(),mToday.getDay())+i)+"");
                dateitem.setType(1);
            }else{
                dateitem.setType(0);
            }
            list.add(dateitem);
        }

        for(int i=0;i<mShowDays;i++){
            DateItem dateitem=new DateItem();
            VDate curDay=new VDate(DateUtil.getDateLast(mToday.getYear(),mToday.getMonth(),mToday.getDay(),i));
            if(curDay.getDay()==1){ //下个月开始的每个月第一天
                if((CalendarUtil.getWeek(curDay.getYear(),curDay.getMonth(),curDay.getDay()))!=1&&curDay.getDay()!=mToday.getDay()){
                    for(int j=0;j<7;j++){
                        DateItem emptyitem=new DateItem();
                        emptyitem.setType(0);
                        list.add(emptyitem);
                    }
                }
                DateItem mouthitem=new DateItem();
                mouthitem.setType(2);
                mouthitem.setDate(curDay.getMonth()+"");
                list.add(mouthitem);
                for(int j=0;j<6;j++){
                    DateItem emptyitem=new DateItem();
                    emptyitem.setType(0);
                    list.add(emptyitem);
                }
            }
            dateitem.setDate(curDay.getDay()+"");
            dateitem.setType(1);
            list.add(dateitem);
        }
        initShowAdapter();
    }

    private void initShowAdapter() {
        Log.e("aads",list.size()+"");
        mDateAdapter=new DateAdapter(this,list);
        mRecyclerView.setAdapter(mDateAdapter);
    }
}
