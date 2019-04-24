package com.txd.hzj.wujie_backkitchen.UI.Activity.Login;

import android.annotation.SuppressLint;

import com.txd.hzj.code_library.BaseUtils.android.LogUtils;
import com.txd.hzj.wujie_backkitchen.MVPCode.MvpModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import cn.finalteam.okhttpfinal.BaseHttpRequestCallback;
import cn.finalteam.okhttpfinal.HttpRequest;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


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
    @SuppressLint("CheckResult")
    public void Login(){
        HttpRequest.get("http://gank.io/api/data/%E7%A6%8F%E5%88%A9/10/1",new BaseHttpRequestCallback<String>(){
            @Override
            protected void onSuccess(String s) {
                getListener().onSuccess(s);
                LogUtils.e("请求成功"+s);
            }

            @Override
            public void onFailure(int errorCode, String msg) {
                super.onFailure(errorCode, msg);
            }
        });
    }
    public void GetImage(){
        HttpRequest.get("http://gank.io/api/data/%E7%A6%8F%E5%88%A9/10/1",new BaseHttpRequestCallback<String>(){
            @Override
            protected void onSuccess(String s) {
                try {
                    JSONObject jsonObject = new JSONObject(s);
                    JSONArray results = jsonObject.getJSONArray("results");
                    JSONObject jsonObject1 = results.getJSONObject(2);
                    String url = jsonObject1.getString("url");
                    LogUtils.v(url);
                    getListener().onSuccess(url);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int errorCode, String msg) {
                getListener().onFail(msg);
            }
        });
    }
    public void GetIcon(){
        HttpRequest.get("http://gank.io/api/data/%E7%A6%8F%E5%88%A9/10/1",new BaseHttpRequestCallback<String>(){
            @Override
            protected void onSuccess(String s) {
                try {
                    JSONObject jsonObject = new JSONObject(s);
                    JSONArray results = jsonObject.getJSONArray("results");
                    JSONObject jsonObject1 = results.getJSONObject(1);
                    String url = jsonObject1.getString("url");
                    LogUtils.v(url);
                    getListener().onSuccess(url);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            @Override
            public void onFailure(int errorCode, String msg) {
                getListener().onFail(msg);
            }
        });
    }
}
