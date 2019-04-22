package com.txd.hzj.wujie_backkitchen.UI.Adapter.DestineAdapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.txd.hzj.code_library.BaseCode.BaseRecyclerViewAdapter;
import com.txd.hzj.wujie_backkitchen.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 创建者：Sunzeyu
 * <br>创建时间：下午 03:14 2019/4/22 022
 * <br>功能描述：
 */
public class BookingDetailsAdapter extends BaseRecyclerViewAdapter<String, BookingDetailsAdapter.ViewHoder> {


    public BookingDetailsAdapter(Context context) {
        super(context);
    }

    @NonNull
    @Override
    public ViewHoder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHoder(viewGroup, R.layout.bookingdetails_item_layout);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHoder viewHoder, int i) {
        //数据绑定
    }

    class ViewHoder extends BaseRecyclerViewAdapter.ViewHolder {
        ImageView imageBookDetailsIcon;
        TextView recieveTheTask;
        public ViewHoder(ViewGroup parent, int layoutId) {
            super(parent, layoutId);
            imageBookDetailsIcon = (ImageView) findViewById(R.id.image_book_details_icon);
            recieveTheTask = (TextView) findViewById(R.id.recieve_the_task);
        }
    }
}
