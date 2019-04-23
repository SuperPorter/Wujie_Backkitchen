package com.txd.hzj.wujie_backkitchen.UI.Activity.Login;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.txd.hzj.Netlibrary.RHttp;
import com.txd.hzj.Netlibrary.callback.HttpCallback;
import com.txd.hzj.Netlibrary.utils.LogUtils;
import com.txd.hzj.wujie_backkitchen.MVPCode.MvpModel;
import com.txd.hzj.wujie_backkitchen.NetApi.RHttpCallback;

import java.util.Observable;

/**
 * 创建者：Sunzeyu
 * <br>创建时间：上午 10:53 2019/4/23 023
 * <br>功能描述：登录Model层
 */
public class LoginModel extends MvpModel<LoginOnListener>{
    private String mAccount;
    private String mPassword;

    public void setmAccount(String mAccount) {
        this.mAccount = mAccount;
    }

    public void setmPassword(String mPassword) {
        this.mPassword = mPassword;
    }
    public void Login(){
        RHttp http = new RHttp.Builder()
                .get()
                .baseUrl("https://www.baidu.com/")
                .apiUrl("s?ie=UTF-8&wd=aa")
                .build();
        if ("123".equals(mAccount) && "123".equals(mPassword)) {
            getListener().onSuccess(null);
        }else{
            getListener().onFail("账号密码不正确");
        }
    }
}
