package com.txd.hzj.wujie_backkitchen.UI.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.ViewGroup;
import android.widget.TextView;

import com.txd.hzj.code_library.BaseCode.BaseRecyclerViewAdapter;
import com.txd.hzj.wujie_backkitchen.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @时间: 2019/4/17 22:12
 * @功能:
 */
public class AllchildRecyclerViewAdapter extends BaseRecyclerViewAdapter<String,AllchildRecyclerViewAdapter.AllchildViewHoder>{
    public AllchildRecyclerViewAdapter(Context context) {
        super(context);
    }

    @NonNull
    @Override
    public AllchildViewHoder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new AllchildViewHoder(viewGroup, R.layout.all_child_item_item_layout);
    }

    @Override
    public void onBindViewHolder(@NonNull AllchildViewHoder allchildViewHoder, int i) {
        String s = getData().get(i);
        allchildViewHoder.all_tv.setText(s);
    }

    class AllchildViewHoder extends BaseRecyclerViewAdapter.ViewHolder{
        @BindView(R.id.all_item_item_tv)
        TextView all_tv;
        public AllchildViewHoder(ViewGroup parent, int layoutId) {
            super(parent, layoutId);
            ButterKnife.bind(this, itemView);
        }
    }
}
