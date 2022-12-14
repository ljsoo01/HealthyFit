package com.example.healthyfit;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class Adapta extends FragmentPagerAdapter {
    Fragment[] fragments=new Fragment[1];
    public Adapta(@NonNull FragmentManager fm){
        super(fm);

        fragments[0]=new frag();
    }
    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragments[position];
    }

    @Override
    public int getCount() {
        return fragments.length;
    }
}
