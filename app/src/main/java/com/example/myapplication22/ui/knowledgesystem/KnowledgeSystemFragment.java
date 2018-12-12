package com.example.myapplication22.ui.knowledgesystem;

import android.view.View;

import com.example.myapplication22.R;
import com.example.myapplication22.base.BaseFragment;

public class KnowledgeSystemFragment extends BaseFragment {
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_knowledge_system;
    }

    @Override
    protected int initInjector() {
        return 0;
    }

    @Override
    protected int initView(View view) {
        return 0;
    }


    public static KnowledgeSystemFragment newInstance() {
        return new KnowledgeSystemFragment();
    }


}
