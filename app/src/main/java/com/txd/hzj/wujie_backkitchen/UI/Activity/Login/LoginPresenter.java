package com.txd.hzj.wujie_backkitchen.UI.Activity.Login;

import com.txd.hzj.wujie_backkitchen.MVPCode.MvpPresenter;

import java.util.List;

/**
 * 创建者：Sunzeyu
 * <br>创建时间：上午 10:36 2019/4/23 023
 * <br>功能描述：
 */
public class LoginPresenter extends MvpPresenter<LoginContract.View> implements LoginContract.Presenter{
    private LoginModel loginModel;
    @Override
    public void start() {
        //开始处理
        loginModel = new LoginModel();
    }

    @Override
    public void Login(String account, String password) {
        loginModel.setmAccount(account);
        loginModel.setmPassword(password);
        loginModel.setListener(new LoginOnListener() {
            @Override
            public void onSuccess(List<String> data) {
                getView().LoginSuccess(data);
            }

            @Override
            public void onFail(String msg) {
                getView().LoginError(msg);
            }
        });
        loginModel.Login();
    }
}
