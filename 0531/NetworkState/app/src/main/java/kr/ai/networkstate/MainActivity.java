package kr.ai.networkstate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
    }

    public void onButtonClicked(View view)
    {
        // network 상태 값을 알기 위해 connectivityManager 가져온다
        ConnectivityManager connectivityManager
                = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);

        // 네트워크 활성화 확인하기
        NetworkInfo networkInfo = connectivityManager.getNetworkInfo(connectivityManager.TYPE_MOBILE);

        if(networkInfo == null)
        {
            textView.append("\n NetworkInfo == null");
            textView.append("\n WIFI, LTE 연결되지 않음");
        }
        else
        {
            boolean isConnected = networkInfo.isConnectedOrConnecting();
            boolean wifi = (networkInfo.getType() == connectivityManager.TYPE_WIFI);
            boolean mobile = (networkInfo.getType() == connectivityManager.TYPE_MOBILE);

            textView.append("\n available : " + isConnected);
            textView.append("\n WIFI available : " + wifi);
            textView.append("\n mobile available : " + mobile);
        }
    }
}