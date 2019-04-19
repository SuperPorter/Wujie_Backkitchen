package com.txd.hzj.code_library.View;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * 创建者：Sunzeyu
 * <br>创建时间：上午 09:05 2019/4/18 018
 * <br>功能描述：
 */
public class RecyclerViewScrollView extends RecyclerView{
    private int downx;
    private int downy;
    private int mTouchslop;
    public RecyclerViewScrollView(@NonNull Context context) {
        super(context);
    }

    public RecyclerViewScrollView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public RecyclerViewScrollView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent e) {
        int action = e.getAction();
        switch (action) {
            case MotionEvent.ACTION_DOWN:
            {
                downx = (int) e.getRawX();
                downy = (int) e.getRawY();
                break;
            }
            case MotionEvent.ACTION_MOVE:
            {
                int moveY = (int) e.getRawY();
                if (Math.abs(moveY - downy) > mTouchslop) {
                    return true;
                }
            }
        }
        return super.onInterceptTouchEvent(e);
    }
}
