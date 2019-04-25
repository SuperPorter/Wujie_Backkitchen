package com.txd.hzj.wujie_backkitchen.UI.Activity.Beater;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.example.zhouwei.library.CustomPopWindow;
import com.txd.hzj.code_library.manager.FragmentManager;
import com.txd.hzj.wujie_backkitchen.MVPCode.MvpActivity;
import com.txd.hzj.wujie_backkitchen.R;
import com.txd.hzj.wujie_backkitchen.UI.Activity.Login.Back_kitchen_Login;
import com.txd.hzj.wujie_backkitchen.UI.Dialog.MessageDialog;
import com.txd.hzj.wujie_backkitchen.UI.Fragent.HomeFragment.ProductionFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 创建者：Sunzeyu
 * <br>创建时间：上午 08:30 2019/4/24 024
 * <br>功能描述：打荷工界面
 */
public class BeaterActivity extends MvpActivity<BeaterPresent> implements BeaterContract.View,View.OnClickListener{

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
    private CustomPopWindow mCustomPopWindow;

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
        titlebarBack.setOnClickListener(this);
        titlebarUsername.setOnClickListener(this);
        titlebarUsericon.setOnClickListener(this);
    }

    @Override
    protected void initData() {
        View contentView = LayoutInflater.from(this).inflate(R.layout.pop_menu,null);
        //处理popWindow 显示内容
        handleLogic(contentView);
        //创建并显示popWindow
        mCustomPopWindow = new CustomPopWindow.PopupWindowBuilder(this)
                .setView(contentView)
                .create();
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

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.titlebar_usericon:
            {
                mCustomPopWindow.showAsDropDown(titlebarUsername,0,20);
                break;
            }
            case R.id.titlebar_username:
            {
                mCustomPopWindow.showAsDropDown(titlebarUsername,0,20);
                break;
            }
            case R.id.titlebar_back:
            {
                finish();
                break;
            }
            case R.id.menu1:
            {
                //点击退出登录
                new MessageDialog.Builder(this).setListener(new MessageDialog.OnListener() {
                    @Override
                    public void onConfirm(Dialog dialog) {
                        //取消的话
                        startActivityFinish(Back_kitchen_Login.class);
                    }
                    @Override
                    public void onCancel(Dialog dialog) {
                        //确定的话
                        dialog.dismiss();
                    }
                }).setMseeage("确定要退出登录吗？").setTitle("退出登录").show();
                break;
            }
            case R.id.menu2:
            {
                // TODO: 2019/4/25 025 现在没有具体的页面显示
                startActivityFinish(Back_kitchen_Login.class);
                //点击查看更新
                break;
            }
        }
    }

    private void handleLogic(View contentView) {
        contentView.findViewById(R.id.menu1).setOnClickListener(this);
        contentView.findViewById(R.id.menu2).setOnClickListener(this);
    }
}
