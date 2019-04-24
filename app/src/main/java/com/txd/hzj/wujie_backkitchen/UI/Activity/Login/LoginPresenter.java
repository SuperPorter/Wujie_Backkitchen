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
    //登录方法
    @Override
    public void Login(String account, String password) {
        //调用Model层请求接口
        loginModel.setmAccount(account);
        loginModel.setmPassword(password);
        loginModel.setListener(new LoginOnListener() {
            @Override
            public void onSuccess(String data) {
                //请求成功回传数据
                getView().LoginSuccess(data);
            }
            @Override
            public void onFail(String msg) {
                //请求失败回传失败数据
                getView().LoginError(msg);
            }
        });
        loginModel.Login();
    }

    @Override
    public void GetImage(int type) {
        if (type == 1) {
            loginModel.setListener(new LoginOnListener() {
                @Override
                public void onSuccess(String data) {
                    getView().ShowIcon(data);
                    getView().ShowImage(data);
                }

                @Override
                public void onFail(String msg) {

                }
            });
            loginModel.GetIcon();
        }else{
            loginModel.setListener(new LoginOnListener() {
                @Override
                public void onSuccess(String data) {
                    getView().ShowIcon(data);
                    getView().ShowImage(data);
                }

                @Override
                public void onFail(String msg) {

                }
            });
            loginModel.GetImage();
        }

    }
}
