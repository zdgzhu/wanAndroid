package com.example.myapplication22.ui.hotsearch;

import android.view.View;

import com.example.myapplication22.R;
import com.example.myapplication22.base.BaseFragment;

public class HotFragment  extends BaseFragment {
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_hot;
    }

    @Override
    protected void initInjector() {

    }

    @Override
    protected int initView(View view) {
        return 0;
    }

    public static HotFragment newInstance() {
        return new HotFragment();
    }


}
