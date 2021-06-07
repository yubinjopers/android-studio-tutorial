package kr.ai.challengeimageview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView cockatoo = (ImageView)findViewById(R.id.cockatoo);
        ImageView grandpadog = (ImageView)findViewById(R.id.grandpadog);
        Button upBtn = (Button)findViewById(R.id.upBtn);
        Button dnBtn = (Button)findViewById(R.id.dnBtn);

        upBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cockatoo.setImageResource(R.drawable.grandpadog);
                grandpadog.setImageResource(R.drawable.cockatoo);
            }
        });

        dnBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cockatoo.setImageResource(R.drawable.cockatoo);
                grandpadog.setImageResource(R.drawable.grandpadog);
            }
        });
    }
}