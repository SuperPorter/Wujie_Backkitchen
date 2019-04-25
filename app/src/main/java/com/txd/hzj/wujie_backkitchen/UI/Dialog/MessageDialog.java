package com.txd.hzj.wujie_backkitchen.UI.Dialog;

import android.app.Dialog;
import android.support.v4.app.FragmentActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.txd.hzj.code_library.BaseCode.BaseDialog;
import com.txd.hzj.code_library.BaseCode.BaseDialogFragment;
import com.txd.hzj.code_library.BaseUtils.android.ToastUtils;
import com.txd.hzj.wujie_backkitchen.R;

/**
 * 创建者：Sunzeyu
 * <br>创建时间：下午 02:15 2019/4/25 025
 * <br>功能描述：
 */
public final class MessageDialog {
    public static final class Builder extends BaseDialogFragment.Builder<Builder> implements View.OnClickListener{
        private boolean mAutoDismiss = true; // 设置点击按钮后自动消失
        private OnListener mListener;
        private TextView title;
        private TextView message;
        private TextView tv_dialog_input_cancel;
        private TextView tv_dialog_input_confirm;
        public Builder(FragmentActivity activity) {
            super(activity);
            setContentView(R.layout.messagedialog_layout);
            setAnimStyle(BaseDialog.AnimStyle.IOS);
            setGravity(Gravity.CENTER);
            title = findViewById(R.id.tv_dialog_input_title);
            message = findViewById(R.id.message_textview);
            tv_dialog_input_cancel = findViewById(R.id.tv_dialog_input_cancel);
            tv_dialog_input_confirm = findViewById(R.id.tv_dialog_input_confirm);
            tv_dialog_input_cancel.setOnClickListener(this);
            tv_dialog_input_confirm.setOnClickListener(this);
        }
        public Builder setTitle(CharSequence text) {
            title.setText(text);
            return this;
        }
        public Builder setMseeage(CharSequence str) {
            message.setText(str);
            return this;
        }
        public Builder setListener(OnListener l) {
            mListener = l;
            return this;
        }


        @Override
        public void onClick(View view) {
            if (mAutoDismiss) {
                dismiss();
            }
            if (mListener == null) return;
            if (view == tv_dialog_input_confirm) {
                mListener.onConfirm(getDialog());
            }else if (view == tv_dialog_input_cancel) {
                mListener.onCancel(getDialog());
            }
        }
    }
    public interface OnListener {

        /**
         * 点击确定时回调
         */
        void onConfirm(Dialog dialog);

        /**
         * 点击取消时回调
         */
        void onCancel(Dialog dialog);
    }
}
