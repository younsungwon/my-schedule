package com.example.administrator.myapplication;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Administrator on 2016-11-27.
 */
public class CalenderFragment extends Fragment {
    private GridView gridView;
    private TextView textView;
    private CalendarAdapter calendarAdapter;
    private Calendar mCal;
    CalendarAdapter adapter = null;

    /*Require Empty Constructor*/
    public CalenderFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

        View rootView = inflater.inflate(R.layout.activity_calendar, container, false);
        gridView = (GridView) rootView.findViewById(R.id.calendar_grid);
        textView = (TextView) rootView.findViewById(R.id.tv_date);

        ArrayList<DateScedule> data = getBasicCalendar();
        adapter = new CalendarAdapter(rootView.getContext(), R.layout.calendar_grid, data);
        gridView.setAdapter(adapter);

        return rootView;
    }

    public ArrayList<DateScedule> getBasicCalendar(){
        ArrayList<DateScedule> list = new ArrayList<DateScedule>();

        /*오늘 날짜를 세팅해준다.*/
        long now = System.currentTimeMillis();
        final Date date = new Date(now);

        /*년, 월, 일을 따로 저장*/
        final SimpleDateFormat curYearFormat = new SimpleDateFormat("yyyy", Locale.KOREA);
        final SimpleDateFormat curMonthFormat = new SimpleDateFormat("MM", Locale.KOREA);
        final SimpleDateFormat curDayFormat = new SimpleDateFormat("dd", Locale.KOREA);

        /*텍스트뷰 셋팅*/
        textView.setText(curYearFormat.format(date)+"/"+curMonthFormat.format(date));

        mCal = Calendar.getInstance();
        /*달 1일이 무슨 요일인지 판단*/
        mCal.set(Integer.parseInt(curYearFormat.format(date)), Integer.parseInt(curMonthFormat.format(date))-1,1);
        int dayNum = mCal.get(Calendar.DAY_OF_WEEK);

        /*String[] weekDay = {"일","월","화","수","목","금","토"};
        for(int i=0; i<7; i++){
            DateScedule dateScedule = new DateScedule();
            dateScedule.setDate(weekDay[i]);
            list.add(dateScedule);
        }*/

        /*1일 이전까지 공백*/
        for(int j=1; j<dayNum; j++){
            DateScedule dateScedule = new DateScedule();
            dateScedule.setDate("");
            list.add(dateScedule);
        }

        for(int k=1; k<=mCal.getMaximum(Calendar.DAY_OF_MONTH); k++){
            DateScedule dateScedule = new DateScedule();
            dateScedule.setDate(String.valueOf(k));
            list.add(dateScedule);
        }

        return list;
    }
}
