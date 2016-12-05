package com.example.administrator.myapplication;

import android.content.Intent;
import android.database.SQLException;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Administrator on 2016-12-04.
 */

public class RegScheduleActivity extends AppCompatActivity {

    final static String TAG = "REGSCHEDULE";
    private DataBaseManager dataBaseManager;
    private EditText title;
    private EditText location;
    private TextView st_datetime;
    private TextView ed_datetime;
    private EditText memo;

    private Calendar mCal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("일정 등록");
        setContentView(R.layout.activity_reg_schedule);

        initView();
        dataBaseManager = new DataBaseManager(this);
        st_datetime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), CalendarDialog.class);
                startActivity(intent);
            }
        });

        ed_datetime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), CalendarDialog.class);
                startActivity(intent);
            }
        });
    }

    void initView(){
        title = (EditText) findViewById(R.id.et_title);
        location = (EditText) findViewById(R.id.et_location);
        memo = (EditText) findViewById(R.id.et_memo);
        st_datetime = (TextView) findViewById(R.id.et_start_datetime);
        ed_datetime = (TextView) findViewById(R.id.et_end_datetime);

        long now = System.currentTimeMillis();
        final Date date = new Date(now);

        /*년, 월, 일을 따로 저장*/
        final SimpleDateFormat curYearFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm", Locale.KOREA);

        mCal = Calendar.getInstance();
        st_datetime.setText(curYearFormat.format(date));
        ed_datetime.setText(curYearFormat.format(date));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_reg, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        final Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        switch (item.getItemId()){
            /*일정 작성*/
            case R.id.menu_reg_action :
                item.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        try{
                            String sql = String.format(
                                    "INSERT INTO schedule (seq, title, location, memo) VALUES (NULL, '%s', '%s')",
                                    title.getText(), location.getText()
                            );
                            dataBaseManager.getWritableDatabase().execSQL(sql);
                        }catch (SQLException e){
                            Log.e(TAG, "Error Inserting into DB");
                        }
                        intent.putExtra("result",true);
                        startActivity(intent);
                        return false;
                    }
                });
                return true;

            case R.id.menu_cancel_action :
                item.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        startActivity(intent);
                        return false;
                    }
                });
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
