package com.txd.hzj.wujie_backkitchen.UI.base;

import com.gyf.barlibrary.ImmersionBar;
import com.txd.hzj.code_library.BaseCode.BaseLazyFragment;

/**
 * 创建者：Sunzeyu
 * <br>创建时间：下午 02:17 2019/4/17 017
 * <br>功能描述：
 */
public abstract class UiLazyFragment extends BaseLazyFragment{
    //沉浸式
    private ImmersionBar mImmersionBar;
    @Override
    protected void initFragment() {
        initImmersion();
        super.initFragment();
    }

    /**
     * 初始化沉浸式
     */
    protected void initImmersion() {

        // 初始化沉浸式状态栏
        if (isStatusBarEnabled()) {
            statusBarConfig().init();

            // 设置标题栏
            if (getTitleBarId() > 0) {
                ImmersionBar.setTitleBar(mActivity, findViewById(getTitleBarId()));
            }
        }
    }

    /**
     * 是否在Fragment使用沉浸式
     */
    public boolean isStatusBarEnabled() {
        return false;
    }

    /**
     * 获取状态栏沉浸的配置对象
     */
    protected ImmersionBar getStatusBarConfig() {
        return mImmersionBar;
    }

    /**
     * 初始化沉浸式
     */
    private ImmersionBar statusBarConfig() {
        //在BaseActivity里初始化
        mImmersionBar = ImmersionBar.with(this)
                .statusBarDarkFont(statusBarDarkFont())    //默认状态栏字体颜色为黑色
                .keyboardEnable(true);  //解决软键盘与底部输入框冲突问题，默认为false，还有一个重载方法，可以指定软键盘mode
        return mImmersionBar;
    }

    /**
     * 获取状态栏字体颜色
     */
    protected boolean statusBarDarkFont() {
        //返回true表示黑色字体
        return true;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mImmersionBar != null) mImmersionBar.destroy();
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser && isStatusBarEnabled() && isLazyLoad()) {
            // 重新初始化状态栏
            statusBarConfig().init();
        }
    }
}
