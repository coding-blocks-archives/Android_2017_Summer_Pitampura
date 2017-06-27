package com.codingblocks.restapi;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by championswimmer on 27/06/17.
 */
class DownloadTask extends AsyncTask<String, Void, ArrayList<Post>> {
    public static final String TAG = "REST";

    interface OnDownloadListener {
        void onDownloaded(ArrayList<Post> posts);
    }

    private OnDownloadListener odl;

    public DownloadTask(OnDownloadListener odl) {
        this.odl = odl;
    }

    @Override
    protected ArrayList<Post> doInBackground(String... params) {
        ArrayList<Post> postList = null;

        try {
            URL url = new URL(params[0]);
            HttpURLConnection connection =
                    (HttpURLConnection) url.openConnection();
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(connection.getInputStream())
            );

            StringBuilder sb = new StringBuilder();
            String buffer = "";
            while (buffer != null) {
                sb.append(buffer);
                buffer = br.readLine();
            }
//            Log.d(MainActivity.TAG, "doInBackground: " + sb.toString());
            JSONArray postJsonArr = new JSONArray(sb.toString());

            postList = new ArrayList<>(postJsonArr.length());

            for (int i = 0; i < postJsonArr.length(); i++) {
                JSONObject postJsonObj = postJsonArr.getJSONObject(i);
                Post post = new Post(
                        postJsonObj.getInt("userId"),
                        postJsonObj.getInt("id"),
                        postJsonObj.getString("title"),
                        postJsonObj.getString("body")
                );
                Log.d(TAG, "doInBackground: " + post.getId());
                postList.add(post);
            }

        } catch (IOException | JSONException e) {
            // Do nothing
        }

        return postList;
    }

    @Override
    protected void onPostExecute(ArrayList<Post> posts) {
        super.onPostExecute(posts);
        odl.onDownloaded(posts);
    }
}
