package com.example.administrator.myapplication;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private DataBaseManager dataBaseManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setFragmentById(R.layout.activity_calendar);

        dataBaseManager = new DataBaseManager(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        switch (item.getItemId()){
            /*일정 작성*/
            case R.id.menu_reg_schedule :
                Intent intent = new Intent(getApplicationContext(), RegScheduleActivity.class);
                startActivity(intent);

                return true;
            /*DAY*/
            case R.id.menu_day :
                setFragmentById(R.layout.activity_daily_schedule);
                actionBar.setTitle("일별 보기");
                return true;
            /*Week*/
            case R.id.menu_week :
                setFragmentById(R.layout.activity_week_schedule);
                actionBar.setTitle("주별 보기");
                return true;
            /*Month*/
            case R.id.menu_month :
                setFragmentById(R.layout.activity_calendar);
                actionBar.setTitle("월별 보기");
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    final CalenderFragment calenderFragment = new CalenderFragment();
    final WeekFragment weekFragment = new WeekFragment();
    final DailyFragment dailyFragment = new DailyFragment();

    private void setFragmentById(int fragment){
        final android.app.FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        if(fragment == R.layout.activity_calendar){
            fragmentTransaction.replace(R.id.fragment, calenderFragment);
        }else if(fragment == R.layout.activity_week_schedule){
            fragmentTransaction.replace(R.id.fragment, weekFragment);
        }else if(fragment == R.layout.activity_daily_schedule){
            fragmentTransaction.replace(R.id.fragment, dailyFragment);
        }
        fragmentTransaction.commit();
    }
}
