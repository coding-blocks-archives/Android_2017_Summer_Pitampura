package com.codingblocks.firebaseexample;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

/**
 * Created by championswimmer on 16/07/17.
 */

public class MyInstanceIdService extends FirebaseInstanceIdService {
    @Override
    public void onTokenRefresh() {
        super.onTokenRefresh();

        String token = FirebaseInstanceId.getInstance().getToken();
        Log.d("TOKEN", "onTokenRefresh: " + token);
    }
}
