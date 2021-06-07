package kr.ai.threadhandler;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;

    // handler 이용해서 thread 통신
    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        Button button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BackgroundThread thread = new BackgroundThread();
                thread.start();
                textView.setText("START THREAD");
            }
        });
    }

    public class BackgroundThread extends Thread
    {
        int value = 0;

        public void run()
        {
            for(int i = 0; i < 100; i++)
            {
                try
                {
                    Thread.sleep(1000);
                }

                catch (Exception e)
                {
                    e.printStackTrace();
                }

                value += 1;
                Log.i("MyThread", "value : " + value);

                // handler를 이용하여 메시지 출력
                handler.post(new Runnable() {
                    @Override
                    public void run()
                    {
                        textView.setText("value: (emulator)" + value);
                    }
                });
            }
        }
    }
}