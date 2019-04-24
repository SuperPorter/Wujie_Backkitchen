package com.txd.hzj.wujie_backkitchen.MVPCode;

import com.txd.hzj.wujie_backkitchen.UI.base.UiLazyFragment;

/**
 * Mvp基类
 * @param <P>
 */
public abstract class MvpLazyFragment<P extends MvpPresenter> extends UiLazyFragment implements IMvpView {

    private P mPresenter;

    @Override
    protected void initFragment() {
        mPresenter = createPresenter();
        mPresenter.attach(this);
        mPresenter.start();
        super.initFragment();
    }

    @Override
    public void onDestroy() {
        mPresenter.detach();
        super.onDestroy();
    }

    public P getPresenter() {
        return mPresenter;
    }

    protected abstract P createPresenter();
}