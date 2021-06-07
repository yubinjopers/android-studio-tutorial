package kr.ai.thread;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int value = 0;
    public static final String Tag = "MyThread";
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        Button btnStart = findViewById(R.id.threadStart);
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(Tag, "btn Clicked\n");
                BackgroundThread thread = new BackgroundThread();
                thread.start();
            }
        });
    }

    class BackgroundThread extends Thread
    {
        public void run()
        {
            for(int i = 0; i < 100; i++)
            {
                try
                {
                    Thread.sleep(1000);

                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }

                value += 1;
                Log.i(Tag, "value : " + value);
                textView.append("\n value : " + value);
            }
        }
    }
}