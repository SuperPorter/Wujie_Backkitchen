package com.txd.hzj.wujie_backkitchen.UI.Activity.FoodDeatails;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.txd.hzj.wujie_backkitchen.Bean.TimeLineDate;
import com.txd.hzj.wujie_backkitchen.MVPCode.MvpActivity;
import com.txd.hzj.wujie_backkitchen.R;
import com.txd.hzj.wujie_backkitchen.UI.Activity.SetChef.SetChefActivity;
import com.txd.hzj.wujie_backkitchen.UI.Adapter.ProductionAdapter.TimeAdapter;
import com.txd.hzj.wujie_backkitchen.UI.Dialog.PickingSettingsDialog;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 创建者：Sunzeyu
 * <br>创建时间：下午 05:12 2019/4/18 018
 * <br>功能描述：菜品详情
 */
public class FoodDetailsActivity extends MvpActivity<FoodDetailsPresent> implements FoodDetailsContract.View,View.OnClickListener {
    @BindView(R.id.timeline_rv)
    RecyclerView timelineRv;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.pickingsetting)
    TextView pickingsetting;
    @BindView(R.id.Set_chef)
    TextView SetChef;

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
        pickingsetting.setOnClickListener(this);
        SetChef.setOnClickListener(this);
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
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.pickingsetting: {
                List<String> list = new ArrayList<>();
                for (int i = 0; i < 10; i++) {
                    list.add(i + "测试");
                }
                new PickingSettingsDialog.Builder(this).setData(list).show();
                break;
            }
            case R.id.Set_chef:
            {
                //跳转到设置制作厨师界面
                startActivity(SetChefActivity.class);
                break;
            }
        }
    }

    @Override
    protected FoodDetailsPresent createPresenter() {
        return new FoodDetailsPresent();
    }

    @Override
    public void ShowLoading() {

    }

    @Override
    public void loadingComplete() {

    }

    @Override
    public void showEmpty() {

    }

    @Override
    public void showError() {

    }
}
