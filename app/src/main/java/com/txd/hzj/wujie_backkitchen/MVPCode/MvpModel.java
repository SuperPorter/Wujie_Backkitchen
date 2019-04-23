package com.txd.hzj.wujie_backkitchen.MVPCode;


public abstract class MvpModel<L> {

    private L mListener;

    public void setListener(L l) {
        mListener = l;
    }

    public L getListener() {
        return mListener;
    }
}