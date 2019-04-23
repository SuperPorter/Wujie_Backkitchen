package com.txd.hzj.wujie_backkitchen.UI.Fragent.DestineFragment;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.txd.hzj.code_library.BaseCode.BaseLazyFragment;
import com.txd.hzj.code_library.BaseCode.BaseRecyclerViewAdapter;
import com.txd.hzj.code_library.View.FullyGridLayoutManager;
import com.txd.hzj.code_library.View.RecyclerViewScrollView;
import com.txd.hzj.wujie_backkitchen.R;
import com.txd.hzj.wujie_backkitchen.UI.Activity.BookingDatails.BookingDetailsActivity;
import com.txd.hzj.wujie_backkitchen.UI.Adapter.AdapterUtils.GridSpacingItemDecoration;
import com.txd.hzj.wujie_backkitchen.UI.Adapter.DestineAdapter.DestineItemRVAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 创建者：Sunzeyu
 * <br>创建时间：下午 05:38 2019/4/19 019
 * <br>功能描述：
 */
public class DestineItemFragment extends BaseLazyFragment {

    @BindView(R.id.alldetails_item_recycelrview)
    RecyclerViewScrollView alldetailsItemRecycelrview;

    @Override
    protected int getLayoutId() {
        return R.layout.product_details_layout;
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
        //设置两排显示
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add(i + "测试");
        }
        DestineItemRVAdapter allItem_child_itemRecyclerViewAdapter = new DestineItemRVAdapter(getContext());
        allItem_child_itemRecyclerViewAdapter.setData(list);
        //点击查看详情
        allItem_child_itemRecyclerViewAdapter.setOnItemClickListener(new BaseRecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(RecyclerView recyclerView, View itemView, int position) {
                startActivity(BookingDetailsActivity.class);
            }
        });
        alldetailsItemRecycelrview.setAdapter(allItem_child_itemRecyclerViewAdapter);
        FullyGridLayoutManager fullyGridLayoutManager = new FullyGridLayoutManager(getContext(), 2);
        alldetailsItemRecycelrview.addItemDecoration(new GridSpacingItemDecoration(2,16,true));
        alldetailsItemRecycelrview.setLayoutManager(fullyGridLayoutManager);
    }

}
