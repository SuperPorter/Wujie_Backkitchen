package com.txd.hzj.wujie_backkitchen.UI.Fragent.HomeFragment;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.txd.hzj.code_library.BaseCode.BaseLazyFragment;
import com.txd.hzj.wujie_backkitchen.R;
import com.txd.hzj.wujie_backkitchen.UI.Adapter.MyViewPagerAdapter;
import com.txd.hzj.wujie_backkitchen.UI.Fragent.EstimateFragment.EstimateItemFragment;
import com.txd.hzj.wujie_backkitchen.UI.Fragent.ProductionFragment.ProductionDetailsFragment;

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
 * <br>创建时间：下午 02:55 2019/4/17 017
 * <br>功能描述：估清界面
 */
public class Estimate_Fragment extends BaseLazyFragment {

    @BindView(R.id.estimate_indicator_bar)
    MagicIndicator estimateIndicatorBar;
    @BindView(R.id.estimate_viewpager)
    ViewPager estimateViewpager;
    private List<Fragment> fragmentList;
    private List<String> titles;
    @Override
    protected int getLayoutId() {
        return R.layout.estimate_layout_fragment;
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
        titles = new ArrayList<>();
        fragmentList = new ArrayList<>();
        titles.add("食材");
        titles.add("辅料");
        titles.add("作料");
        fragmentList.add(new EstimateItemFragment());
        fragmentList.add(new EstimateItemFragment());
        fragmentList.add(new EstimateItemFragment());
        MyViewPagerAdapter myViewPagerAdapter = new MyViewPagerAdapter(getChildFragmentManager(),fragmentList,titles);
        estimateViewpager.setAdapter(myViewPagerAdapter);
        initMagicIndicator();
    }
    private void initMagicIndicator() {
        estimateIndicatorBar.setBackgroundColor(Color.WHITE);
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
                        estimateViewpager.setCurrentItem(index);
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
        estimateIndicatorBar.setNavigator(commonNavigator);
        ViewPagerHelper.bind(estimateIndicatorBar, estimateViewpager);
    }
}
