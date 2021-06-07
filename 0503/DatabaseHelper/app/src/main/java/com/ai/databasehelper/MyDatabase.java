package com.ai.databasehelper;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;
import android.util.Log;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;
import android.util.Log;

import java.net.PortUnreachableException;

public class MyDatabase {
    public static final String TAG = "MyDatabase";

    public static final String DATABASE_NAME = "employee.db";
    public static final int DATABASE_VERSION = 1;

    public static final String TABLE_NAME = "emp";
    public static final String DROP_TABLE_SQL
            = "drop table if exists " + TABLE_NAME;
    public static final String CREATE_SQL = "create table"
            + TABLE_NAME + "("
            + Table._ID + " integer PRIMARY KEY autoincrement,"
            + Table.NAME + " text, "
            + Table.AGE + " integer, "
            + ")";

    private DatabaseHelper myDatabaseHelper;
    private SQLiteDatabase myDatabase;
    private Context context;

    public interface Table extends BaseColumns {
        public static final String NAME = "name";
        public static final String AGE = "age";
    }

    public void LogMsg(String msg) {
        Log.i(TAG, msg);
    }

    public MyDatabase(Context context) {
        this.context = context;
    }

    public boolean open() {
        myDatabaseHelper = new DatabaseHelper(context,
                DATABASE_NAME, null, DATABASE_VERSION);
        myDatabase = myDatabaseHelper.getWritableDatabase();
        return true;
    }

    public Cursor selectData(){
        Cursor data;
        String selectSql = "select name, age from "+TABLE_NAME;
        data = myDatabase.rawQuery(selectSql,null);
        int count = data.getCount();
        LogMsg("selectData:"+count );
        return data;
    }

    public boolean insertData(String name, int age){
        String query="insert into "+TABLE_NAME
                +" (name,age) values('name' , 20) ";
        myDatabase.execSQL(query);
        LogMsg("insertData:"+query);
        return true;
    }

    public boolean close(){
        myDatabase.close();
        myDatabase = null;
        return true;
    }
}
