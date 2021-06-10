package com.example.mlab6;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "farmDb.db";

    public static final String TABLE_FARM = "Farm";

    public static final String KEY_ID = "_id";
    public static final String KEY_NAME = "name";
    public static final String KEY_SEASON = "season";
    public static final String KEY_PERIOD = "period";
    public static final String KEY_AVARANGE = "avarange";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create Table Farm (_id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, season TEXT, period TEXT, avarange INTEGER);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop Table if exists Farm");

        onCreate(db);
    }


}
