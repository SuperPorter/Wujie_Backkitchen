package com.txd.hzj.wujie_backkitchen.UI.Adapter.EstImateAdapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.ViewGroup;

import com.txd.hzj.code_library.BaseCode.BaseRecyclerViewAdapter;
import com.txd.hzj.wujie_backkitchen.R;

/**
 * 创建者：Sunzeyu
 * <br>创建时间：下午 04:21 2019/4/18 018
 * <br>功能描述：
 */
public class EsimateItemAdapter extends BaseRecyclerViewAdapter<String,EsimateItemAdapter.EsimItemViewHoder>{
    public EsimateItemAdapter(Context context) {
        super(context);
    }

    @NonNull
    @Override
    public EsimItemViewHoder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new EsimItemViewHoder(viewGroup, R.layout.esim_item_layout);
    }

    @Override
    public void onBindViewHolder(@NonNull EsimItemViewHoder esimItemViewHoder, int i) {

    }

    class EsimItemViewHoder extends BaseRecyclerViewAdapter.ViewHolder{

        public EsimItemViewHoder(ViewGroup parent, int layoutId) {
            super(parent, layoutId);
        }
    }
}
