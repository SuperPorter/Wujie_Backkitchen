package com.txd.hzj.wujie_backkitchen.UI.Fragent.AllChildFragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.txd.hzj.code_library.BaseCode.BaseLazyFragment;
import com.txd.hzj.wujie_backkitchen.Bean.MyItemBean;
import com.txd.hzj.wujie_backkitchen.R;
import com.txd.hzj.wujie_backkitchen.UI.Adapter.AllItemRecyclerViewAdapter;
import com.txd.hzj.wujie_backkitchen.UI.Adapter.GridSpacingItemDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 创建者：Sunzeyu
 * <br>创建时间：下午 02:35 2019/4/17 017
 * <br>功能描述：
 */
public class ItemFragment extends BaseLazyFragment {
    @BindView(R.id.all_tiem_layout)
    RecyclerView allTiemLayout;
    private AllItemRecyclerViewAdapter adapter;
    private GridLayoutManager gridLayoutManager;

    @Override
    protected int getLayoutId() {
        return R.layout.all_item_layout;
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
        ArrayList<List<MyItemBean>> lists = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            lists.add(new ArrayList<MyItemBean>());
        }
        adapter = new AllItemRecyclerViewAdapter(getContext());
        adapter.setData(lists);
        allTiemLayout.setAdapter(adapter);
        //设置两排显示
        gridLayoutManager = new GridLayoutManager(getFragmentActivity(), 2);
        allTiemLayout.addItemDecoration(new GridSpacingItemDecoration(2,10,false));
        allTiemLayout.setLayoutManager(gridLayoutManager);
    }
}
