package com.txd.hzj.wujie_backkitchen.UI.Fragent.EstimateFragment;

import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.txd.hzj.code_library.BaseCode.BaseLazyFragment;
import com.txd.hzj.code_library.BaseCode.BaseRecyclerViewAdapter;
import com.txd.hzj.code_library.View.RecyclerViewScrollView;
import com.txd.hzj.wujie_backkitchen.R;
import com.txd.hzj.wujie_backkitchen.UI.Activity.Ingredients_replacementActivity;
import com.txd.hzj.wujie_backkitchen.UI.Adapter.EstImateAdapter.EsimateItemAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 创建者：Sunzeyu
 * <br>创建时间：下午 03:53 2019/4/18 018
 * <br>功能描述：
 */
public class EstimateItemFragment extends BaseLazyFragment {


    @BindView(R.id.all_tiem_layout)
    RecyclerViewScrollView allTiemLayout;

    @Override
    protected int getLayoutId() {
        return R.layout.product_vpitem_layout;
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
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add("0" + i);
        }
        EsimateItemAdapter adapter = new EsimateItemAdapter(getContext());
        adapter.setData(list);
        adapter.setOnItemClickListener(new BaseRecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(RecyclerView recyclerView, View itemView, int position) {
                startActivity(Ingredients_replacementActivity.class);
            }
        });
        allTiemLayout.setAdapter(adapter);
        allTiemLayout.setLayoutManager(new LinearLayoutManager(getContext()));
        allTiemLayout.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayout.VERTICAL));
    }
}
