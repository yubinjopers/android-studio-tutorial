package kr.ai.customview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;

public class MainActivity extends AppCompatActivity {

    MyView myView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //myView 생성
        myView = new MyView(this);

        // main activity를 myView로 설정
        setContentView(myView);
    }
}