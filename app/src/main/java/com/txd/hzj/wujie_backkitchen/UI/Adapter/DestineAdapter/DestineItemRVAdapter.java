package com.txd.hzj.wujie_backkitchen.UI.Adapter.DestineAdapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.txd.hzj.code_library.BaseCode.BaseRecyclerViewAdapter;
import com.txd.hzj.code_library.View.NestRecyclerView2;
import com.txd.hzj.wujie_backkitchen.R;

import java.util.ArrayList;
import java.util.List;

/**
 * 创建者：Sunzeyu
 * <br>创建时间：下午 05:45 2019/4/19 019
 * <br>功能描述：
 */
public class DestineItemRVAdapter extends BaseRecyclerViewAdapter<String,DestineItemRVAdapter.DestineItemRVViewHoder>{
    public DestineItemRVAdapter(Context context) {
        super(context);
    }

    @NonNull
    @Override
    public DestineItemRVViewHoder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new DestineItemRVViewHoder(viewGroup, R.layout.destine_itemrv_layout);
    }

    @Override
    public void onBindViewHolder(@NonNull DestineItemRVViewHoder destineItemRVViewHoder, int i) {
        destineItemRVViewHoder.recyclerViewAllChild.setLayoutManager(new LinearLayoutManager(getContext()));
        List<String> list = new ArrayList<>();
        for (int i1 = 0; i1 < 20; i1++) {
            list.add("");
        }
        DestineItemChildItemAdapter adapter = new DestineItemChildItemAdapter(getContext());
        adapter.setData(list);
        destineItemRVViewHoder.recyclerViewAllChild.setAdapter(adapter);
    }

    class DestineItemRVViewHoder extends BaseRecyclerViewAdapter.ViewHolder {
        private NestRecyclerView2 recyclerViewAllChild;
        private ImageView allChildItemIvIcon;
        private TextView allChildItemOrderName;
        private TextView allChildItemOrderTime;
        public DestineItemRVViewHoder(ViewGroup parent, int layoutId) {
            super(parent, layoutId);
            recyclerViewAllChild = (NestRecyclerView2) findViewById(R.id.recycler_view_all_child);
            allChildItemIvIcon = (ImageView) findViewById(R.id.all_child_item_iv_icon);
            allChildItemOrderName = (TextView) findViewById(R.id.all_child_item_order_name);
            allChildItemOrderTime = (TextView) findViewById(R.id.all_child_item_order_time);
        }
    }
}
