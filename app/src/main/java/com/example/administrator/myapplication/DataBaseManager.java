package com.example.administrator.myapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Administrator on 2016-12-03.
 */

public class DataBaseManager extends SQLiteOpenHelper {
    private static final String DB_NAME = "schedule.db";
    private static final int DATABASE_VERSION = 1;

    public DataBaseManager(Context context){
        super(context, DB_NAME, null, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db){
        db.execSQL("CREATE TABLE schedule(" +
                "seq Integer NOT NULL PRIMARY KEY,"+
                "title TEXT NULL,"+
                "memo TEXT NULL,"+
                "location TEXT NULL" +
                "start_datetime DATETIME NULL," +
                "end_datetime DATETIME NULL" +
                ");");
    }

    public void onUpgrade(SQLiteDatabase db, int i, int i1){

    }
}
