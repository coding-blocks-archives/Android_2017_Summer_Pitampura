package com.codingblocks.permissions;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "PERM";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PermissionManager.askForPermission(this,
                new String[]{
                        Manifest.permission.READ_EXTERNAL_STORAGE,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE
                }, new PermissionManager.OnPermissionResultListener() {
                    @Override
                    public void onGranted(String permission) {
                        if (permission.equals(Manifest.permission.READ_EXTERNAL_STORAGE)) {

                        }

                        if (permission.equals(Manifest.permission.WRITE_EXTERNAL_STORAGE)) {

                        }
                    }

                    @Override
                    public void onDenied(String permission) {

                    }
                });

    }

    void writeFile () {
        Log.d(TAG, "onCreate: We are writing a file here");

    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {

        PermissionManager.onRequestPermissionsResult(requestCode, permissions, grantResults);


    }
}
