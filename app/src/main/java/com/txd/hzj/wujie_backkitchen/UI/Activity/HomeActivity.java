package com.txd.hzj.wujie_backkitchen.UI.Activity;

import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.txd.hzj.Netlibrary.NetWorkManager;
import com.txd.hzj.code_library.manager.FragmentManager;
import com.txd.hzj.wujie_backkitchen.R;
import com.txd.hzj.wujie_backkitchen.UI.Activity.Beater.BeaterActivity;
import com.txd.hzj.wujie_backkitchen.UI.Fragent.HomeFragment.Destine_Fragment;
import com.txd.hzj.wujie_backkitchen.UI.Fragent.HomeFragment.Estimate_Fragment;
import com.txd.hzj.wujie_backkitchen.UI.Fragent.HomeFragment.ProductionFragment;
import com.txd.hzj.wujie_backkitchen.UI.base.UIActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class HomeActivity extends UIActivity {
    @BindView(R.id.hoem_main_fragment)
    FrameLayout hoemMainFragment;
    @BindView(R.id.back_button_titlebar)
    ImageView backButtonTitlebar;
    @BindView(R.id.rb_production)
    RadioButton rbProduction;
    @BindView(R.id.rb1_destine)
    RadioButton rb1Destine;
    @BindView(R.id.rb_estimate)
    RadioButton rbEstimate;
    @BindView(R.id.rg)
    RadioGroup rg;
    @BindView(R.id.common_constact)
    LinearLayout commonConstact;
    @BindView(R.id.ll_qqtop)
    RelativeLayout llQqtop;
    @BindView(R.id.titlebar_usericon)
    ImageView titlebarUsericon;
    @BindView(R.id.titlebar_username)
    TextView titlebarUsername;
    private List<Fragment> fragmentList;
    private ProductionFragment productionFragment;
    private Destine_Fragment destine_fragment;
    private Estimate_Fragment estimate_fragment;

    @Override
    protected int getLayoutId() {
        return R.layout.home_layout;
    }

    @Override
    protected int getTitleBarId() {
        return R.id.ll_qqtop;
    }

    @Override
    protected void initView() {
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.rb_production: {
                        FragmentManager.replaceFragment(getSupportFragmentManager(), productionFragment, R.id.hoem_main_fragment, true);
                        FragmentManager.showFragment(productionFragment);
                        break;
                    }
                    case R.id.rb1_destine: {
                        //预定
                        FragmentManager.replaceFragment(getSupportFragmentManager(), destine_fragment, R.id.hoem_main_fragment, true);
                        FragmentManager.showFragment(destine_fragment);

                        break;
                    }
                    case R.id.rb_estimate: {
                        //估清
                        FragmentManager.replaceFragment(getSupportFragmentManager(), estimate_fragment, R.id.hoem_main_fragment, true);
                        FragmentManager.showFragment(estimate_fragment);
                        break;
                    }
                }
            }
        });

    }
    @Override
    protected void initData() {
        //设置头像
        Glide.with(this)
                .load(R.drawable.ic_launcher_background)
                .apply(RequestOptions.bitmapTransform(new CircleCrop()))
                .into(titlebarUsericon);
        titlebarUsericon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(BeaterActivity.class);
            }
        });
        fragmentList = new ArrayList<>();
        productionFragment = new ProductionFragment();
        destine_fragment = new Destine_Fragment();
        estimate_fragment = new Estimate_Fragment();
        fragmentList.add(productionFragment);
        fragmentList.add(destine_fragment);
        fragmentList.add(estimate_fragment);
        //显示第一个Fragment
        FragmentManager.addFragments(getSupportFragmentManager(), fragmentList, R.id.hoem_main_fragment, 0);
    }
}
