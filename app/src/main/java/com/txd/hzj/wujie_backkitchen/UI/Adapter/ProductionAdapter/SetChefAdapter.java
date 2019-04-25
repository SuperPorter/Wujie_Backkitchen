package com.txd.hzj.wujie_backkitchen.UI.Adapter.ProductionAdapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.ViewGroup;

import com.txd.hzj.code_library.BaseCode.BaseRecyclerViewAdapter;
import com.txd.hzj.wujie_backkitchen.R;

/**
 * 创建者：Sunzeyu
 * <br>创建时间：下午 02:24 2019/4/22 022
 * <br>功能描述：厨师详情界面适配器
 */
public class SetChefAdapter extends BaseRecyclerViewAdapter<String,SetChefAdapter.ViewHoder>{
    public SetChefAdapter(Context context) {
        super(context);
    }

    @NonNull
    @Override
    public ViewHoder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHoder(viewGroup, R.layout.setchef_item_layout);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHoder viewHoder, int i) {

    }
    class ViewHoder extends BaseRecyclerViewAdapter.ViewHolder{
        public ViewHoder(ViewGroup parent, int layoutId) {
            super(parent, layoutId);
        }
    }
}
