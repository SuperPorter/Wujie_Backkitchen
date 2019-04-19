package com.txd.hzj.wujie_backkitchen.UI.Activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.txd.hzj.wujie_backkitchen.Bean.TimeLineDate;
import com.txd.hzj.wujie_backkitchen.R;
import com.txd.hzj.wujie_backkitchen.UI.Adapter.ProductionAdapter.TimeAdapter;
import com.txd.hzj.wujie_backkitchen.UI.base.UIActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 创建者：Sunzeyu
 * <br>创建时间：下午 05:12 2019/4/18 018
 * <br>功能描述：菜品详情
 */
public class FoodDetailsActivity extends UIActivity {
    @BindView(R.id.timeline_rv)
    RecyclerView timelineRv;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected int getLayoutId() {
        return R.layout.fooddetails_layout_activity;
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
        tvTitle.setText("菜品详情");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        List<TimeLineDate> lineDates = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            lineDates.add(new TimeLineDate("", "我是第" + i + "个数据", "20170710"));
        }
        TimeAdapter timeAdapter = new TimeAdapter(this, lineDates);
        timelineRv.setAdapter(timeAdapter);
        timelineRv.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
