package com.txd.hzj.wujie_backkitchen.UI.Activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.txd.hzj.uicode.SingleButton.SmoothCheckBox;
import com.txd.hzj.wujie_backkitchen.R;
import com.txd.hzj.wujie_backkitchen.UI.Adapter.EstImateAdapter.FoodDatailsAdapter;
import com.txd.hzj.wujie_backkitchen.UI.base.UIActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 创建者：Sunzeyu
 * <br>创建时间：下午 03:42 2019/4/18 018
 * <br>功能描述：食材替换
 */
@SuppressLint("Registered")
public class Food_detailsActivity extends UIActivity {
    @BindView(R.id.tv_title_toolbar)
    TextView tvTitleToolbar;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.food_details_allbutton)
    SmoothCheckBox foodDetailsAllbutton;
    @BindView(R.id.food_details_rv)
    RecyclerView foodDetailsRv;

    @Override
    protected int getLayoutId() {
        return R.layout.food_details_layout;
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
        tvTitleToolbar.setText("食材替换");
        setSupportActionBar(toolbar);
        toolbar.setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add(i + "");
        }
        foodDetailsRv.setLayoutManager(new LinearLayoutManager(getContext()));
        foodDetailsRv.addItemDecoration(new DividerItemDecoration(getContext(),RecyclerView.VERTICAL));
        FoodDatailsAdapter adapter = new FoodDatailsAdapter(getContext());
        adapter.setData(list);
        foodDetailsRv.setAdapter(adapter);

    }
}
