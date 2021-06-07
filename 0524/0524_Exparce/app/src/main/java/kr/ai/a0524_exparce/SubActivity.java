package kr.ai.a0524_exparce;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class SubActivity extends AppCompatActivity {

    public static final String KEY_SUB = "SUB";
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        textView = findViewById(R.id.textView2);

        Bundle bundle = getIntent().getExtras();

        SimpleData d = (SimpleData)bundle.getParcelable(MainActivity.KEY_MAIN);

        textView.append("\n" + d.getMessage());

        /*
         *Intent intent = getIntent();
        *
        *
        * String data = intent.getStringExtra(MainActivity.KEY_MAIN);

        textView.append("\n" + data);

        Log.i("My", data);
        * */
    }

    public void onButtonClicked(View view)
    {
        Intent intent = new Intent();
        intent.putExtra(KEY_SUB, "sub");

        setResult(RESULT_OK, intent);

        // finish (?)
        finish();
    }
}