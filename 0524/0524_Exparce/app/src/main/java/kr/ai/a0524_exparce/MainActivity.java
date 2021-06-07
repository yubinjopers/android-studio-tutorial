package kr.ai.a0524_exparce;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    public static final String KEY_MAIN = "main";
    public static final String KEY_SUB = "sub";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onButtonClicked(View view)
    {
        // setting intent as the sub class
        Intent intent = new Intent(this, SubActivity.class);

        // intent.putExtra(KEY_MAIN, "msg");
        SimpleData data = new SimpleData("simple");
        intent.putExtra(KEY_MAIN, data);

        // initiate intent (to go to the sub class)
        startActivityForResult(intent, 1004);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // 어느 activity 종료
        if(requestCode == 1004)
        {
            if(requestCode == RESULT_OK)
            {
                String msg = data.getStringExtra(SubActivity.KEY_SUB);
                Log.i("My", "main : " + msg);
            }
        }
    }
}