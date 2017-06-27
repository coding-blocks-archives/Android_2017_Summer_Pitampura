package com.codingblocks.restapi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "REST";

    Button btnDownload;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDownload = (Button) findViewById(R.id.btnDownload);

        btnDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DownloadTask dTask = new DownloadTask(new DownloadTask.OnDownloadListener() {
                    @Override
                    public void onDownloaded(ArrayList<Post> posts) {
                        Toast.makeText(MainActivity.this,
                                "posts downloaded = " + posts.size(),
                                Toast.LENGTH_SHORT).show();
                    }
                });

                dTask.execute("http://jsonplaceholder.typicode.com/posts");
            }
        });


    }


}
