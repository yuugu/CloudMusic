package com.yuugu.cloud.music.ui.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.yuugu.cloud.scaffold.page.BaseFragment;

import java.util.List;

/**
 * @author: yuugu
 * @date: 2020/7/18
 */
public class ViewPagerAdapter extends FragmentPagerAdapter {

    private List<BaseFragment> list;

    public ViewPagerAdapter(FragmentManager fm, List<BaseFragment> list) {
        super(fm);
        this.list = list;
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }
}