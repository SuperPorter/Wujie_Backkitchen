package com.txd.hzj.wujie_backkitchen.NetApi;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * 创建者：Sunzeyu
 * <br>创建时间：上午 10:15 2019/4/24 024
 * <br>功能描述：
 */
public interface  LoginApi{
    @GET("%E7%A6%8F%E5%88%A9/10/1")
    Observable<String> getlist();
}
