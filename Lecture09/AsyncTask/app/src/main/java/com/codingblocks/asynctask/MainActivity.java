package com.codingblocks.asynctask;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "ASYNC";

    Button button, button2;
    TextView tvResult;
    EditText etWaitTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.button);
        button2 = (Button) findViewById(R.id.button2);
        tvResult = (TextView) findViewById(R.id.tvResult);
        etWaitTime = (EditText) findViewById(R.id.etWaitTime);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // wait 10 sec
                // tvResult.setText("DONE");
                NSecWaitTask myTask = new NSecWaitTask(tvResult);
                myTask.execute(Integer.valueOf(etWaitTime.getText().toString()));

            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvResult.setText("OTHER STUFF");

            }
        });

    }

    class NSecWaitTask extends AsyncTask<Integer, Float, String> {

        private TextView tvToChange;

        public NSecWaitTask(TextView tvToChange) {
            this.tvToChange = tvToChange;
        }

        @Override
        protected void onPreExecute() {
            tvToChange.setText("READY");
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(Integer... params) {

            for (int i = 0; i < (params[0]) * 2; i++) {
                long startTime = System.currentTimeMillis();

                while(System.currentTimeMillis() < startTime + 500);

                publishProgress (((float) i) / 2);
            }


            return "BOOM";
        }

        @Override
        protected void onProgressUpdate(Float... values) {

            tvToChange.setText(String.valueOf(values[0]));

            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(String s) {

            tvToChange.setText(s);
            super.onPostExecute(s);
        }
    }


}
