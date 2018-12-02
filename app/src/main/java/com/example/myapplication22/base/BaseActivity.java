package com.example.myapplication22.base;


import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.Toolbar;

import com.example.myapplication22.di.component.ActivityComponent;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

import javax.inject.Inject;

import butterknife.Unbinder;
import io.reactivex.annotations.Nullable;
import me.yokeyword.fragmentation.ISupportFragment;

public abstract class BaseActivity<T extends BaseContrat.BasePresenter>
        extends RxAppCompatActivity implements ISupportFragment, BaseContrat.BaseView {
    @Nullable
    @Inject
    protected T mPresenter;
    protected ActivityComponent mActivityComponent;

    protected Toolbar mToolBar;
    //当调用视图时将解除绑定的非绑定契约
    private Unbinder unbinder;

    protected abstract int getLayoutId();

    protected abstract void initInjector();

    protected abstract void initView();


    @Override
    public void onCreate( @Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    //    贴上 view
    private void attachView() {
        if (mPresenter != null) {
            mPresenter.attachView(this);
        }
    }

    //    分离view
    private void detachView() {
        if (mPresenter != null) {
            mPresenter.detachView();
        }
    }


}
