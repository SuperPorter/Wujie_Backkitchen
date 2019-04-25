package com.txd.hzj.wujie_backkitchen.UI.Activity.Login;

import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.txd.hzj.wujie_backkitchen.MVPCode.MvpActivity;
import com.txd.hzj.wujie_backkitchen.R;
import com.txd.hzj.wujie_backkitchen.UI.Activity.Home.HomeActivity;

import butterknife.BindView;

/**
 * 创建者：Sunzeyu
 * <br>创建时间：上午 09:49 2019/4/17 017
 * <br>功能描述：登录界面
 */
public class Back_kitchen_Login extends MvpActivity<LoginPresenter> implements View.OnClickListener, LoginContract.View {
    @BindView(R.id.et_username_login)
    EditText etUsernameLogin;
    @BindView(R.id.et_password_login)
    EditText etPasswordLogin;
    @BindView(R.id.login_button)
    TextView loginButton;
    @BindView(R.id.login_icon)
    ImageView loginIcon;
    @BindView(R.id.login_bac_lin)
    LinearLayout loginBacLin;

    @Override
    protected int getLayoutId() {
        return R.layout.login_layout_activity;
    }

    @Override
    protected int getTitleBarId() {
        return 0;
    }

    @Override
    protected void initView() {
        loginButton.setOnClickListener(this);
    }

    @Override
    protected void initData() {
        getPresenter().GetImage(1);
        getPresenter().GetImage(2);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.login_button: {
                String user = etPasswordLogin.getText().toString();
                String pass = etUsernameLogin.getText().toString();
                //调用登录接口
                getPresenter().Login(user, pass);
                break;
            }
        }
    }

    @Override
    protected LoginPresenter createPresenter() {
        return new LoginPresenter();
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
    public void LoginError(String msg) {
        showToast(msg);
    }

    @Override
    public void LoginSuccess(String data) {
        showToast(data);
        //成功登录
        startActivity(HomeActivity.class);
    }

    //显示背景图片
    @Override
    public void ShowImage(String url) {
        Glide.with(this).load(url).into(new SimpleTarget<Drawable>() {
            @Override
            public void onResourceReady(@NonNull Drawable resource, @Nullable Transition<? super Drawable> transition) {
                loginBacLin.setBackground(resource);
            }
        });
    }

    //显示背景图标
    @Override
    public void ShowIcon(String url) {
        Glide.with(this).load(url).into(loginIcon);
    }
}
