package kr.ai.intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class SubActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        //intent로 데이터 받기
        Intent intent = getIntent();
        String str = intent.getStringExtra(MainActivity.KEY_NAME);
        int age = intent.getIntExtra(MainActivity.KEY_AGE, 0);

        Toast.makeText(this, "msg : " + str + " " + age, Toast.LENGTH_SHORT).show();
    }

    public void onButtonClicked(View view)
    {
        // 1. intent 생성
        // MainActivity에세 데이터 전달
        Intent intent = new Intent();


        // 2. intent에 전달한 데이터 저장
        intent.putExtra("SUB", "hi main");

        // 3. SubActivity 종료 결과
        setResult(RESULT_OK, intent);

        // 3. 종료
        finish();
    }
}