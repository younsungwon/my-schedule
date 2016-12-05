package com.example.administrator.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Created by Administrator on 2016-11-27.
 */

public class CalendarAdapter extends BaseAdapter {

    private Context mContext;
    private int layout = 0;
    private ArrayList<DateScedule> data = null;
    private LayoutInflater inflater = null;

    public CalendarAdapter(Context context, int i, ArrayList<DateScedule> list){
        this.mContext = context;
        this.layout = i;
        this.data = list;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    /*Calander 하나*/
    public View getView(int position, View view, ViewGroup parent){

        ViewHolder holder = null;

        if(view == null){
            view = inflater.inflate(this.layout, parent, false);
            holder = new ViewHolder();
            holder.tvItemGridView = (TextView) view.findViewById(R.id.tv_date);
        }else{
            holder = (ViewHolder) view.getTag();
        }
        TextView textView = (TextView) view.findViewById(R.id.tv_date);
        ListView listView = (ListView) view.findViewById(R.id.lv_date);

        if(position % 7 == 0){ //일요일
            textView.setTextColor(mContext.getResources().getColor(R.color.color_ff0000, null));
        }else if(position % 7 ==6){ //토요일
            textView.setTextColor(mContext.getResources().getColor(R.color.color_0000ff, null));
        }

        textView.setText(data.get(position).getDate()); //날짜 Set

        return view;
    }

    /*position Obj return*/
    public Object getItem(int position){
        return data.get(position);
    }

    /*get data Size*/
    public int getCount(){
        return data.size();
    }

    public long getItemId(int position){
        return position;
    }

    private class ViewHolder{
        TextView tvItemGridView;
    }
}
