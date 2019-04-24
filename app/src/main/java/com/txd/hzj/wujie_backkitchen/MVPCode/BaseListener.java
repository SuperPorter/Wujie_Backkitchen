package com.txd.hzj.wujie_backkitchen.MVPCode;

/**
 * 创建者：Sunzeyu
 * <br>创建时间：下午 02:28 2019/4/24 024
 * <br>功能描述：返回监听的基类，主要用来通用的逻辑返回
 */
public interface BaseListener<T> {
    //请求成功返回字段  返回一个json字符串
    void onSuccess(T data);

    void onFail(String msg);
}
