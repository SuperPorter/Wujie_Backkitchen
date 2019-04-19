package com.txd.hzj.wujie_backkitchen.UI.Adapter.DestineAdapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.ViewGroup;

import com.txd.hzj.code_library.BaseCode.BaseRecyclerViewAdapter;
import com.txd.hzj.wujie_backkitchen.R;

/**
 * 创建者：Sunzeyu
 * <br>创建时间：下午 06:02 2019/4/19 019
 * <br>功能描述：
 */
public class DestineItemChildItemAdapter extends BaseRecyclerViewAdapter<String,DestineItemChildItemAdapter.DestineItemChildItemViewHoder>{

    public DestineItemChildItemAdapter(Context context) {
        super(context);
    }

    @NonNull
    @Override
    public DestineItemChildItemViewHoder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new DestineItemChildItemViewHoder(viewGroup, R.layout.dest_item_child_item_layout);
    }
    @Override
    public void onBindViewHolder(@NonNull DestineItemChildItemViewHoder destineItemChildItemViewHoder, int i) {

    }

    class DestineItemChildItemViewHoder extends BaseRecyclerViewAdapter.ViewHolder{

        public DestineItemChildItemViewHoder(ViewGroup parent, int layoutId) {
            super(parent, layoutId);
        }
    }
}
