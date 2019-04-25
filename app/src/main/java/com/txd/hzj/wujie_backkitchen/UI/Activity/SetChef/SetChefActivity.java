package com.txd.hzj.wujie_backkitchen.UI.Activity.SetChef;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import com.txd.hzj.wujie_backkitchen.MVPCode.MvpActivity;
import com.txd.hzj.wujie_backkitchen.R;
import com.txd.hzj.wujie_backkitchen.UI.Adapter.ProductionAdapter.SetChefAdapter;
import com.txd.hzj.wujie_backkitchen.UI.base.UIActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 创建者：Sunzeyu
 * <br>创建时间：下午 02:20 2019/4/22 022
 * <br>功能描述：设置厨师界面
 */
public class SetChefActivity extends MvpActivity<SetChefPresenter> implements SetChefContract.View {
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.setchef_rv)
    RecyclerView setchefRv;

    @Override
    protected int getLayoutId() {
        return R.layout.setchef_layout;
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
        tvTitle.setText("设置制作厨师");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setchefRv.setLayoutManager(new GridLayoutManager(this, 5));

        SetChefAdapter adapter = new SetChefAdapter(getContext());
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            list.add("测试赛");
        }
        adapter.setData(list);
        setchefRv.setAdapter(adapter);
    }

    @Override
    protected SetChefPresenter createPresenter() {
        return new SetChefPresenter();
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
