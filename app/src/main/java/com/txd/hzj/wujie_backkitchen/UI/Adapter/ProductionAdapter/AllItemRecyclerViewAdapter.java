package com.txd.hzj.wujie_backkitchen.UI.Adapter.ProductionAdapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.txd.hzj.code_library.BaseCode.BaseRecyclerViewAdapter;
import com.txd.hzj.code_library.View.NestRecyclerView2;
import com.txd.hzj.wujie_backkitchen.Bean.MyAllChildItemBean;
import com.txd.hzj.wujie_backkitchen.Bean.MyItemBean;
import com.txd.hzj.wujie_backkitchen.R;

import java.util.ArrayList;
import java.util.List;

/**
 * 创建者：Sunzeyu
 * <br>创建时间：下午 05:13 2019/4/17 017
 * <br>功能描述：
 */
public class AllItemRecyclerViewAdapter extends BaseRecyclerViewAdapter<MyItemBean, AllItemRecyclerViewAdapter.ItemViewHoder> {

    public AllItemRecyclerViewAdapter(Context context) {
        super(context);
    }

    @NonNull
    @Override
    public ItemViewHoder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ItemViewHoder(viewGroup, R.layout.product_item_layout);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHoder itemViewHoder, int i) {
        //绑定数据
        MyItemBean myItemBean = getData().get(i);
        List<MyAllChildItemBean> list = new ArrayList<>();
        itemViewHoder.allChildItemOrderTime.setText(myItemBean.getTime());
        itemViewHoder.allChildItemOrderName.setText(myItemBean.getName());
        Glide.with(getContext())
                .load(R.drawable.ic_launcher_background)
                .apply(RequestOptions.bitmapTransform(new CircleCrop()))
                .into(itemViewHoder.allChildItemIvIcon);
        for (int i1 = 0; i1 < 50; i1++) {
            MyAllChildItemBean bean = new MyAllChildItemBean();
            bean.setName(i%3==1?"菜品A":"菜品B");
            bean.setNote(i%3==1?"请注意制作时间":"第三次催单");
            bean.setTime("14903387320000");
            bean.setType(i%2==1?"1":"2");
            list.add(bean);
        }
        AllchildRecyclerViewAdapter allchildRecyclerViewAdapter = new AllchildRecyclerViewAdapter(getContext());
        allchildRecyclerViewAdapter.setData(list);
        //点击事件
        allchildRecyclerViewAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(RecyclerView recyclerView, View itemView, int position) {
                //点击跳转到具体的页面，具体还是空界面

            }
        });
        itemViewHoder.recyclerViewAllChild.setLayoutManager(new LinearLayoutManager(getContext()));
        itemViewHoder.recyclerViewAllChild.setAdapter(allchildRecyclerViewAdapter);

    }

    class ItemViewHoder extends BaseRecyclerViewAdapter.ViewHolder {
        private NestRecyclerView2 recyclerViewAllChild;
        private ImageView allChildItemIvIcon;
        private TextView allChildItemOrderName;
        private TextView allChildItemOrderTime;
        private ItemViewHoder(ViewGroup parent, int layoutId) {
            super(parent, layoutId);
            recyclerViewAllChild = (NestRecyclerView2) findViewById(R.id.recycler_view_all_child);
            allChildItemIvIcon = (ImageView) findViewById(R.id.all_child_item_iv_icon);
            allChildItemOrderName = (TextView) findViewById(R.id.all_child_item_order_name);
            allChildItemOrderTime = (TextView) findViewById(R.id.all_child_item_order_time);
        }
    }
}
