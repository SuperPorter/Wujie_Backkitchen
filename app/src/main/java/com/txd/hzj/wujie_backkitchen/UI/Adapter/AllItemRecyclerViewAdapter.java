package com.txd.hzj.wujie_backkitchen.UI.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.txd.hzj.code_library.BaseCode.BaseRecyclerViewAdapter;
import com.txd.hzj.code_library.View.NestRecyclerView;
import com.txd.hzj.wujie_backkitchen.Bean.MyItemBean;
import com.txd.hzj.wujie_backkitchen.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 创建者：Sunzeyu
 * <br>创建时间：下午 05:13 2019/4/17 017
 * <br>功能描述：
 */
public class AllItemRecyclerViewAdapter extends BaseRecyclerViewAdapter<List<MyItemBean>, AllItemRecyclerViewAdapter.ItemViewHoder> {

    public AllItemRecyclerViewAdapter(Context context) {
        super(context);
    }

    @NonNull
    @Override
    public ItemViewHoder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ItemViewHoder(viewGroup, R.layout.all_child_item_layout);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHoder itemViewHoder, int i) {
        //绑定数据
        List<MyItemBean> myItemBeans = getData().get(i);
        itemViewHoder.recyclerViewAllChild.setLayoutManager(new LinearLayoutManager(getContext()));
        List<String> list = new ArrayList<>();
        for (int i1 = 0; i1 < 50; i1++) {
            list.add(i + "测试");
        }
        AllchildRecyclerViewAdapter allchildRecyclerViewAdapter = new AllchildRecyclerViewAdapter(getContext());
        allchildRecyclerViewAdapter.setData(list);
        itemViewHoder.recyclerViewAllChild.setAdapter(allchildRecyclerViewAdapter);
    }

    class ItemViewHoder extends BaseRecyclerViewAdapter.ViewHolder {
        private NestRecyclerView recyclerViewAllChild;
        private ItemViewHoder(ViewGroup parent, int layoutId) {
            super(parent, layoutId);
            recyclerViewAllChild = (NestRecyclerView) findViewById(R.id.recycler_view_all_child);
        }
    }
}
