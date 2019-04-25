package com.txd.hzj.wujie_backkitchen.UI.Dialog;

import android.support.v4.app.FragmentActivity;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mcxtzhang.lib.AnimShopButton;
import com.mcxtzhang.lib.IOnAddDelListener;
import com.txd.hzj.code_library.BaseCode.BaseDialog;
import com.txd.hzj.code_library.BaseCode.BaseDialogFragment;
import com.txd.hzj.code_library.BaseUtils.android.ToastUtils;
import com.txd.hzj.uicode.SingleButton.SmoothCheckBox;
import com.txd.hzj.wujie_backkitchen.R;

/**
 * 创建者：Sunzeyu
 * <br>创建时间：下午 03:51 2019/4/22 022
 * <br>功能描述：
 */
public final class RecieveTaskDialog {
    public static final class Builder extends BaseDialogFragment.Builder<Builder> implements View.OnClickListener{

        private final SmoothCheckBox smoothCheckBox;
        private final AnimShopButton animShopButton;
        private final TextView tv_dialog_input_cancel;
        private final TextView tv_dialog_input_confirm;
        public Builder(FragmentActivity activity) {
            super(activity);
            setContentView(R.layout.pecievetask_layout);
            setGravity(Gravity.CENTER);
            setAnimStyle(BaseDialog.AnimStyle.BOTTOM);
            setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
            setCancelable(true);
            smoothCheckBox = findViewById(R.id.pecievetask_smoothnutton);
            animShopButton = findViewById(R.id.pecievetask_shopbutton);
            tv_dialog_input_cancel = findViewById(R.id.tv_dialog_input_cancel);
            tv_dialog_input_confirm = findViewById(R.id.tv_dialog_input_confirm);
            tv_dialog_input_cancel.setOnClickListener(this);
            tv_dialog_input_confirm.setOnClickListener(this);
            animShopButton.setOnAddDelListener(new IOnAddDelListener() {
                @Override
                public void onAddSuccess(int i) {
                    //添加成功的时候
                    animShopButton.onCountAddSuccess();
                }

                @Override
                public void onAddFailed(int i, FailType failType) {

                }

                @Override
                public void onDelSuccess(int i) {
                    if (i == 2) {
                        animShopButton.setCount(1);
                    }
                }

                @Override
                public void onDelFaild(int i, FailType failType) {

                }
            });

        }
        public Builder SetData(){
            return this;
        }
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.tv_dialog_input_cancel: {
                    dismiss();
                    break;
                }
                case R.id.tv_dialog_input_confirm: {
                    //点击确定
                    dismiss();
                    break;
                }
            }
        }
    }
}
