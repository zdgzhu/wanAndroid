package com.example.myapplication22.ui.home;

import android.view.View;

import com.example.myapplication22.R;
import com.example.myapplication22.base.BaseFragment;

public class HomeFragment extends BaseFragment {
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    protected int initInjector() {
        return 0;
    }

    @Override
    protected int initView(View view) {
        return 0;
    }

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

}
