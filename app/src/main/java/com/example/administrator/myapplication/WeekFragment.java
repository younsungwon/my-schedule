package com.example.administrator.myapplication;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016-12-02.
 */

public class WeekFragment extends Fragment {

    private GridView gridView;
    private TextView textView;

    public WeekFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

        View rootView = inflater.inflate(R.layout.activity_week_schedule, container, false);
        gridView = (GridView) rootView.findViewById(R.id.week_grid);
        return rootView;
    }
}

class WeekGrid extends BaseAdapter{

    ArrayList<String> data;
    Context mContext;
    private LayoutInflater inflater = null;

    public WeekGrid(Context context, ArrayList<String> data){
        this.mContext = context;
        this.data = data;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public View getView(int position, View view, ViewGroup parent){

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
}