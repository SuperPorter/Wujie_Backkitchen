package com.txd.hzj.wujie_backkitchen.UI.Fragent.HomeFragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.flyco.tablayout.SlidingTabLayout;
import com.txd.hzj.code_library.BaseCode.BaseLazyFragment;
import com.txd.hzj.code_library.BaseUtils.android.LogUtils;
import com.txd.hzj.wujie_backkitchen.R;
import com.txd.hzj.wujie_backkitchen.UI.Adapter.MyViewPagerAdapter;
import com.txd.hzj.wujie_backkitchen.UI.Fragent.DestineFragment.DestineItemFragment;
import com.txd.hzj.wujie_backkitchen.UI.Fragent.ProductionFragment.ProductionItemFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 创建者：Sunzeyu
 * <br>创建时间：下午 02:32 2019/4/17 017
 * <br>功能描述：制作页面
 */
public class Destine_Fragment extends BaseLazyFragment {
    private List<Fragment> fragmentList;
    private List<String> titles;
    @BindView(R.id.order_details_magic_indicator)
    SlidingTabLayout orderDetailsMagicIndicator;
    @BindView(R.id.order_details_viewpager)
    ViewPager orderDetailsViewpager;

    @Override
    protected int getLayoutId() {
        return R.layout.destine_layout_fragment;
    }

    @Override
    protected int getTitleBarId() {
        return 0;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        //初始化
        titles = new ArrayList<>();
        fragmentList = new ArrayList<>();
        titles.add("全部");
        titles.add("未开始");
        titles.add("待领取");
        titles.add("已完成");
        //初始化四个子布局
        fragmentList.add(new DestineItemFragment());
        fragmentList.add(new DestineItemFragment());
        fragmentList.add(new DestineItemFragment());
        fragmentList.add(new DestineItemFragment());
        MyViewPagerAdapter myViewPagerAdapter = new MyViewPagerAdapter(getChildFragmentManager(), fragmentList, titles);
        orderDetailsViewpager.setAdapter(myViewPagerAdapter);
        orderDetailsMagicIndicator.setViewPager(orderDetailsViewpager);
        orderDetailsMagicIndicator.showMsg(0, 100);
        orderDetailsMagicIndicator.showMsg(1, 100);
        orderDetailsMagicIndicator.showMsg(2, 100);
        orderDetailsMagicIndicator.showMsg(3, 100);
        // TODO: 2019/4/23 023 适配问题未解决，测量不返回相应的值，重写或者是重新测量
        orderDetailsMagicIndicator.setMsgMargin(0,160,10);
        orderDetailsMagicIndicator.setMsgMargin(1,160,10);
        orderDetailsMagicIndicator.setMsgMargin(2,160,10);
        orderDetailsMagicIndicator.setMsgMargin(3,160,10);
    }

}
