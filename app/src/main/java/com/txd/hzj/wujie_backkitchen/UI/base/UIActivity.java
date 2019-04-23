package com.txd.hzj.wujie_backkitchen.UI.base;

import android.os.Bundle;
import android.view.WindowManager;

import com.gyf.barlibrary.ImmersionBar;
import com.txd.hzj.code_library.BaseCode.BaseActivity;
import com.txd.hzj.code_library.BaseUtils.android.ToastUtils;

/**
 *    支持沉浸式和侧滑的Activity基类（默认开启沉浸式状态栏和侧滑功能）
 */
public abstract class UIActivity extends BaseActivity {
    private ImmersionBar mImmersionBar;//状态栏沉浸
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // 在 super.onCreate(savedInstanceState) 之前调用该方法
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initLayout() {
        super.initLayout();
        initImmersion();
    }

    /**
     * 初始化沉浸式
     */
    protected void initImmersion() {
        //初始化沉浸式状态栏
        if (isStatusBarEnabled()) {
            statusBarConfig().init();
            //设置标题栏
            if (getTitleBarId() > 0) {
                ImmersionBar.setTitleBar(this, findViewById(getTitleBarId()));
            }
        }
    }
    /**
     * 是否使用沉浸式状态栏
     */
    public boolean isStatusBarEnabled() {
        return true;
    }

    /**
     * 获取状态栏沉浸的配置对象
     */
    public ImmersionBar getStatusBarConfig() {
        return mImmersionBar;
    }

    /**
     * 初始化沉浸式状态栏
     */
    private ImmersionBar statusBarConfig() {
        //在BaseActivity里初始化
        mImmersionBar = ImmersionBar.with(this)
                .statusBarDarkFont(statusBarDarkFont())    //默认状态栏字体颜色为黑色
                .keyboardEnable(false, WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN
                        | WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);  //解决软键盘与底部输入框冲突问题，默认为false，还有一个重载方法，可以指定软键盘mode
        return mImmersionBar;
    }

    /**
     * 获取状态栏字体颜色
     */
    public boolean statusBarDarkFont() {
        //返回false表示白色字体
        return true;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mImmersionBar != null) mImmersionBar.destroy();
    }

    public void showToast(String msg) {
        ToastUtils.showToast(msg);
    }

}