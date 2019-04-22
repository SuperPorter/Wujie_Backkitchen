package com.txd.hzj.wujie_backkitchen.UI.Activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import com.flyco.tablayout.SlidingTabLayout;
import com.txd.hzj.wujie_backkitchen.R;
import com.txd.hzj.wujie_backkitchen.UI.Adapter.MyViewPagerAdapter;
import com.txd.hzj.wujie_backkitchen.UI.Fragent.ProductionFragment.ProductionItemFragment;
import com.txd.hzj.wujie_backkitchen.UI.base.UIActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 创建者：Sunzeyu
 * <br>创建时间：上午 10:40 2019/4/18 018
 * <br>功能描述：订单详情
 */
@SuppressLint("Registered")
public class OrderdetailsActivity extends UIActivity {
    @BindView(R.id.order_details_magic_indicator)
    SlidingTabLayout orderDetailsMagicIndicator;
    @BindView(R.id.order_details_viewpager)
    ViewPager orderDetailsViewpager;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    private List<Fragment> fragmentList;
    private List<String> titles;

    @Override
    protected int getLayoutId() {
        return R.layout.order_details_layout;
    }

    @Override
    protected int getTitleBarId() {
        return R.id.toolbar;
    }

    @Override
    protected void initView() {
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void initData() {
        //初始化头布局
        tvTitle.setText("订单详情");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //初始化
        titles = new ArrayList<>();
        fragmentList = new ArrayList<>();
        titles.add("全部");
        titles.add("待备菜");
        titles.add("待制作");
        titles.add("待打荷");
        titles.add("待配送");
        titles.add("已完成");
        //初始化四个子布局
        fragmentList.add(new ProductionItemFragment());
        fragmentList.add(new ProductionItemFragment());
        fragmentList.add(new ProductionItemFragment());
        fragmentList.add(new ProductionItemFragment());
        fragmentList.add(new ProductionItemFragment());
        fragmentList.add(new ProductionItemFragment());
        MyViewPagerAdapter myViewPagerAdapter = new MyViewPagerAdapter(getSupportFragmentManager(), fragmentList, titles);
        orderDetailsViewpager.setAdapter(myViewPagerAdapter);
        orderDetailsMagicIndicator.setViewPager(orderDetailsViewpager);
        orderDetailsMagicIndicator.setMsgMargin(0,90,80);
        orderDetailsMagicIndicator.showMsg(0, 100);
        orderDetailsMagicIndicator.showMsg(1, 100);
        orderDetailsMagicIndicator.showMsg(2, 100);
        orderDetailsMagicIndicator.showMsg(3, 100);
        orderDetailsMagicIndicator.showMsg(4, 100);
        orderDetailsMagicIndicator.showMsg(5, 100);
    }

}
