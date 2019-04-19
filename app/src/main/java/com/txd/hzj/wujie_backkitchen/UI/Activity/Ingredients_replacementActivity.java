package com.txd.hzj.wujie_backkitchen.UI.Activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import com.txd.hzj.uicode.SingleButton.SmoothCheckBox;
import com.txd.hzj.wujie_backkitchen.R;
import com.txd.hzj.wujie_backkitchen.UI.Adapter.EstImateAdapter.FoodDatailsAdapter;
import com.txd.hzj.wujie_backkitchen.UI.base.UIActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 创建者：Sunzeyu
 * <br>创建时间：下午 03:42 2019/4/18 018
 * <br>功能描述：食材替换
 */
@SuppressLint("Registered")
public class Ingredients_replacementActivity extends UIActivity {
    @BindView(R.id.food_details_allbutton)
    SmoothCheckBox foodDetailsAllbutton;
    @BindView(R.id.food_details_rv)
    RecyclerView foodDetailsRv;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    private FoodDatailsAdapter adapter;

    @Override
    protected int getLayoutId() {
        return R.layout.food_replays_layout;
    }

    @Override
    protected int getTitleBarId() {
        return R.id.toolbar;
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
    protected void initView() {
        //点击全选按钮的时候发生的事件
        foodDetailsAllbutton.setOnCheckedChangeListener(new SmoothCheckBox.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(SmoothCheckBox checkBox, boolean isChecked) {
                //如果按下的话
                if (isChecked) {
                    adapter.selectAll();
                } else {
                    adapter.Funxuan();
                }
            }
        });
    }


    @Override
    protected void initData() {
        tvTitle.setText("食材替换");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        List<String> list = new ArrayList<>();
        HashMap<Integer, Boolean> map = new HashMap<>();
        for (int i = 0; i < 20; i++) {
            list.add(i + "");
            map.put(i, false);
        }
        foodDetailsRv.setLayoutManager(new LinearLayoutManager(getContext()));
        foodDetailsRv.addItemDecoration(new DividerItemDecoration(getContext(), RecyclerView.VERTICAL));
        adapter = new FoodDatailsAdapter(getContext());
        adapter.setData(list);
        adapter.SetCheckBoxMap(map);
        foodDetailsRv.setAdapter(adapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
