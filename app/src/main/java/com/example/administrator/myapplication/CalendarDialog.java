package com.example.administrator.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Toast;

import java.util.Date;

/**
 * Created by Administrator on 2016-12-05.
 */

public class CalendarDialog extends Activity implements View.OnClickListener{

    private CalendarView calendarView;
    private Button btnSelectDate;
    private Button btnCancelDate;

    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.calendar_dialog);

        calendarView = (CalendarView) findViewById(R.id.calendar_view);
        btnSelectDate = (Button) findViewById(R.id.btn_select_date);
        btnCancelDate = (Button) findViewById(R.id.btn_cancel_date);

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {

            }
        });

        btnSelectDate.setOnClickListener(this);
        btnCancelDate.setOnClickListener(this);
    }

    public void onClick(View v){
        Date date = new Date(calendarView.getDate());
        String dateStr = date.toString();
        switch (v.getId()){
            case R.id.btn_cancel_date :
                this.finish();
                break;
            case R.id.btn_select_date :
                Toast.makeText(this, dateStr, Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
