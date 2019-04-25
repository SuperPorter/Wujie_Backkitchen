package com.txd.hzj.wujie_backkitchen.UI.Fragent.ProductionFragment;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.txd.hzj.code_library.BaseCode.BaseRecyclerViewAdapter;
import com.txd.hzj.code_library.View.FullyGridLayoutManager;
import com.txd.hzj.code_library.View.RecyclerViewScrollView;
import com.txd.hzj.wujie_backkitchen.R;
import com.txd.hzj.wujie_backkitchen.UI.Activity.FoodDeatails.FoodDetailsActivity;
import com.txd.hzj.wujie_backkitchen.UI.Adapter.ProductionAdapter.AllItem_child_ItemRecyclerViewAdapter;
import com.txd.hzj.wujie_backkitchen.UI.Adapter.AdapterUtils.GridSpacingItemDecoration;
import com.txd.hzj.wujie_backkitchen.UI.base.UiLazyFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 创建者：Sunzeyu
 * <br>创建时间：上午 11:08 2019/4/18 018
 * <br>功能描述：制作详情打开界面
 */
public class ProductionItemFragment extends UiLazyFragment {

    @BindView(R.id.alldetails_item_recycelrview)
    RecyclerViewScrollView alldetailsItemRecycelrview;
    private AllItem_child_ItemRecyclerViewAdapter allItem_child_itemRecyclerViewAdapter;
    private FullyGridLayoutManager fullyGridLayoutManager;

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
        allItem_child_itemRecyclerViewAdapter = new AllItem_child_ItemRecyclerViewAdapter(getContext());
        allItem_child_itemRecyclerViewAdapter.setData(list);
        //点击查看详情
        allItem_child_itemRecyclerViewAdapter.setOnChildClickListener(R.id.food_detils_rvitem, new BaseRecyclerViewAdapter.OnChildClickListener() {
            @Override
            public void onChildClick(RecyclerView recyclerView, View childView, int position) {
                startActivity(FoodDetailsActivity.class);
            }
        });
        fullyGridLayoutManager = new FullyGridLayoutManager(getContext(), 2);
        alldetailsItemRecycelrview.addItemDecoration(new GridSpacingItemDecoration(2,10,true));
        alldetailsItemRecycelrview.setLayoutManager(fullyGridLayoutManager);
        alldetailsItemRecycelrview.setAdapter(allItem_child_itemRecyclerViewAdapter);
    }
}
