package com.txd.hzj.wujie_backkitchen.UI.Adapter.ProductionAdapter;

import android.content.Context;
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
import com.txd.hzj.code_library.Utils.utils.android.DensityUtil;
import com.txd.hzj.wujie_backkitchen.Bean.TimeLineDate;
import com.txd.hzj.wujie_backkitchen.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TimeAdapter extends RecyclerView.Adapter {
    private Context activity;
    private List<TimeLineDate> data;

    public TimeAdapter(Context mainActivity, List<TimeLineDate> list) {
        this.activity = mainActivity;
        this.data = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.tiemview, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((ViewHolder) holder).setPosition(position);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.v_line)
        View vLine;
        @BindView(R.id.timelin_type)
        ImageView timelinType;
        @BindView(R.id.timelin_usericon)
        ImageView timelinUsericon;
        @BindView(R.id.txt_date_time)
        TextView txtDateTime;
        @BindView(R.id.txt_date_title)
        TextView txtDateTitle;
        @BindView(R.id.rl_title)
        RelativeLayout rlTitle;
        private int position;
        private TimeLineDate timeData;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void setPosition(int position) {
            this.position = position;
            timeData = data.get(position);
            //时间轴竖线的layoutParams,用来动态的添加竖线
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) vLine.getLayoutParams();
            //第一个下标位置的时候
            if (position == 0) {
                if (data.size() >= 2) {
                    if (!timeData.getTime().equals(data.get(position + 1).getTime())) {
                        txtDateTitle.setBackgroundResource(R.drawable.message_sys_bgfirst);
                        layoutParams.setMargins(DensityUtil.dip2px(vLine.getContext(), 20), DensityUtil.dip2px(vLine.getContext(), 15), 0, 0);
                    } else {
                        txtDateTitle.setBackgroundResource(R.drawable.message_sys_bgtop);
                        layoutParams.setMargins(DensityUtil.dip2px(vLine.getContext(), 20), DensityUtil.dip2px(vLine.getContext(), 15), 0, 0);
                    }
                } else {
                    txtDateTitle.setBackgroundResource(R.drawable.message_sys_bgfirst);
                    layoutParams.setMargins(DensityUtil.dip2px(vLine.getContext(), 20), DensityUtil.dip2px(vLine.getContext(), 15), 0, 0);
                }
                rlTitle.setVisibility(View.VISIBLE);
                txtDateTime.setText("测试使用");
                //代码设置是px
                layoutParams.addRule(RelativeLayout.ALIGN_TOP, R.id.rl_title);
                layoutParams.addRule(RelativeLayout.ALIGN_BOTTOM, R.id.txt_date_title);
            } else if (position < data.size() - 1) {
                if (timeData.getTime().equals(data.get(position - 1).getTime())) {
                    if (timeData.getTime().equals(data.get(position + 1).getTime())) {
                        rlTitle.setVisibility(View.GONE);
                        layoutParams.setMargins(DensityUtil.dip2px(vLine.getContext(), 20), DensityUtil.dip2px(vLine.getContext(), 0), 0, 0);
                        txtDateTitle.setBackgroundResource(R.drawable.message_sys_bgcenter);
                        layoutParams.addRule(RelativeLayout.ALIGN_TOP, R.id.txt_date_title);
                        layoutParams.addRule(RelativeLayout.ALIGN_BOTTOM, R.id.txt_date_title);
                    } else {
                        rlTitle.setVisibility(View.GONE);
                        txtDateTitle.setBackgroundResource(R.drawable.message_sys_bgbot);
                        layoutParams.addRule(RelativeLayout.ALIGN_TOP, R.id.txt_date_title);
                        layoutParams.addRule(RelativeLayout.ALIGN_BOTTOM, R.id.txt_date_title);
                    }

                } else {
                    if (!timeData.getTime().equals(data.get(position + 1).getTime())) {
                        txtDateTitle.setBackgroundResource(R.drawable.message_sys_bgfirst);
                    } else {
                        txtDateTitle.setBackgroundResource(R.drawable.message_sys_bgtop);
                    }
                    layoutParams.setMargins(DensityUtil.dip2px(vLine.getContext(), 20), DensityUtil.dip2px(vLine.getContext(), 0), 0, 0);
                    rlTitle.setVisibility(View.VISIBLE);
                    txtDateTime.setText(TimeFormat.format("yyyy.MM.dd", timeData.getTime()));
                    layoutParams.addRule(RelativeLayout.ALIGN_TOP, R.id.rl_title);
                    layoutParams.addRule(RelativeLayout.ALIGN_BOTTOM, R.id.txt_date_title);
                }

            } else {
                if (!timeData.getTime().equals(data.get(position - 1).getTime())) {
                    txtDateTitle.setBackgroundResource(R.drawable.message_sys_bgfirst);
                    rlTitle.setVisibility(View.VISIBLE);
                    txtDateTime.setText(TimeFormat.format("yyyy.MM.dd", timeData.getTime()));
                    layoutParams.setMargins(DensityUtil.dip2px(vLine.getContext(), 20), DensityUtil.dip2px(vLine.getContext(), 0), 0, 0);
                    layoutParams.addRule(RelativeLayout.ALIGN_TOP, R.id.rl_title);
                    layoutParams.addRule(RelativeLayout.ALIGN_BOTTOM, R.id.txt_date_title);
                } else {
                    rlTitle.setVisibility(View.GONE);
                    txtDateTitle.setBackgroundResource(R.drawable.message_sys_bgbot);
                    txtDateTime.setText(TimeFormat.format("yyyy.MM.dd", timeData.getTime()));
                    layoutParams.setMargins(DensityUtil.dip2px(vLine.getContext(), 20), DensityUtil.dip2px(vLine.getContext(), 0), 0, 0);
                    layoutParams.addRule(RelativeLayout.ALIGN_TOP, R.id.txt_date_title);
                    layoutParams.addRule(RelativeLayout.ALIGN_BOTTOM, R.id.txt_date_title);
                }
            }
            vLine.setLayoutParams(layoutParams);
//            txtDateTitle.setText(timeData.getMessage());
            //使用圆角头像
            Glide.with(activity).load(R.mipmap.ic_launcher)
                    .apply(RequestOptions.bitmapTransform(new CircleCrop()))
                    .into(timelinUsericon);
        }
    }
}
