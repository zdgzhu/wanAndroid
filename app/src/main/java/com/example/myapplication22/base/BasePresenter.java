package com.example.myapplication22.base;

public class BasePresenter<T extends BaseContrat.BaseView> implements BaseContrat.BasePresenter<T> {

    protected T mView;

    @Override
    public void attachView(T view) {
        this.mView = view;
    }

    @Override
    public void detachView() {
        if (mView != null) {
            mView = null;
        }
    }



}
