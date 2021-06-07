package com.ai.sensorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    final static String TAG = "MY";

    myView myView;
    private SensorManager sensorManager;
    private SensorEventListener accListener; //event
    private Sensor accSensor; //sensor


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        myView = new myView(this);
        setContentView(myView);

        sensorManager = (SensorManager) getSystemService((SENSOR_SERVICE));
        //sensormanager 통하여 사용할 센서 가져오기
        accSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        accListener = new AccListener();
    }

    // USER와 이벤트 대기
    @Override
    protected void onResume() {
        super.onResume();
        sensorManager.registerListener(accListener, accSensor, SensorManager.SENSOR_DELAY_GAME);
    }

    @Override
    protected void onPause() {
        super.onPause();
        if(sensorManager != null)
        {
            sensorManager.unregisterListener(accListener);
        }
    }

    class AccListener implements SensorEventListener{

            @Override
            public void onSensorChanged(SensorEvent event) {
                //if(event.getType() == SensorEvent.TYPE_ACCELOMETER)
                    Log.i(TAG,
                            "X: " + event.values[SensorManager.DATA_X] +
                                    " " +
                                    "Y : " +  event.values[SensorManager.DATA_Y]);

                    myView.move(SensorManager.DATA_X, SensorManager.DATA_Y);
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {

            }
        }
    }
