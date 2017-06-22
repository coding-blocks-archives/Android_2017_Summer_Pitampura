package com.codingblocks.morefragments;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by championswimmer on 22/06/17.
 */

public class MyFragmentPagerAdapter extends FragmentPagerAdapter {
    private int fragCount = 0;
    ArrayList<Fragment> fragmentList;

    public MyFragmentPagerAdapter(FragmentManager fm, int count) {
        super(fm);
        this.fragCount = count;
        this.fragmentList = new ArrayList<>(count);
        Log.d("FRAG", "MyFragmentPagerAdapter: " + fragmentList.size());
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment;
        Log.d("FRAG", "getItem: " + fragmentList.size());
        try {
            fragment = fragmentList.get(position);
        } catch (IndexOutOfBoundsException ioobe) {
            fragment  = BlankFragment.newInstance(
                    "Fragment :" + position,
                    "Yet another fragment"
            );
            fragmentList.add(position, fragment);
        }
        if (fragment == null) {
            fragment = BlankFragment.newInstance(
                    "Fragment :" + position,
                    "Yet another fragment"
            );
            fragmentList.add(position, fragment);
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return fragCount;
    }
}
