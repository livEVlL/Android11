package com.org.iii.android11;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDBhelper extends SQLiteOpenHelper {
    private String createTable =
            "CREATE TABLE cust (id INTEGER PRIMARY KEY AUTOINCREMENT,cname TEXT,birthday DATE,tel TEXT)";


    public MyDBhelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqdb) {
        sqdb.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}