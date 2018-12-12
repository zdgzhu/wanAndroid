package com.example.myapplication22.ui.my;

import android.view.View;

import com.example.myapplication22.R;
import com.example.myapplication22.base.BaseFragment;

public class MyFragment extends BaseFragment {
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_my;
    }

    @Override
    protected int initInjector() {
        return 0;
    }

    @Override
    protected int initView(View view) {
        return 0;
    }


    public static MyFragment newInstance() {
        return new MyFragment();
    }

}
