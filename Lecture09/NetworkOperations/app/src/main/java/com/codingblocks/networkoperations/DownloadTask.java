package com.codingblocks.networkoperations;

import android.os.AsyncTask;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by championswimmer on 25/06/17.
 */

public class DownloadTask extends AsyncTask<String, Void, String> {

    private TextView tvToChange = null;

    public DownloadTask(TextView tvToChange) {
        this.tvToChange = tvToChange;
    }

    @Override
    protected String doInBackground(String... strings) {
        URL url = null;
        String result = "";
        try {
            url = new URL(strings[0]);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        HttpURLConnection connection = null;

        try {
            connection = (HttpURLConnection) url.openConnection();
            InputStream netInputStream = connection.getInputStream();

            InputStreamReader isr = new InputStreamReader(netInputStream);

            BufferedReader br = new BufferedReader(isr);

            StringBuilder sb = new StringBuilder();
            String buffer = "";
            do  {
                sb.append(buffer);
                buffer = br.readLine();
            } while (buffer != null);

            result = sb.toString();

        } catch (IOException e) {
            e.printStackTrace();
        }


        return result;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);

        tvToChange.setText(s);
    }
}
