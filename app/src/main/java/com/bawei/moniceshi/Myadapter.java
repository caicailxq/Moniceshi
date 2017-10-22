package com.bawei.moniceshi;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/10/22.
 */

public class Myadapter extends FragmentStatePagerAdapter{
    private String[] titles = {"热门", "关注"};
    private List<Fragment> mFragments = new ArrayList<>();
    private FragmentManager mFragmentManager;
    public Myadapter(FragmentManager fm) {
        super(fm);
        mFragmentManager=fm;
    }

    public Myadapter(FragmentManager fm, List<Fragment> temp) {
        super(fm);
        mFragmentManager=fm;
        mFragments=temp;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                ReFragment reFragment=new ReFragment();
                return reFragment;
            case 1:
                GuanFragment guanFragment = new GuanFragment();
                return guanFragment;
        }
        return null;

    }

    @Override
    public int getCount() {
        return titles.length;
    }
    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}
