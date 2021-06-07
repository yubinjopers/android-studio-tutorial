package kr.ai.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // 화면 보여주는 부분
    private ListView listView;
    // listview 데이터관리
    private ArrayAdapter<String> adapter;
    // 실제 데이터
    private ArrayList<String> listdata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 레이아웃과 소스 연결
        listView = findViewById(R.id.listview);

        // listdata에 데이터 추가
        // 생성
        listdata = new ArrayList<String>();
        listdata.add("list1");
        listdata.add("list2");
        listdata.add("list3");

        // list 데이터 관리 (adapter)
        adapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1, listdata);

        // listview와 데이터 연결
        listView.setAdapter(adapter);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        // listdata 아이템 추가
        listdata.add(String.format("list%d", listdata.size()));
        // adapter에 아이템 추가 반영 (update)
        adapter.notifyDataSetChanged();
        // listview에서  가장 마지막 아이템 선택
        listView.setSelection(listdata.size());

        return true;
    }
}