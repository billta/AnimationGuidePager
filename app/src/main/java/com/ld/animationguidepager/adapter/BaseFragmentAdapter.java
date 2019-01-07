package com.ld.animationguidepager.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.ld.animationguidepager.fragment.LauncherBaseFragment;

import java.util.List;

/**
 * Created by Billta on 2018-09-29.
 */

public class BaseFragmentAdapter extends FragmentStatePagerAdapter {
    private List<LauncherBaseFragment> list;
    public BaseFragmentAdapter(FragmentManager fm, List<LauncherBaseFragment> list) {
        super(fm);
        this.list = list;
    }

    public BaseFragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int arg0) {
        return list.get(arg0);
    }

    @Override
    public int getCount() {
        return list.size();
    }
}
