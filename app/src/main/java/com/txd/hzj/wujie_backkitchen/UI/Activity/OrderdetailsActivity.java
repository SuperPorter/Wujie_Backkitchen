package com.txd.hzj.wujie_backkitchen.UI.Activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.txd.hzj.wujie_backkitchen.R;
import com.txd.hzj.wujie_backkitchen.UI.Adapter.MyViewPagerAdapter;
import com.txd.hzj.wujie_backkitchen.UI.Fragent.ProductionFragment.ProductionItemFragment;
import com.txd.hzj.wujie_backkitchen.UI.base.UIActivity;

import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.ViewPagerHelper;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators.LinePagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.SimplePagerTitleView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 创建者：Sunzeyu
 * <br>创建时间：上午 10:40 2019/4/18 018
 * <br>功能描述：
 */
@SuppressLint("Registered")
public class OrderdetailsActivity extends UIActivity {
    @BindView(R.id.tv_title_toolbar)
    TextView tvTitleToolbar;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.order_details_magic_indicator)
    MagicIndicator orderDetailsMagicIndicator;
    @BindView(R.id.order_details_viewpager)
    ViewPager orderDetailsViewpager;
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
        tvTitleToolbar.setText("外卖订单详情");
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //初始化
        titles = new ArrayList<>();
        fragmentList = new ArrayList<>();
        titles.add("全部");
        titles.add("待备菜");
        titles.add("待制作");
        titles.add("已完成");
        fragmentList.add(new ProductionItemFragment());
        fragmentList.add(new ProductionItemFragment());
        fragmentList.add(new ProductionItemFragment());
        fragmentList.add(new ProductionItemFragment());
        MyViewPagerAdapter myViewPagerAdapter = new MyViewPagerAdapter(getSupportFragmentManager(),fragmentList,titles);
        orderDetailsViewpager.setAdapter(myViewPagerAdapter);
        initMagicIndicator();
    }
    private void initMagicIndicator() {
        orderDetailsMagicIndicator.setBackgroundColor(Color.WHITE);
        CommonNavigator commonNavigator = new CommonNavigator(getContext());
        commonNavigator.setAdjustMode(true);  //ture 即标题平分屏幕宽度的模式
        commonNavigator.setAdapter(new CommonNavigatorAdapter() {
            @Override
            public int getCount() {
                return titles == null ? 0 : titles.size();
            }

            @Override
            public IPagerTitleView getTitleView(Context context, final int index) {
                SimplePagerTitleView simplePagerTitleView = new SimplePagerTitleView(context);
                simplePagerTitleView.setText(titles.get(index));
                simplePagerTitleView.setTextSize(18);
                simplePagerTitleView.setNormalColor(Color.GRAY);
                simplePagerTitleView.setSelectedColor(Color.RED);
                simplePagerTitleView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        orderDetailsViewpager.setCurrentItem(index);
                    }
                });
                return simplePagerTitleView;
            }
            @Override
            public IPagerIndicator getIndicator(Context context) {
                LinePagerIndicator indicator = new LinePagerIndicator(context);
                indicator.setColors(Color.RED, Color.RED, Color.RED ,Color.RED);
                return indicator;
            }
        });
        orderDetailsMagicIndicator.setNavigator(commonNavigator);
        ViewPagerHelper.bind(orderDetailsMagicIndicator, orderDetailsViewpager);
    }

}
