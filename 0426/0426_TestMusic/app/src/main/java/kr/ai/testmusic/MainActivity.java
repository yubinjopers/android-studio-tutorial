package kr.ai.testmusic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import kr.ai.testmusic.R;

public class MainActivity extends AppCompatActivity {

    TextView textViewMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewMessage = findViewById(R.id.textView);
        textViewMessage.setText("onCreate()");
    }

    public void onButtonClicked(View v)
    {
        Intent intent = new Intent(this, MyService.class);
        switch(v.getId())
        {
            case R.id.startButton:
                textViewMessage.append("\nstartService");
                startService(intent);
                break;
            case R.id.stopButton:
                textViewMessage.append("\nstopService");
                stopService(intent);
                break;
        }
    }

}