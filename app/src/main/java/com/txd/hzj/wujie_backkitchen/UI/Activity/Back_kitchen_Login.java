package com.txd.hzj.wujie_backkitchen.UI.Activity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.txd.hzj.wujie_backkitchen.R;
import com.txd.hzj.wujie_backkitchen.UI.base.UIActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 创建者：Sunzeyu
 * <br>创建时间：上午 09:49 2019/4/17 017
 * <br>功能描述：登录界面
 */
public class Back_kitchen_Login extends UIActivity implements View.OnClickListener{
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
                startActivity(HomeActivity.class);
                break;
            }
        }
    }
}
