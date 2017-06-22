package com.codingblocks.morefragments;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = (ViewPager) findViewById(R.id.viewPager);


        ((Button) findViewById(R.id.btnTabAct))
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(
                                new Intent(MainActivity.this, TabbedActivity.class)
                        );
                    }
                });

        viewPager.setAdapter(new MyFragmentPagerAdapter(
                getSupportFragmentManager(),
                10
        ));
        viewPager.setOffscreenPageLimit(3);
    }
}
