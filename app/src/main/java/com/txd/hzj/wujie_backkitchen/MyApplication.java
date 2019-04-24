package com.txd.hzj.wujie_backkitchen;

import com.txd.hzj.code_library.BaseCode.BaseApplication;

import cn.finalteam.okhttpfinal.OkHttpFinal;
import cn.finalteam.okhttpfinal.OkHttpFinalConfiguration;

/**
 * 创建者：Sunzeyu
 * <br>创建时间：下午 02:13 2019/4/17 017
 * <br>功能描述：
 */
public class MyApplication extends BaseApplication{
    @Override
    public void onCreate() {
        super.onCreate();
        //初始化操作
        OkHttpFinalConfiguration.Builder builder = new OkHttpFinalConfiguration.Builder();
        OkHttpFinal.getInstance().init(builder.build());
    }
}
