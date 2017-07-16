package com.codingblocks.firebaseexample;

import android.app.NotificationManager;
import android.os.Build;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.iid.FirebaseInstanceId;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (getIntent().getBooleanExtra("FROM_NOTIFICATION", false)) {
            ((NotificationManager) getSystemService(NOTIFICATION_SERVICE))
                    .cancel(321);
        }
        String token = FirebaseInstanceId.getInstance().getToken();
        Log.d("TOKEN", "onTokenRefresh: " + token);


        FirebaseDatabase db = FirebaseDatabase.getInstance();
        DatabaseReference users = db.getReference("users");
        users.child("3").setValue("hello");
        users.push().child("name").setValue("Sumeet");
        DatabaseReference sumeet = users.child("4").child("name");

        //somewhere where I don't know which ref sumeet is in
        sumeet.getParent().child("5").child("name").setValue("");

        users.push();

        users.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }


}
