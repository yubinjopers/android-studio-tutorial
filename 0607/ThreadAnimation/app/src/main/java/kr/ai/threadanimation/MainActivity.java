package kr.ai.threadanimation;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;

    ArrayList<Drawable> drawableList = new ArrayList<Drawable>();

    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawableList.add(getResources().getDrawable(R.drawable.cockatoo));
        drawableList.add(getResources().getDrawable(R.drawable.grandpadog));
        drawableList.add(getResources().getDrawable(R.drawable.image));
        drawableList.add(getResources().getDrawable(R.drawable.kitten));

        // 연결
        imageView = findViewById(R.id.imageView);

        Button btnStart = findViewById(R.id.btnStart);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AniThread thread = new AniThread();
                thread.start();
            }
        });
    }

    class AniThread extends Thread{
        public void run()
        {
            int index = 0;

            for(int i = 0; i < 100; i++)
            {
                final Drawable drawable = drawableList.get(index);

                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        imageView.setImageDrawable(drawable);
                    }
                });

                // 이미지 변경을 위한 인덱스 증가
                index += 1;
                if(index > 3)
                {
                    index = 0;
                }

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}