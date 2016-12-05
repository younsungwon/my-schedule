package com.example.administrator.myapplication;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016-11-27.
 */

public class DateScedule {
    String date;
    ArrayList<String> dateScedule;

    public String getDate(){
        return date;
    }

    public void setDate(String date){
        this.date = date;
    }

    public ArrayList<String> getDateScedule(){
        return dateScedule;
    }

    public void setDateScedule(ArrayList<String> dateScedule){
        this.dateScedule = dateScedule;
    }
}
