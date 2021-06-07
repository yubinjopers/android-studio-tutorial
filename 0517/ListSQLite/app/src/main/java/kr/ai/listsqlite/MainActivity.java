package kr.ai.listsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private ArrayList<Person> listdata;
    private ArrayAdapter<Person> adapter;

    MyDB myDB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listview);

        listdata = new ArrayList<Person>();
        listdata.add(new Person("test"));

        adapter = new ArrayAdapter<Person>
                (this, android.R.layout.simple_list_item_1, listdata);

        // listview와 adapter연결
        listView.setAdapter(adapter);

        myDB = new MyDB(this);
        myDB.open();
    }

    public void onButtonClicked(View v)
    {
        switch (v.getId())
        {
            case R.id.btnInsert:
                myDB.insertData("john");
                Log.i(MyDB.TAG, "btnInsert");
                break;
            case R.id.btnSelect:
                Log.i(MyDB.TAG, "btnSelect");
                Cursor data = myDB.selectData();
                // 받은 데이터를 list 추가
                for(int i = 0; i != data.getCount(); ++i)
                {
                    data.moveToNext();
                    String name = data.getString(0);
                    myDB.debugPrint("[" + i + "]" + name);
                    //
                    // listdata.add(name);
                    Person tmp = new Person(name);
                    listdata.add(tmp.getName());
                }
                adapter.notifyDataSetChanged();
                //항상 마지막 list set
                listView.setSelection(listdata.size());
                break;
        }
    }
}