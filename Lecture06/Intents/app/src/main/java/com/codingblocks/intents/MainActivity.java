package com.codingblocks.intents;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    
    public static final String TAG = "MyApp";
    EditText etMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate: ============");
        setContentView(R.layout.activity_main);
        etMain = (EditText) findViewById(R.id.et_main);

        ((Button) findViewById(R.id.button)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String dataToSend = etMain.getText().toString();

//                Intent i = new Intent(MainActivity.this, OtherActivity.class);
//                i.putExtra("data", dataToSend);
//                i.putExtra("result", 10);
//                startActivity(i);
//                finish();

                Intent i = new Intent(MainActivity.this, NewIntentExampleActivity.class);
                startActivity(i);

            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.d(TAG, "onStart: =======");
    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.d(TAG, "onResume: ==========");
    }

    @Override
    protected void onPause() {

        Log.d(TAG, "onPause: ========");

        super.onPause();

    }

    @Override
    protected void onStop() {
        Log.d(TAG, "onStop: ========");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.d(TAG, "onDestroy: ==========");
        super.onDestroy();
    }
}
