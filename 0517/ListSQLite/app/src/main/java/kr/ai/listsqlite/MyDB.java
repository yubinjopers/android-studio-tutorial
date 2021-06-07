package kr.ai.listsqlite;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;
import android.util.Log;

import androidx.annotation.Nullable;

public class MyDB {
    public static final String TAG = "MyDB";

    public static final String DB_NAME = "mydb";
    public static final int DB_VER = 1;

    public static final String TABLE_NAME = "iot";
    public static final String DROP_TABLE_SQL =
            "drop table if exists "
            + TABLE_NAME;
    public static final String CREATE_SQL =
            "create table "
            + TABLE_NAME
            + "( "
            + MyTable._ID
            + "integer PRIMARY KEY autoincrement,"
            + MyTable.NAME
            + " text "
            + ")";

    public interface MyTable extends BaseColumns
    {
        public static final String NAME = "name";
    }

    private MyHelper myHelper;
    private SQLiteDatabase mDB;
    private Context mContext;

    public void debugPrint(String msg)
    {
        Log.i(TAG, msg);
    }

    public MyDB(Context context)
    {
        mContext = context;
    }

    public void open()
    {
        if(myHelper == null)
        {
            myHelper = new MyHelper(mContext, DB_NAME, null, DB_VER);
        }

        mDB = myHelper.getWritableDatabase();

        myHelper = new MyHelper(mContext, DB_NAME, null, DB_VER);
        mDB = myHelper.getWritableDatabase();
    }

    public void close()
    {
        if(mDB != null)
        {
            mDB.close();
            mDB = null;
        }
    }

    public void insertData(String name)
    {
        String sql
                = "insert into "
                + TABLE_NAME
                + " ( name ) values( "
                + "'em1'"
                + ")";

        mDB.execSQL(sql);
    }

    public Cursor selectData()
    {
        Cursor data;
        String sql = "select name from " + TABLE_NAME;
        data = mDB.rawQuery(sql, null);
        int count = data.getCount();
        debugPrint("selectData : " + count);

        return data;
    }

    private class MyHelper extends SQLiteOpenHelper {
        public MyHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
            super(context, MyDB.DB_NAME, null, MyDB.DB_VER);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(MyDB.CREATE_SQL);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            if(newVersion > 1)
            {
                db.execSQL(MyDB.DROP_TABLE_SQL);
            }
        }
    }
}
