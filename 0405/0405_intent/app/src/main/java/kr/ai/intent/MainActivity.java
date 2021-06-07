package kr.ai.intent;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView txtMsg;
    final int REQUEST_CODE_SUB = 1004;
    static final String KEY_NAME = "KEY";
    static final String KEY_AGE = "AGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtMsg = findViewById(R.id.textView2);
    }

    public void onButtonClicked(View view)
    {
        Intent intent = new Intent(this, SubActivity.class);
        // intent에 데이터를 넣은다
        intent.putExtra(KEY_NAME, "data");
        intent.putExtra(KEY_AGE, 20);
        //startActivity(intent);

        // subActivity 실행후 결과값을 받기 위해
        startActivityForResult(intent,REQUEST_CODE_SUB);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        txtMsg.append("requestCode : " + requestCode);
        txtMsg.append("\nresultCode : " + requestCode);

        // subActivity에서 온 결과 확인
        if(requestCode == REQUEST_CODE_SUB)
        {
            if(RESULT_OK == resultCode)
            {
                String str = data.getStringExtra("SUB");
                txtMsg.append("\n msg : " + str);
            }
        }
        else
        {
            Toast.makeText(getBaseContext(), "requestCode " + requestCode, Toast.LENGTH_SHORT).show();
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}