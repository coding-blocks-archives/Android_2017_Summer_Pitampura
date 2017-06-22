package com.codingblocks.services;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btn, btn2;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = (Button) findViewById(R.id.button);
        btn2 = (Button) findViewById(R.id.button2);
        tv = (TextView) findViewById(R.id.textView2);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Handler h = new Handler();
                Runnable r = new Runnable() {
                    @Override
                    public void run() {
                        tv.setText("WORLD");

                    }
                };

                h.postDelayed(r, 5000);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //tv.setText("WOW");

                Intent i = new Intent(MainActivity.this, MyService.class);
                i.putExtra("hello", "startedFromActivity");
                startService(i);
            }
        });

    }
}
