package com.codingblocks.permissions;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "PERM";

    EditText etData;
    Button btnWriteData, btnReadData;
    TextView tvFileData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etData = (EditText) findViewById(R.id.etData);
        btnWriteData = (Button) findViewById(R.id.btnWriteFile);
        btnReadData = (Button) findViewById(R.id.btnReadFile);
        tvFileData = (TextView) findViewById(R.id.tvFileData);


        Log.d(TAG, "getFilesDir: " + getFilesDir().getAbsolutePath());

        Log.d(TAG, "getExternalFilesDir: " + getExternalFilesDir(null));
        Log.d(TAG, "getExternalFilesDir(DIRECTORY_MUSIC): " + getExternalFilesDir(Environment.DIRECTORY_MUSIC));

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            File[] files = getExternalFilesDirs(null);
            for (File file: files) {
                Log.d(TAG, "getExternalFilesDirs: " + getExternalFilesDir(null));
            }
        }


        Log.d(TAG, "Environment.getExternalStorageDirectory: " + Environment.getExternalStorageDirectory());
        File pubMusicDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC);
        Log.d(TAG, "onCreate: " + pubMusicDir);


        final File sdcard = Environment.getExternalStorageDirectory();

        btnWriteData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    writeDataToFile(new File(sdcard, "myfile.txt"), etData.getText().toString());
            }
        });

        btnReadData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                readDataFromFile(new File(sdcard, "myfile.txt"));
            }
        });

    }

    String read (File file) throws IOException {

        Log.d(TAG, "read: " + file.getAbsolutePath());
        File fileToRead = file;
        FileInputStream fileInputStream = new FileInputStream(fileToRead);
        BufferedReader br = new BufferedReader(new InputStreamReader(fileInputStream));
        StringBuilder sb = new StringBuilder();
        String buf = br.readLine();
        while (buf != null) {
            sb.append(buf);
            buf = br.readLine();
        }
        Log.d(TAG, "read: " + sb.toString());
        return sb.toString();

    }

    void write (File file, String data) throws IOException {
        Log.d(TAG, "write: " + file.getAbsolutePath());
        File fileToWrite = file;
        FileOutputStream fileOutputStream = new FileOutputStream(fileToWrite);
        fileOutputStream.write(data.getBytes());
    }

    String readDataFromFile (final File file) {
        final String[] result = {""};
        PermissionManager.askForPermission(this,
                new String[]{
                        Manifest.permission.READ_EXTERNAL_STORAGE,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE
                }, new PermissionManager.OnPermissionResultListener() {
                    @Override
                    public void onGranted(String permission) {
                        if (permission.equals(Manifest.permission.READ_EXTERNAL_STORAGE)) {
                            try {
                                 String data = read(file);
                                tvFileData.setText(data);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                    @Override
                    public void onDenied(String permission) {
                        Toast.makeText(MainActivity.this,
                                "We can't do this without your permission",
                                Toast.LENGTH_SHORT).show();
                    }
                });

        return result[0];
    }

    void writeDataToFile (final File file, final String data) {
        PermissionManager.askForPermission(this,
                new String[]{
                        Manifest.permission.READ_EXTERNAL_STORAGE,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE
                }, new PermissionManager.OnPermissionResultListener() {
                    @Override
                    public void onGranted(String permission) {
                        if (permission.equals(Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                            try {
                                write(file, data);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                    @Override
                    public void onDenied(String permission) {
                        Toast.makeText(MainActivity.this,
                                "We can't do this without your permission",
                                Toast.LENGTH_SHORT).show();
                    }
                });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {

        PermissionManager.onRequestPermissionsResult(requestCode, permissions, grantResults);


    }
}
