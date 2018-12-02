package com.example.myapplication22.base;


import com.trello.rxlifecycle2.LifecycleTransformer;

public interface BaseContrat {


    interface BasePresenter<T extends BaseContrat.BaseView> {

        //贴上view
        void attachView(T view);
       // 分离 view
        void detachView();

    }




    interface BaseView{

        //显示进度中
        void showLoading();

        //隐藏进度条
        void hideLoading();

        //显示请求成功
        void showSuccess(String message);

        //失败重试
        void showFaild(String message);

        //显示当前网络不可用
        void showNoNet();

        //重试
        void onRetry();

        //绑定生命周期
        <T> LifecycleTransformer<T> bindToLife();

    }




}
