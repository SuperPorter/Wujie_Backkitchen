package com.txd.hzj.wujie_backkitchen.UI.Adapter.ProductionAdapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.ViewGroup;
import android.widget.TextView;

import com.txd.hzj.code_library.BaseCode.BaseRecyclerViewAdapter;
import com.txd.hzj.wujie_backkitchen.R;

/**
 * 创建者：Sunzeyu
 * <br>创建时间：下午 02:56 2019/4/18 018
 * <br>功能描述：
 */
public class AllItem_child_ItemRecyclerView_Item_Adapter extends BaseRecyclerViewAdapter<String, AllItem_child_ItemRecyclerView_Item_Adapter.AllItem_child_ItemRecyclerViewAdapter_Item_ViewHoder> {
    public AllItem_child_ItemRecyclerView_Item_Adapter(Context context) {
        super(context);
    }

    @NonNull
    @Override
    public AllItem_child_ItemRecyclerViewAdapter_Item_ViewHoder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new AllItem_child_ItemRecyclerViewAdapter_Item_ViewHoder(viewGroup, R.layout.product_rvitem_child_item);
    }

    @Override
    public void onBindViewHolder(@NonNull AllItem_child_ItemRecyclerViewAdapter_Item_ViewHoder allItem_child_itemRecyclerViewAdapter_item_viewHoder, int i) {
        allItem_child_itemRecyclerViewAdapter_item_viewHoder.allitemRvApApItemDishname.setText("蒜");
        allItem_child_itemRecyclerViewAdapter_item_viewHoder.allitemRvApApItemDishmessage.setText("不要蒜");
    }

    class AllItem_child_ItemRecyclerViewAdapter_Item_ViewHoder extends BaseRecyclerViewAdapter.ViewHolder {
        TextView allitemRvApApItemDishname;
        TextView allitemRvApApItemDishmessage;
        public AllItem_child_ItemRecyclerViewAdapter_Item_ViewHoder(ViewGroup parent, int layoutId) {
            super(parent, layoutId);
            allitemRvApApItemDishmessage = (TextView) findViewById(R.id.allitem_rv_ap_ap_item_dishmessage);
            allitemRvApApItemDishname = (TextView) findViewById(R.id.allitem_rv_ap_ap_item_dishname);
        }
    }
}
