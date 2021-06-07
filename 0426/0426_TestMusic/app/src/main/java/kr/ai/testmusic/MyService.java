package kr.ai.testmusic;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {

    final String TAG = "MyService";
    private MediaPlayer mediaPlayer;


    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId)
    {
        Log.i(TAG,"onStartCommand()");
        mediaPlayer = MediaPlayer.create(this, R.raw.freemusic);

        // 음악 재생
        mediaPlayer.start();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy()
    {
        Log.i(TAG,"onDestroy()");
        mediaPlayer.stop();
        super.onDestroy();
    }
}