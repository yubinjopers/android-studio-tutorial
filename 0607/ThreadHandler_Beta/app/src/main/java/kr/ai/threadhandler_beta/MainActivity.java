package kr.ai.threadhandler_beta;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    MainHandler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);

        Button btn = findViewById(R.id.button);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BackgroundThread thread = new BackgroundThread();
                thread.start();
            }
        });

        handler = new MainHandler();
    }

    class BackgroundThread extends Thread
    {
        int value;

        public void run()
        {
            for(int i = 0; i != 100; ++i)
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
                Log.i("MyTag", "value : " + value);

                // 핸들러를 통해 메시지 받기
                Message message = handler.obtainMessage();

                // 데이터 담기
                Bundle bundle = new Bundle();
                bundle.putInt("key", value);
                message.setData(bundle);

                // 메시지(데이터 담긴) 보네기
                handler.sendMessage(message);
            }
        }
    }

    class MainHandler extends Handler
    {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);

            Bundle bundle = msg.getData();
            int value = bundle.getInt("key");
            textView.setText("value : " + value);
        }
    }

}