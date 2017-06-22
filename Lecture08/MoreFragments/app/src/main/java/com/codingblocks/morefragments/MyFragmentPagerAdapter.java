package com.codingblocks.morefragments;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.View;

/**
 * Created by championswimmer on 22/06/17.
 */

public class MyFragmentPagerAdapter extends FragmentPagerAdapter {
    private int fragCount = 0;

    public MyFragmentPagerAdapter(FragmentManager fm, int count) {
        super(fm);
        this.fragCount = count;
    }

    @Override
    public Fragment getItem(int position) {
        return BlankFragment.newInstance(
                "Fragment :" + position,
                "Yet another fragment"
        );
    }

    @Override
    public int getCount() {
        return fragCount;
    }
}
