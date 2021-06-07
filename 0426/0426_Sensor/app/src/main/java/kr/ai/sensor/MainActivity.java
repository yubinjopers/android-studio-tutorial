package kr.ai.sensor;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    final static String TAG = "mySensor";

    // 센서를 사용하기 위한 메니저
    private SensorManager sensorManager;
    // 센서 이벤트 처리할 때 클래스
    private SensorEventListener accListener;
    // 센서 클래스
    private Sensor accSensor;

    // 센서 값 출력
    TextView textViewMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewMessage = findViewById(R.id.textView);

        // 센서 메니저를 가져온다
        sensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
        accSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        // 센서 이벤트를 처리할 리스너
        accListener = new accListener();
    }

    @Override
    // 센서를 등록 사용
    protected void onPause() {
        super.onPause();

        if(sensorManager != null)
        {
            sensorManager.unregisterListener(accListener);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        sensorManager.registerListener(accListener, accSensor, SensorManager.SENSOR_DELAY_GAME);
    }

    private class accListener implements SensorEventListener
    {

        @Override
        public void onSensorChanged(SensorEvent event) {
            if(event.sensor.getType() == Sensor.TYPE_ACCELEROMETER)
            {
                textViewMessage.setText("\n X : " + event.values[SensorManager.DATA_X]);
                textViewMessage.append("\n Y : " + event.values[SensorManager.DATA_Y]);
                textViewMessage.append("\n Z : " + event.values[SensorManager.DATA_Z]);
                Log.i(TAG, "onSensorChanged() " +
                        "X : "+ event.values[SensorManager.DATA_X] + " " +
                        "Y : " + event.values[SensorManager.DATA_Y] + " " +
                        "Z : " + event.values[SensorManager.DATA_Z]);
            }
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {

        }
    }
}