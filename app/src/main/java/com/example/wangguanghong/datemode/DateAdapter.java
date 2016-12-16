package com.example.wangguanghong.datemode;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by wangguanghong on 2016/12/16.
 */
public class DateAdapter extends RecyclerView.Adapter<DateAdapter.ViewHolder>{
    private Context mContext;
    private List<DateItem> dateItems;

    public DateAdapter(){
        super();
    }

    public DateAdapter(Context context,List<DateItem> dateitems){
        this.mContext=context;
        this.dateItems= dateitems;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=((Activity)mContext).getLayoutInflater().inflate(R.layout.activity_date_item,null);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.textView.setVisibility(View.VISIBLE);
        if(dateItems.get(position).getType()==0){
            holder.textView.setVisibility(View.INVISIBLE);
        }else if(dateItems.get(position).getType()==1){
            holder.textView.setText(dateItems.get(position).getDate());
        }else if(dateItems.get(position).getType()==2){
            holder.textView.setText(dateItems.get(position).getDate()+"月");
        }
    }

    @Override
    public int getItemCount() {
        return dateItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView textView;
        public ViewHolder(View itemView) {
            super(itemView);
            textView=(TextView)itemView.findViewById(R.id.item_info);
        }
    }
}
