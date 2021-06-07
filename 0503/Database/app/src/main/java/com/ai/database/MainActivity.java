package com.ai.database;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //db사용하기 위한 db
    SQLiteDatabase database;
    final static String tableName="mytable";
    final static String TAG="MainActivity";
    TextView textViewLogMsg;
    //db 관련 함수
    //db 생성 또는 open
    private void createDatabase(String name){
        LogMsg("createDatabase() 호출됨");
        database = openOrCreateDatabase(name, MODE_PRIVATE,null);
        LogMsg("createDatabase() 생성 : "+name);
    }

    //table 생성
    private void createTable(String name){
        LogMsg("createTable() 호출됨");
        if(null==database){//db 유무 확인
            LogMsg("database 먼저 만드세요");
            return;
        }
        //table 만들기
        database.execSQL("create table if not exists "+name+"(_id integer PRIMARY KEY autoincrement, "+" name text, "+" age integer,"+" mobile text)");

        LogMsg("createTable() 생성"+name);
    }
    //data 넣기(레코드 추가)
    private void insertRecord(){
        LogMsg("insertRecord() 호출됨");
        if(database==null){
            LogMsg("db 생성을 먼저 해주세요");
            return;
        }
        if(tableName==null){
            LogMsg("table 생성을 먼저 해주세요");
            return;
        }
        //record추가하기
        database.execSQL("insert into "+tableName+"( name, age, mobile )"+"values "+"('John',20,'010-1234-5678')");
        LogMsg("insertRecord() 추가됨");
    }

    //debug message출력용 함수
    private void LogMsg(String msg){
        Log.i(TAG,msg);
        textViewLogMsg.append("\n"+msg);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textViewLogMsg=findViewById(R.id.textView);
    }
    public void onButtonClick(View view){
        switch(view.getId()){
            case R.id.btnInsert:
                LogMsg("btInsert + database생성");
                this.createDatabase("mydb");
                this.createTable(tableName);
                break;
            case R.id.btnSelect:
                LogMsg("btSelect+insert 레코드");
                this.insertRecord();
                break;
        }
    }
}