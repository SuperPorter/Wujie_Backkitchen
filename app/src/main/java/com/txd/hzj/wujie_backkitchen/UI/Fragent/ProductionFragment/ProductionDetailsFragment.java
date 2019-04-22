package com.txd.hzj.wujie_backkitchen.UI.Fragent.ProductionFragment;

import android.annotation.SuppressLint;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.txd.hzj.code_library.BaseCode.BaseLazyFragment;
import com.txd.hzj.code_library.BaseCode.BaseRecyclerViewAdapter;
import com.txd.hzj.code_library.Utils.utils.android.DateTimeAndroidUtil;
import com.txd.hzj.code_library.Utils.utils.android.ToastUtils;
import com.txd.hzj.code_library.View.FullyGridLayoutManager;
import com.txd.hzj.code_library.View.RecyclerViewScrollView;
import com.txd.hzj.wujie_backkitchen.Bean.MyItemBean;
import com.txd.hzj.wujie_backkitchen.R;
import com.txd.hzj.wujie_backkitchen.UI.Activity.OrderdetailsActivity;
import com.txd.hzj.wujie_backkitchen.UI.Adapter.ProductionAdapter.AllItemRecyclerViewAdapter;
import com.txd.hzj.wujie_backkitchen.UI.Adapter.AdapterUtils.GridSpacingItemDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 创建者：Sunzeyu
 * <br>创建时间：下午 02:35 2019/4/17 017
 * <br>功能描述：制作界面
 */
public class ProductionDetailsFragment extends BaseLazyFragment {
    @BindView(R.id.all_tiem_layout)
    RecyclerViewScrollView allTiemLayout;
    private AllItemRecyclerViewAdapter adapter;
    private FullyGridLayoutManager gridLayoutManager;

    @Override
    protected int getLayoutId() {
        return R.layout.product_vpitem_layout;
    }

    @Override
    protected int getTitleBarId() {
        return 0;
    }

    @SuppressLint("NewApi")
    @Override
    protected void initView() {

    }


    @Override
    protected void initData() {
        final List<MyItemBean> lists = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            MyItemBean myItemBean = new MyItemBean();
            myItemBean.setName("测试"+i);
            myItemBean.setTime(DateTimeAndroidUtil.getNowTime()+"测试");
            lists.add(myItemBean);
        }
        adapter = new AllItemRecyclerViewAdapter(getContext());
        adapter.setData(lists);
        adapter.setOnItemClickListener(new BaseRecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(RecyclerView recyclerView, View itemView, int position) {
                //点击事件
                startActivity(OrderdetailsActivity.class);
            }
        });
        allTiemLayout.setAdapter(adapter);
        //设置两排显示
        gridLayoutManager = new FullyGridLayoutManager(getContext(), 2);
        allTiemLayout.addItemDecoration(new GridSpacingItemDecoration(2,10,false));
        allTiemLayout.setLayoutManager(gridLayoutManager);
    }
}
