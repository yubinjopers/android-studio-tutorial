package kr.ai.network;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class MainActivity extends AppCompatActivity  implements Runnable{

    public static final String Tag = "Network";

    private static boolean wifiConnected = false;
    private static boolean mobileConnected = false;

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        Button btnServer = findViewById(R.id.btnServer);

        btnServer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        startServer();
                    }
                }).start();
            }
        });
    }

    public void onButtonClicked(View view)
    {
        checkNetworkConnection();

        if(wifiConnected)
        {
            textView.append("starting up . . . \n");
            Thread thread = new Thread(this);
            thread.start();
        }
    }

    private void checkNetworkConnection()
    {
        // 네트워크 연결 확인 하기 위해 manager 가져오기
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        // network 연결 확인하기
        // 네트워크 활성화 . . .(enable) 확인
        NetworkInfo activeInfo = connectivityManager.getActiveNetworkInfo();

        // 활성화 * 연결
        if(activeInfo != null && activeInfo.isConnected())
        {
            wifiConnected = activeInfo.getType() == ConnectivityManager.TYPE_WIFI;
            mobileConnected = activeInfo.getType() == ConnectivityManager.TYPE_MOBILE;

            if(wifiConnected)
            {
                textView.append("WIFI CONNECTION \n");
            }

            else
            {
                textView.append("MOBILE CONNECTION \n");
            }
        }

        else
        {
            textView.append("NO WIFI NOR MOBILE CONNECTION. \n");
        }
    }

    @Override
    public void run()
    {
        try
        {
            Socket socket = new Socket("192.168.0.32".trim(), 5000);

            // 출력 String
            ObjectOutput output = new ObjectOutputStream(socket.getOutputStream());
            // 데이터 보내기
            output.writeObject("msg");;
            // 버퍼 비우기
            output.flush();

            // 입력 String
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
            // 데이터 받기
            Object obj = in.readObject();
            // 디버그 메시지
            Log.i(Tag, "input msg : " + obj);

            // 소켓 닫기
            socket.close();
        }

        catch(Exception e)
        {
            e.printStackTrace();

            Log.e(Tag, e.getMessage());
            Log.i(Tag, "Exception : ", e);
        }
    }

    public void startServer()
    {
        int port = 5000;

        try
        {
            // server 소켓을 만든다
            ServerSocket serverSocket = new ServerSocket(port);

            while(true)
            {
                // client 접속
                Socket socket = serverSocket.accept();

                // client, server 통신
                // client -> server
                ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
                Object object = inputStream.readObject();
                Log.i(Tag, "server in : " + object);

                // client <- server
                ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
                outputStream.writeObject(object + " <server>");
                outputStream.flush();
                Log.i(Tag, "server send OK");
                socket.close();
            }
        }

        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}