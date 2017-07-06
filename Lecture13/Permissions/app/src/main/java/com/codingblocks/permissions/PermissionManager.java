package com.codingblocks.permissions;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;

import java.util.ArrayList;

import static com.codingblocks.permissions.MainActivity.TAG;

/**
 * Created by championswimmer on 06/07/17.
 */

public class PermissionManager {

    static ArrayList<OnPermissionResultListener> listenerList
            = new ArrayList<>();

    static void askForPermission(Activity act, String[] permissions,
                                 OnPermissionResultListener oprl) {

        int reqCode = listenerList.size();
        listenerList.add(reqCode, oprl);


        ActivityCompat.requestPermissions(act, permissions, reqCode);
    }

    interface OnPermissionResultListener {
        void onGranted (String permission);
        void onDenied(String permission);
    }

    static void onRequestPermissionsResult(int requestCode,
                                           @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {

        try {
            OnPermissionResultListener oprl = listenerList.get(requestCode);

            for (int i = 0; i < permissions.length; i++) {

                if (grantResults[i] == PackageManager.PERMISSION_GRANTED) {
                    oprl.onGranted(permissions[i]);
                }
                else {
                    oprl.onDenied(permissions[i]);
                }
            }

        } catch (IndexOutOfBoundsException ioobe) {
            Log.d(TAG, "onRequestPermissionsResult: No Such listener registered");
        }


    }
}
