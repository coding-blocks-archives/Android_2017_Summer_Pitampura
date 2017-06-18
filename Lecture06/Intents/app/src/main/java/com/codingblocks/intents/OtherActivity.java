package com.codingblocks.intents;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class OtherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);

        String dataReceived = getIntent().getStringExtra("data");
        ((TextView) findViewById(R.id.tv_other)).setText(dataReceived);


    }
}
