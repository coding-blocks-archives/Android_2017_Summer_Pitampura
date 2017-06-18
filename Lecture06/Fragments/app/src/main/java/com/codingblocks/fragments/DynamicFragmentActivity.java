package com.codingblocks.fragments;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DynamicFragmentActivity extends AppCompatActivity {

    Button btnRed, btnBlue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic_fragment);

        btnBlue = (Button) findViewById(R.id.btnBlue);
        btnRed = (Button) findViewById(R.id.btnRed);

        final FragmentManager fragMan = getSupportFragmentManager();


        btnRed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragTxn = fragMan.beginTransaction();
                fragTxn.replace(R.id.flFragmentContainer, new RedFragment(), "red");
                fragTxn.commit();


            }
        });
        btnBlue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragTxn = fragMan.beginTransaction();
                fragTxn.replace(R.id.flFragmentContainer, new BlueFragment(), "blue");
                fragTxn.commit();
            }
        });


    }
}
