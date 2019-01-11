package com.example.myapplication22.ui.home;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.myapplication22.R;
import com.example.myapplication22.base.BaseFragment;
import com.example.myapplication22.bean.Article;
import com.example.myapplication22.bean.Banner;

import java.util.List;

import butterknife.BindView;

public class HomeFragment extends BaseFragment<HomePresenter>implements HomeContract.View ,SwipeRefreshLayout.OnRefreshListener {
    @BindView(R.id.rvHomeArticles)
    RecyclerView mRvHomeArticles;
    @BindView(R.id.swipeRefreshLayout)
    SwipeRefreshLayout mSwipeRefreshLayout;

    private com.youth.banner.Banner mBannerAds;
    private View mHomeBannerHeadView;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initInjector() {
        mFragmentComponent.inject(this);
    }

    @Override
    protected int initView(View view) {
        return 0;
    }


    @Override
    public void showLoading() {
        super.showLoading();
    }


    @Override
    public void showFaild(String errorMsg) {
        super.showFaild(errorMsg);
    }



    @Override
    public void setHomeBanners(List<Banner> banners) {

    }

    @Override
    public void collectArticleSuccess(int position, Article.DatasBean bean) {

    }

    //刷新
    @Override
    public void onRefresh() {

    }

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

}
