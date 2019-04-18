package com.txd.hzj.wujie_backkitchen.UI.Activity;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.txd.hzj.wujie_backkitchen.R;
import com.txd.hzj.wujie_backkitchen.UI.base.UIActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 创建者：Sunzeyu
 * <br>创建时间：下午 05:12 2019/4/18 018
 * <br>功能描述：
 */
public class IngredientsreplacementActivtiy extends UIActivity {

    @BindView(R.id.tv_title_toolbar)
    TextView tvTitleToolbar;
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected int getLayoutId() {
        return R.layout.ingredient_layout_activity;
    }

    @Override
    protected int getTitleBarId() {
        return R.id.toolbar;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        //初始化头布局
        tvTitleToolbar.setText("食材替换");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
}
