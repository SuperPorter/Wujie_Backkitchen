package com.txd.hzj.wujie_backkitchen.UI.Activity.Beater;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.txd.hzj.code_library.manager.FragmentManager;
import com.txd.hzj.wujie_backkitchen.MVPCode.MvpActivity;
import com.txd.hzj.wujie_backkitchen.R;
import com.txd.hzj.wujie_backkitchen.UI.Fragent.HomeFragment.ProductionFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 创建者：Sunzeyu
 * <br>创建时间：上午 08:30 2019/4/24 024
 * <br>功能描述：打荷工界面
 */
public class BeaterActivity extends MvpActivity<BeaterPresent> implements BeaterContract.View{

    @BindView(R.id.titlebar_back)
    ImageView titlebarBack;
    @BindView(R.id.tv_title_toolbar)
    TextView tvTitleToolbar;
    @BindView(R.id.titlebar_usericon)
    ImageView titlebarUsericon;
    @BindView(R.id.titlebar_username)
    TextView titlebarUsername;
    @BindView(R.id.titlebar)
    RelativeLayout titlebar;
    @BindView(R.id.beater_fram)
    FrameLayout beaterFram;
    private ProductionFragment productionFragment;
    @Override
    protected BeaterPresent createPresenter() {
        return new BeaterPresent();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.beater_layout;
    }

    @Override
    protected int getTitleBarId() {
        return R.id.titlebar;
    }

    @Override
    protected void initView() {
        titlebarBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    protected void initData() {
        titlebarUsername.setText("厨师王大厨");
        tvTitleToolbar.setText("");
        Glide.with(this)
                .load(R.drawable.ic_launcher_background)
                .apply(RequestOptions.bitmapTransform(new CircleCrop()))
                .into(titlebarUsericon);
        productionFragment = new ProductionFragment();
        FragmentManager.addFragment(getSupportFragmentManager(), productionFragment, R.id.beater_fram,false,true);
    }

    @Override
    public void ShowLoading() {

    }

    @Override
    public void loadingComplete() {

    }

    @Override
    public void showEmpty() {

    }

    @Override
    public void showError() {

    }
}
