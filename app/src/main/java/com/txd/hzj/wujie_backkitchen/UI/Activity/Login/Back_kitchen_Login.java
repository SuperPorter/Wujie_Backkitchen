package com.txd.hzj.wujie_backkitchen.UI.Activity.Login;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.txd.hzj.code_library.BaseUtils.android.ToastUtils;
import com.txd.hzj.wujie_backkitchen.MVPCode.MvpActivity;
import com.txd.hzj.wujie_backkitchen.R;
import com.txd.hzj.wujie_backkitchen.UI.Activity.HomeActivity;

import java.util.List;

import butterknife.BindView;

/**
 * 创建者：Sunzeyu
 * <br>创建时间：上午 09:49 2019/4/17 017
 * <br>功能描述：登录界面
 */
public class Back_kitchen_Login extends MvpActivity<LoginPresenter> implements View.OnClickListener,LoginContract.View{
    @BindView(R.id.et_username_login)
    EditText etUsernameLogin;
    @BindView(R.id.et_password_login)
    EditText etPasswordLogin;
    @BindView(R.id.login_button)
    TextView loginButton;

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

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.login_button:
            {
                String user = etPasswordLogin.getText().toString();
                String pass = etUsernameLogin.getText().toString();
                getPresenter().Login(user,pass);
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
    public void LoginSuccess(List<String> data) {
        //成功登录
        startActivity(HomeActivity.class);
    }
}
