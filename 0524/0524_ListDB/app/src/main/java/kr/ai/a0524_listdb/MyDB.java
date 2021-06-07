package kr.ai.a0524_listdb;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;
import android.util.Log;

import androidx.annotation.Nullable;

public class MyDB {

    // debugging
    public static final String TAG = "MYDB";
    public static final String DATABASE_NAME = "person";
    public static final int DATABASE_VERSION = 1;
    public static final String TABLE_NAME = "iot";
    public static final String DROP_TABLE_SQL = "drop table if exists " + TABLE_NAME;

    // DB연결 class
    private DBHelper mDBHelper;
    // db
    private SQLiteDatabase mDB;
    private Context mContext;

    public interface TablePerson extends BaseColumns
    {
        public static final String NAME = "name";
        public static final String AGE = "age";
    }

    public void dbPrint(String msg)
    {
        Log.i(TAG, msg);
    }

    public MyDB(Context context)
    {
        mContext = context;
    }

    public void open()
    {
        // DATABASE OPEN
        mDBHelper = new DBHelper(mContext, DATABASE_NAME, null, DATABASE_VERSION);

        // DB 가져오기
        mDB = mDBHelper.getWritableDatabase();
    }

    public void insert(String name, int age)
    {

        ContentValues values = new ContentValues();
        values.put(TablePerson.NAME, name);
        values.put(TablePerson.AGE, age);
        mDB.insert(TABLE_NAME, null, values);
        /*
        *String sql
                = "insert into "
                + TABLE_NAME
                + " (name, age) values( "
                //+ name
                //+ ","
                //+ age
                + "'tom', 21"
                +")";

          mDB.execSQL(sql);
        * */
    }

    public Cursor selectAll()
    {
        Cursor data;
        data = mDB.query(TABLE_NAME, null, null,
                null, null, null, null);

        /*
        * String sql
                = "select name, age from "
                + TABLE_NAME;

        // DB에 접근하여 퀴리 수행
        data = mDB.rawQuery(sql, null);
        dbPrint("select All : " + data.getCount());
        *
        * */


        return data;
    }

    public void deleteName(String n)
    {
        mDB.delete(TABLE_NAME, "name=? AND age=?", new String[]{"tom", "21"});
    }

    // DB 생성 및 버전 관리
    private class DBHelper extends SQLiteOpenHelper
    {

        public DBHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, factory, version);
            dbPrint("DBHelper()");
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            // DB 생성
            String CREATE_SQL
                    = "create table "
                    + TABLE_NAME
                    + " ("
                    + TablePerson._ID
                    + " integer PRIMARY KEY autoincrement ,"
                    + TablePerson.NAME
                    + " text, "
                    + TablePerson.AGE
                    + " integer "
                    + ")";

            //db.execSQL(DROP_TABLE_SQL);
            db.execSQL(CREATE_SQL);
            dbPrint("create SQL");
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            if(newVersion > 1)
            {
                // drop
                db.execSQL(DROP_TABLE_SQL);
                dbPrint(DROP_TABLE_SQL);
            }
        }
    }
}
