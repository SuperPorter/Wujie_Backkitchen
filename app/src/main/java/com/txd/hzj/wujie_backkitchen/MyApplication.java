package com.txd.hzj.wujie_backkitchen;

import com.txd.hzj.Netlibrary.RHttp;
import com.txd.hzj.code_library.BaseCode.BaseApplication;
import com.txd.hzj.wujie_backkitchen.NetApi.Constants;

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
        RHttp.Configure.get()
                .baseUrl(Constants.API_SERVER_URL)
                .init(this);
    }
}
