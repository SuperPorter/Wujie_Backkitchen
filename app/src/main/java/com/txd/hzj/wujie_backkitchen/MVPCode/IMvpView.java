package com.txd.hzj.wujie_backkitchen.MVPCode;

/**
 * V层通用接口
 */
public interface IMvpView {

    /**
     * 用于页面请求数据时显示加载状态
     */
    void ShowLoading();

    /**
     * 用于请求数据完成
     */
    void loadingComplete();

    /**
     * 用于请求的数据为空的状态
     */
    void showEmpty();

    /**
     * 用于请求数据出错
     */
    void showError();
}