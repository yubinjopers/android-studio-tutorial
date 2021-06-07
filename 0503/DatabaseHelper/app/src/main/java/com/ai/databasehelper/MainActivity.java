package com.ai.databasehelper;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edDataName;
    EditText edTableName;
    TextView tvMsg;

    String dbName;
    String tableName;

    MyDatabase myDatabase;

    //db에 필요한 클래스
    // SQLiteDatabase database;
    // DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edDataName = findViewById(R.id.editTextDB);
        edTableName = findViewById(R.id.editTextTABLE);
        tvMsg = findViewById(R.id.textView);

        myDatabase =new  MyDatabase(this);

    }

    public void onButtonClicked(View view){

        switch(view.getId()){
            case R.id.btnDB:
                dbName = edDataName.getText().toString();
                Toast.makeText(this,dbName,Toast.LENGTH_LONG).show();
                tvMsg.append("\n"+dbName);
                createDatabase(dbName);

                break;
            case R.id.btnTABLE:
                tableName = edTableName.getText().toString();
                Toast.makeText(this,tableName,Toast.LENGTH_LONG).show();
                tvMsg.append("\n"+tableName);
                createTable(tableName);
                insertRecord();
                break;
            case R.id.button://data 조회하기
                executeQuery();
                break;
        }

    }

    private void createDatabase(String name){
        println("createDatabase() ");
        myDatabase.open();
        //  databaseHelper = new DatabaseHelper(this,
        //           null,null,1);
        //   database = databaseHelper.getWritableDatabase();
        println("createDatabase() 생성 "+name);
    }

    private void createTable(String name){
        println("createTable()");
        //myDatabase.open(); table 만듬.
    /*    if(database==null){
            println("database == null");
            return ;
        }
        tableName = name;
        database.execSQL("create table if not exists "+
                name +" ("
                +" _id integer PRIMARY KEY autoincrement, "
                +" name text, "
                +" age integer, "
                +" mobile text)");

     */
        println("table 생성 :"+name);
    }

    private void insertRecord(){
        println("insertRecord()");
        myDatabase.insertData("test",20);
      /*  if(database==null){
            println("database==null");
            return;
        }
        if(tableName==null){
            println("tableName==null");
            return;
        }
        database.execSQL("insert into "+tableName
             +" (name, age, mobile) "
             +  " values "
             +   "('john',20,'010-1234-5678')");

       */
        println("record추가함");
    }

    public void executeQuery(){
        println("executeQuery()");

        Cursor cursor = myDatabase.selectData();

        //db에 쿼리 보내기
     /*   Cursor cursor = database.rawQuery("select _id, " +
                "name, age, mobile from "
                +"emp",null);
        int recordCount = cursor.getCount();
        println("레코드 개수 : "+recordCount);

        //레코드 읽어오기
        for( int i=0; i < recordCount; ++i){
            cursor.moveToNext();//다음
            int id = cursor.getInt(0);//id
            String name = cursor.getString(1);//name
            int age = cursor.getInt(2);
            String mobile = cursor.getString(3);
            println("#"+i+":"+id+","+name+","+age+","+mobile);
        }
        cursor.close();

      */
    }

    public void println(String data){
        tvMsg.append(data+"\n");
        Log.i("exdb",data);
    }
}