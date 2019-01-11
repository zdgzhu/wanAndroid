package com.example.myapplication22.ui.home;

import com.example.myapplication22.base.BaseContrat;
import com.example.myapplication22.base.BasePresenter;
import com.example.myapplication22.bean.Article;

import javax.inject.Inject;

public class HomePresenter extends BasePresenter<HomeContract.View> implements HomeContract.Presenter {

    private int mPage;
    private boolean mIsRefresh;

    @Inject
    public HomePresenter(){
        this.mIsRefresh = true;
    }


    @Override
    public void loadHomeBanners() {

    }

    @Override
    public void loadHomeArticles() {

    }

    @Override
    public void loadMore() {

    }

    @Override
    public void collectArticle(int position, Article.DatasBean bean) {

    }

    @Override
    public void loadHomeData() {

    }
}
