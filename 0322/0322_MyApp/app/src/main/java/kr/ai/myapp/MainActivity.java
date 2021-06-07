package kr.ai.myapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    final String TAG = "LifeCycle";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(TAG, "OnCreate()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume()");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStop()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "onRestart()");
    }

    // BUTTON
    public void onButtonClicked(View view)
    {

        switch(view.getId())
        {
            // NAVER
            case R.id.btNaver:
            {
                // intent를 이용하여 브라우저를 실행 요청함.
                Intent naverIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://m.naver.com"));
                startActivity(naverIntent);
                break;
            }
                // CALL
            case R.id.btCall:
            {
                // intent를 이용하여 시스템에 call 요청함.
                Intent callIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:010-6472-2348"));
                startActivity(callIntent);
                break;
            }

        }

    }
}