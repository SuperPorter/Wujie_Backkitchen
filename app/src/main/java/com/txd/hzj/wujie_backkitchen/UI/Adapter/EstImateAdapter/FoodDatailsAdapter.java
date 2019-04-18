package com.txd.hzj.wujie_backkitchen.UI.Adapter.EstImateAdapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.ViewGroup;

import com.txd.hzj.code_library.BaseCode.BaseRecyclerViewAdapter;
import com.txd.hzj.wujie_backkitchen.R;

/**
 * 创建者：Sunzeyu
 * <br>创建时间：下午 05:38 2019/4/18 018
 * <br>功能描述：
 */
public class FoodDatailsAdapter extends BaseRecyclerViewAdapter<String,FoodDatailsAdapter.FoodDatailsViewHoder>{
    public FoodDatailsAdapter(Context context) {
        super(context);
    }

    @NonNull
    @Override
    public FoodDatailsViewHoder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new FoodDatailsViewHoder(viewGroup, R.layout.food_details_rv_item);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodDatailsViewHoder foodDatailsViewHoder, int i) {

    }

    class FoodDatailsViewHoder extends BaseRecyclerViewAdapter.ViewHolder{

        public FoodDatailsViewHoder(ViewGroup parent, int layoutId) {
            super(parent, layoutId);
        }
    }
}
