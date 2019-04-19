package com.txd.hzj.wujie_backkitchen.UI.Adapter.EstImateAdapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.ViewGroup;

import com.txd.hzj.code_library.BaseCode.BaseRecyclerViewAdapter;
import com.txd.hzj.uicode.SingleButton.SmoothCheckBox;
import com.txd.hzj.wujie_backkitchen.R;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 创建者：Sunzeyu
 * <br>创建时间：下午 05:38 2019/4/18 018
 * <br>功能描述：
 */
public class FoodDatailsAdapter extends BaseRecyclerViewAdapter<String, FoodDatailsAdapter.FoodDatailsViewHoder> {
    //存放
    private HashMap<Integer,Boolean> map;
    //设置选中状态
    public void SetCheckBoxMap(HashMap<Integer,Boolean> map){
        this.map = map;
    }
    public FoodDatailsAdapter(Context context) {
        super(context);
    }
    @NonNull
    @Override
    public FoodDatailsViewHoder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new FoodDatailsViewHoder(viewGroup, R.layout.food_replays_rv_item);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodDatailsViewHoder foodDatailsViewHoder, final int i) {
        //设置选中状态
        foodDatailsViewHoder.foodDetailsRvItemCheckbox.setChecked(map.get(i));
        //选中的时候更新数据
        foodDatailsViewHoder.foodDetailsRvItemCheckbox.setOnCheckedChangeListener(new SmoothCheckBox.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(SmoothCheckBox checkBox, boolean isChecked) {

            }
        });
    }
    //全选
    public void selectAll(){
        Set<Map.Entry<Integer, Boolean>> entries = map.entrySet();
        boolean shouldAll = false;
        for (Map.Entry<Integer, Boolean> entry : entries) {
            Boolean value = entry.getValue();
            if (!value) {
                shouldAll = true;
                break;
            }
        }
        for (Map.Entry<Integer, Boolean> entry : entries) {
            entry.setValue(shouldAll);
        }
        notifyDataSetChanged();
    }
    //反选
    public void Funxuan(){
        Set<Map.Entry<Integer, Boolean>> entrie = map.entrySet();
        for (Map.Entry<Integer, Boolean> integerBooleanEntry : entrie) {
            integerBooleanEntry.setValue(!integerBooleanEntry.getValue());
        }
        notifyDataSetChanged();
    }

    //单选
    public void singleCheck(int position) {
        Set<Map.Entry<Integer, Boolean>> entrie = map.entrySet();
        for (Map.Entry<Integer, Boolean> integerBooleanEntry : entrie) {
            integerBooleanEntry.setValue(false);
        }
        map.put(position, true);
        notifyDataSetChanged();
    }
    class FoodDatailsViewHoder extends BaseRecyclerViewAdapter.ViewHolder {
        SmoothCheckBox foodDetailsRvItemCheckbox;
        public FoodDatailsViewHoder(ViewGroup parent, int layoutId) {
            super(parent, layoutId);
            foodDetailsRvItemCheckbox = (SmoothCheckBox) findViewById(R.id.food_details_rv_item_checkbox);
        }
    }
}
