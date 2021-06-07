package kr.ai.greeting;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    public void onButtonClicked(View v) // ALT + ENTER to import library.
    {
        Toast.makeText(this, "확인 1 버튼을 눌렀어요", Toast.LENGTH_LONG).show();
    }
}