package com.txd.hzj.wujie_backkitchen.UI.Activity;

import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.txd.hzj.code_library.BaseCode.BaseRecyclerViewAdapter;
import com.txd.hzj.wujie_backkitchen.R;
import com.txd.hzj.wujie_backkitchen.UI.Adapter.DestineAdapter.BookingDetailsAdapter;
import com.txd.hzj.wujie_backkitchen.UI.Dialog.RecieveTaskDialog;
import com.txd.hzj.wujie_backkitchen.UI.base.UIActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 创建者：Sunzeyu
 * <br>创建时间：下午 02:48 2019/4/22 022
 * <br>功能描述：预定详情界面
 */
public class BookingDetailsActivity extends UIActivity {
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.booking_deta_rv)
    RecyclerView bookingDetaRv;

    @Override
    protected int getLayoutId() {
        return R.layout.booking_deta_layout;
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
        tvTitle.setText("预定详情");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        bookingDetaRv.setLayoutManager(new LinearLayoutManager(this));
        //添加下划线
        bookingDetaRv.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        BookingDetailsAdapter adapter = new BookingDetailsAdapter(this);
        //点击领取任务的时候
        adapter.setOnChildClickListener(R.id.recieve_the_task, new BaseRecyclerViewAdapter.OnChildClickListener() {
            @Override
            public void onChildClick(RecyclerView recyclerView, View childView, int position) {
                new RecieveTaskDialog.Builder(getActivity()).show();
            }
        });
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add("测试");
        }
        adapter.setData(list);
        bookingDetaRv.setAdapter(adapter);
    }
}
