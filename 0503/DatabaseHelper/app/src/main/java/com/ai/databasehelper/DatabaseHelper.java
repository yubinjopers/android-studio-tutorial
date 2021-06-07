package com.ai.databasehelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

//db관리(버젼관리)
public class DatabaseHelper extends SQLiteOpenHelper {



    public DatabaseHelper(@Nullable Context context,
                          @Nullable String name,
                          @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        println("onCreate()-dbhelper");

        String sql = "create table if not exists emp("
                +" _id integer PRIMARY KEY autoincrement,"
                +" name text,"
                +" age integer, "
                +" mobile text)";

        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db,
                          int oldVersion,
                          int newVersion) {
        println("onUpgrade() : "+oldVersion+"->"+
                newVersion);
        if( newVersion > 1) {
            db.execSQL("DROP TABLE IF EXISTS emp");
        }
    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
        println("onOpen() -dbhelper");
    }

    public void println(String data){
        Log.i("exdb",data);
    }
}
