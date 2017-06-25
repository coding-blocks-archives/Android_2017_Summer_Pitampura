package com.codingblocks.asynctask;

import android.os.AsyncTask;
import android.widget.TextView;

/**
 * Created by championswimmer on 25/06/17.
 */
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

            while (System.currentTimeMillis() < startTime + 500) ;

            publishProgress(((float) i) / 2);
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
