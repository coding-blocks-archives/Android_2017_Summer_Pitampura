package com.codingblocks.firebaseexample;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

/**
 * Created by championswimmer on 16/07/17.
 */

public class MyMessagingService extends FirebaseMessagingService {
    public static final String TAG = "FCM";

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);

        Log.d(TAG, "onMessageReceived: " + remoteMessage.getMessageId());
        Log.d(TAG, "onMessageReceived: " + remoteMessage.getMessageType());
        Log.d(TAG, "onMessageReceived: " + remoteMessage.getData());
        Log.d(TAG, "onMessageReceived: " + remoteMessage.getNotification().getTitle());
        Log.d(TAG, "onMessageReceived: " + remoteMessage.getNotification().getBody());

        NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        Intent actInt = new Intent(this, MainActivity.class);
        actInt.putExtra("FROM_NOTIFICATION", true);
        PendingIntent pi = PendingIntent.getActivity(this, 111, actInt, PendingIntent.FLAG_ONE_SHOT);

        Notification.Action openActivityAction =
                new Notification.Action(
                        R.mipmap.ic_launcher,
                        "Open",
                        pi
                );

        Notification.Builder notificationBuilder = new Notification.Builder(this)
                .setContentTitle(remoteMessage.getNotification().getTitle())
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentText(remoteMessage.getNotification().getBody());

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT_WATCH) {
            notificationBuilder.addAction(openActivityAction);
        }


        Notification myNotificaiton = notificationBuilder.build();

        nm.notify(321, myNotificaiton);

    }
}
