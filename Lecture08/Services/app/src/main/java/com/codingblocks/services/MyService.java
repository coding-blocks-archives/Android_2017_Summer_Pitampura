package com.codingblocks.services;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.provider.Settings;
import android.support.annotation.IntDef;
import android.util.Log;
import android.widget.Toast;

public class MyService extends Service {
    public static final String TAG = "SRV";

    public MyService() {
        Log.d(TAG, "MyService: ");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "onStartCommand: ");
        String message = "nothing";
        if (intent != null) {
            message = intent.getStringExtra("hello");
        }
        Toast.makeText(this, "onStartCommand" + message, Toast.LENGTH_SHORT).show();
//
//        (new Handler()).postDelayed(new Runnable() {
//            @Override
//            public void run() {
//
//            }
//        }, 8000);
        //stopSelf();

        return START_REDELIVER_INTENT;
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
