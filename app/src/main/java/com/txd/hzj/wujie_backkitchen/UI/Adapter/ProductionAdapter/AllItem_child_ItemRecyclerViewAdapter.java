package com.txd.hzj.wujie_backkitchen.UI.Adapter.ProductionAdapter;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.view.ViewGroup;

import com.txd.hzj.code_library.BaseCode.BaseRecyclerViewAdapter;
import com.txd.hzj.code_library.View.LabelTextView;
import com.txd.hzj.code_library.View.NestRecyclerView2;
import com.txd.hzj.wujie_backkitchen.R;

import java.util.ArrayList;
import java.util.List;

/**
 * 创建者：Sunzeyu
 * <br>创建时间：上午 11:13 2019/4/18 018
 * <br>功能描述：制作主界面打开布局
 */
public class AllItem_child_ItemRecyclerViewAdapter extends BaseRecyclerViewAdapter<String, AllItem_child_ItemRecyclerViewAdapter.AllItem_child_ItemViewHoder> {
    public AllItem_child_ItemRecyclerViewAdapter(Context context) {
        super(context);
    }

    @NonNull
    @Override
    public AllItem_child_ItemViewHoder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new AllItem_child_ItemViewHoder(viewGroup, R.layout.product_rvitem_layout);
    }

    @Override
    public void onBindViewHolder(@NonNull AllItem_child_ItemViewHoder allItem_child_itemViewHoder, int i) {
        allItem_child_itemViewHoder.allitemchildItemRecyclerItemLable.setLabelBackgroundColor(Color.RED);
        allItem_child_itemViewHoder.allitemchildItemRecyclerItemLable.setLabelText("外卖订单已超时");
        allItem_child_itemViewHoder.allitemchildItemRecyclerItemLable.setLabelHeight(40);
        allItem_child_itemViewHoder.allitemchildItemRecyclerItemLable.setLabelTextColor(Color.WHITE);
        allItem_child_itemViewHoder.allitemchildItemRecyclerItemLable.setLabelDistance(90);
        allItem_child_itemViewHoder.allRvItemDishOrdersRecyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
        AllItem_child_ItemRecyclerView_Item_Adapter allItem_child_itemRecyclerView_item_adapter = new AllItem_child_ItemRecyclerView_Item_Adapter(getContext());
        List<String> list = new ArrayList<>();
        for (int i1 = 0; i1 < 20; i1++) {
            list.add("测试" + i1);
        }
        allItem_child_itemRecyclerView_item_adapter.setData(list);
        allItem_child_itemViewHoder.allRvItemDishOrdersRecyclerview.setAdapter(allItem_child_itemRecyclerView_item_adapter);

    }
    class AllItem_child_ItemViewHoder extends BaseRecyclerViewAdapter.ViewHolder {

        NestRecyclerView2 allRvItemDishOrdersRecyclerview;
        LabelTextView allitemchildItemRecyclerItemLable;
        public AllItem_child_ItemViewHoder(ViewGroup parent, int layoutId) {
            super(parent, layoutId);
            allitemchildItemRecyclerItemLable = (LabelTextView) findViewById(R.id.allitemchild_item_recycler_item_lable);
            allRvItemDishOrdersRecyclerview = (NestRecyclerView2) findViewById(R.id.all_rv_item_dish_orders_recyclerview);
        }
    }
}
