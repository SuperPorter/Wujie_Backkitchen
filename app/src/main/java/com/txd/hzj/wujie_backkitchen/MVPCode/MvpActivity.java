package com.txd.hzj.wujie_backkitchen.MVPCode;

import com.txd.hzj.wujie_backkitchen.UI.base.UIActivity;

public abstract class MvpActivity<P extends MvpPresenter> extends UIActivity implements IMvpView {

    private P mPresenter;

    @Override
    public void initActivity() {
        mPresenter = createPresenter();
        mPresenter.attach(this);
        mPresenter.start();
        super.initActivity();
    }

    @Override
    protected void onDestroy() {
        mPresenter.detach();
        super.onDestroy();
    }

    public P getPresenter() {
        return mPresenter;
    }

    protected abstract P createPresenter();
}