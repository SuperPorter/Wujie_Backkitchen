package com.txd.hzj.wujie_backkitchen.UI.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * 创建者：Sunzeyu
 * <br>创建时间：下午 04:17 2019/4/17 017
 * <br>功能描述：
 */
public class MyViewPagerAdapter extends FragmentPagerAdapter{
    private List<Fragment> fragmentList;
    private List<String> titles;
    public MyViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    public MyViewPagerAdapter(FragmentManager fm, List<Fragment> fragmentList, List<String> titles) {
        super(fm);
        this.fragmentList = fragmentList;
        this.titles = titles;
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return titles.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles.get(position);
    }
}
