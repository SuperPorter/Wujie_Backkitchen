package com.txd.hzj.wujie_backkitchen.UI.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.txd.hzj.code_library.BaseCode.BaseRecyclerViewAdapter;
import com.txd.hzj.wujie_backkitchen.Bean.MyItemBean;
import com.txd.hzj.wujie_backkitchen.R;

import java.util.List;

import butterknife.ButterKnife;

/**
 * 创建者：Sunzeyu
 * <br>创建时间：下午 05:13 2019/4/17 017
 * <br>功能描述：
 */
public class AllItemRecyclerViewAdapter extends BaseRecyclerViewAdapter<List<MyItemBean>,AllItemRecyclerViewAdapter.ItemViewHoder>{

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
    }

    class ItemViewHoder extends BaseRecyclerViewAdapter.ViewHolder{

        public ItemViewHoder(ViewGroup parent, int layoutId) {
            super(parent, layoutId);
            ButterKnife.bind(this, parent);
        }
    }
}
