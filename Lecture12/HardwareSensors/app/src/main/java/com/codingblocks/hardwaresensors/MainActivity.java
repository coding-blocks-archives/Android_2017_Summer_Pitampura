package com.codingblocks.hardwaresensors;

import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "SENS";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView tvAx = (TextView) findViewById(R.id.tvAx);
        final TextView tvAy = (TextView) findViewById(R.id.tvAy);
        final TextView tvAz = (TextView) findViewById(R.id.tvAz);
        final LinearLayout llActivityMain = (LinearLayout) findViewById(R.id.llActivityMain);

        tvAx.setBackgroundColor(Color.rgb(0,0,255));

        SensorManager sm = (SensorManager) getSystemService(SENSOR_SERVICE);
        SensorEventListener sel = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent sensorEvent) {
                tvAx.setText(String.valueOf(Math.ceil(sensorEvent.values[0])));
                tvAy.setText(String.valueOf(Math.ceil(sensorEvent.values[1])));
                tvAz.setText(String.valueOf(Math.ceil(sensorEvent.values[2])));

                llActivityMain.setBackgroundColor(0/* take values from ax, ay, az*/);
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int i) {

            }
        };
        for (Sensor sensor : sm.getSensorList(Sensor.TYPE_ALL)) {
            Log.d(TAG, "name: " + sensor.getName());
            Log.d(TAG, "vendor: " + sensor.getVendor());
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT_WATCH) {
                Log.d(TAG, "name: " + sensor.getStringType());
            }
            Log.d(TAG, " = = = = = = = = = = = = = = = ");
        }
        Sensor accelSensor = sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sm.registerListener(sel, accelSensor, SensorManager.SENSOR_DELAY_NORMAL);

    }
}
