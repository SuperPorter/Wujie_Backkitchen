package com.txd.hzj.wujie_backkitchen.UI.Activity.Login;

import com.txd.hzj.wujie_backkitchen.MVPCode.IMvpView;

import java.util.List;

import io.reactivex.Observable;

/**
 * 创建者：Sunzeyu
 * <br>创建时间：上午 10:49 2019/4/23 023
 * <br>功能描述：登录契约类
 */
public class LoginContract {
    public interface View extends IMvpView{
        void LoginError(String msg);

        void LoginSuccess(List<String> data);
    }
    public interface Presenter{
        void Login(String account, String password);
    }
}
