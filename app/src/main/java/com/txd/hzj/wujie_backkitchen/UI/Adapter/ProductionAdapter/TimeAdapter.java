package com.txd.hzj.wujie_backkitchen.UI.Adapter.ProductionAdapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.txd.hzj.wujie_backkitchen.Bean.TimeLineDate;
import com.txd.hzj.wujie_backkitchen.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 时间轴适配器
 */
public class TimeAdapter extends RecyclerView.Adapter<TimeAdapter.ViewHolder>{
    private Context activity;
    private List<TimeLineDate> data;
    private static final int TYPE_TOP = 0x0000;
    private static final int TYPE_NORMAL = 0x0001;

    public TimeAdapter(Context mainActivity, List<TimeLineDate> list) {
        this.activity = mainActivity;
        this.data = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //布局绑定
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.tiemview, parent, false));
    }
    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return TYPE_TOP;
        }
        return TYPE_NORMAL;
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        ViewHolder itemHolder = (ViewHolder) viewHolder;
        if (getItemViewType(i) == TYPE_TOP) {
            // 第一行头的竖线不显示
            itemHolder.tvTopLine.setVisibility(View.INVISIBLE);
            itemHolder.tvDot.setImageResource(R.mipmap.time_ok);
        } else if (getItemViewType(i) == TYPE_NORMAL) {
            //最后一行不显示
            itemHolder.tvTopLine.setVisibility(View.VISIBLE);
        }
        if (i == data.size() - 1) {
            itemHolder.tv_bootmLine.setVisibility(View.INVISIBLE);
        }
        //使用圆角头像
        Glide.with(activity)
                .load(R.drawable.ic_launcher_background)
                .apply(RequestOptions.bitmapTransform(new CircleCrop()))
                .into(viewHolder.timelinUsericon);
        viewHolder.txtDateTitle.setText("测试数据！！！");

    }
    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.timelin_usericon)
        ImageView timelinUsericon;
        @BindView(R.id.txt_date_time)
        TextView txtDateTime;
        @BindView(R.id.txt_date_title)
        TextView txtDateTitle;
        @BindView(R.id.rl_title)
        RelativeLayout rlTitle;
        @BindView(R.id.tvTopLine)
        TextView tvTopLine;
        @BindView(R.id.tv_bootmLine)
        TextView tv_bootmLine;
        @BindView(R.id.tvDot)
        ImageView tvDot;
        private int position;
        private TimeLineDate timeData;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
