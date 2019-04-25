package com.txd.hzj.wujie_backkitchen.UI.Dialog;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import com.txd.hzj.code_library.BaseCode.BaseDialog;
import com.txd.hzj.code_library.BaseCode.BaseDialogFragment;
import com.txd.hzj.code_library.BaseCode.BaseRecyclerViewAdapter;
import com.txd.hzj.code_library.BaseUtils.android.LogUtils;
import com.txd.hzj.code_library.BaseUtils.android.ToastUtils;
import com.txd.hzj.wujie_backkitchen.R;

import org.angmarch.views.NiceSpinner;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 创建者：Sunzeyu
 * <br>创建时间：上午 10:36 2019/4/22 022
 * <br>功能描述：领料设置Dialig
 */
public final class PickingSettingsDialog {

    private static StringBuffer stringBuffer;

    public static final class Builder extends BaseDialogFragment.Builder<Builder> implements View.OnClickListener {
        private final RecyclerView recyclerView;
        private final PickingSettingsAdapter adapter;
        private List<String> datalist;
        private final TextView tv_dialog_input_cancel;
        private final TextView tv_dialog_input_confirm;

        public Builder(FragmentActivity activity) {
            super(activity);
            setContentView(R.layout.pick_setting_layout);
            setGravity(Gravity.CENTER);
            setAnimStyle(BaseDialog.AnimStyle.BOTTOM);
            setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
            setCancelable(true);
            recyclerView = findViewById(R.id.pick_setting_rv);
            tv_dialog_input_cancel = findViewById(R.id.tv_dialog_input_cancel);
            tv_dialog_input_confirm = findViewById(R.id.tv_dialog_input_confirm);
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            adapter = new PickingSettingsAdapter(getContext());
            tv_dialog_input_cancel.setOnClickListener(this);
            tv_dialog_input_confirm.setOnClickListener(this);
        }

        public Builder setData(List<String> datalist) {
            this.datalist = datalist;
            adapter.setData(datalist);
            recyclerView.setAdapter(adapter);
            return this;
        }

        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.tv_dialog_input_cancel: {
                    //点击确定

                    dismiss();
                    break;
                }
                case R.id.tv_dialog_input_confirm: {
                    ToastUtils.showToast(stringBuffer.toString());
                    dismiss();
                    break;
                }
            }
        }

    }

    //适配器对象
    private static final class PickingSettingsAdapter extends BaseRecyclerViewAdapter<String, PickingSettingsAdapter.ViewHoder> {
        public PickingSettingsAdapter(Context context) {
            super(context);
        }

        @NonNull
        @Override
        public ViewHoder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            return new ViewHoder(viewGroup, R.layout.picksetting_rv_adapter_layout);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHoder viewHoder, int i) {
            stringBuffer = new StringBuffer();
            final String s = getData().get(i);
            viewHoder.niceSpinner.attachDataSource(getData());
            viewHoder.niceSpinner2.attachDataSource(getData());
            viewHoder.pickingRvAdapterTvname.setText(s);
            viewHoder.niceSpinner2.setBackgroundResource(R.drawable.spinner_bg);
            viewHoder.niceSpinner.setBackgroundResource(R.drawable.spinner_bg);
            viewHoder.niceSpinner.addOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    stringBuffer.append("你点击了").append(getData().get(i+1));
                }
            });
            viewHoder.niceSpinner2.addOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    stringBuffer.append(getData().get(i+1));
                }
            });
        }

        final class ViewHoder extends BaseRecyclerViewAdapter.ViewHolder {
            private TextView pickingRvAdapterTvname;
            private NiceSpinner niceSpinner;
            private NiceSpinner niceSpinner2;
            public ViewHoder(ViewGroup parent, int layoutId) {
                super(parent, layoutId);
                pickingRvAdapterTvname = (TextView) findViewById(R.id.picking_rv_adapter_tvname);
                niceSpinner = (NiceSpinner) findViewById(R.id.nice_spinner);
                niceSpinner2 = (NiceSpinner) findViewById(R.id.nice_spinner2);
            }
        }
    }
}
