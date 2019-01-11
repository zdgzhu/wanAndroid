package com.example.myapplication22.ui.home;

import com.example.myapplication22.base.BaseContrat;
import com.example.myapplication22.bean.Article;
import com.example.myapplication22.bean.Banner;

import java.util.List;

public interface HomeContract  {

    interface View extends BaseContrat.BaseView {

        void setHomeBanners(List<Banner>banners);

        void collectArticleSuccess(int position, Article.DatasBean bean);

    }

    interface Presenter extends BaseContrat.BasePresenter<View>{

        void loadHomeBanners();

        void loadHomeArticles();

        void loadMore();

        void collectArticle(int position, Article.DatasBean bean);

        void loadHomeData();



    }







}
