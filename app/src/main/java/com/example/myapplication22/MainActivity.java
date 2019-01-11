package com.example.myapplication22;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.blankj.utilcode.util.ActivityUtils;
import com.blankj.utilcode.util.AppUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.blankj.utilcode.util.Utils;
import com.example.myapplication22.base.BaseActivity;
import com.example.myapplication22.di.module.ApplicationModule;
import com.example.myapplication22.ui.home.HomeFragment;
import com.example.myapplication22.ui.hotsearch.HotFragment;
import com.example.myapplication22.ui.knowledgesystem.KnowledgeSystemFragment;
import com.example.myapplication22.ui.my.MyFragment;
import com.tencent.bugly.crashreport.CrashReport;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.yokeyword.fragmentation.ISupportFragment;
import timber.log.Timber;

@Route(path = "/wanandroid/MainActivity")
public class MainActivity extends BaseActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    @BindView(R.id.navigation)
    BottomNavigationView mNavigation;
    private ISupportFragment[] mFragment = new ISupportFragment[4];
    private long mExitTime;
    private int preIndex;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }


    @Override
    protected void initInjector() {

    }

    @Override
    protected void initView() {
        mNavigation.setOnNavigationItemSelectedListener(this);
        ISupportFragment homeFragment = findFragment(HomeFragment.class);
        if (homeFragment == null) {
            mFragment[0] = HomeFragment.newInstance();
            mFragment[1] = KnowledgeSystemFragment.newInstance();
            mFragment[2] = MyFragment.newInstance();
            mFragment[3] = HotFragment.newInstance();
            //加载多个同级根Fragment,类似Wechat, QQ主页的场景
            loadMultipleRootFragment(R.id.layout_fragment,0,
                    mFragment[0],
                    mFragment[1],
                    mFragment[2],
                    mFragment[3]);

        } else {
            //这里 我们需要拿到 mFragments 的+0000000000 引用
            mFragment[0] = homeFragment;
            mFragment[1] = findFragment(KnowledgeSystemFragment.class);
            mFragment[2] = findFragment(MyFragment.class);
            mFragment[3] = findFragment(HotFragment.class);

        }


    }




    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.navigation_home:
                mToolBar.setTitle(R.string.app_name);
                showHideFragment(mFragment[0],mFragment[preIndex]);
                preIndex = 0;
                break;

            case R.id.navigation_knowledgesystem:
                mToolBar.setTitle(R.string.title_knowledgesystem);
                showHideFragment(mFragment[1],mFragment[preIndex]);
                preIndex = 1;
                break;

            case R.id.navigation_my:
                mToolBar.setTitle(R.string.title_my);
                showHideFragment(mFragment[2],mFragment[preIndex]);
                preIndex = 2;
                break;

                default:
                    break;
        }



        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menuHot) {
            mToolBar.setTitle(R.string.hot_title);
            showHideFragment(mFragment[3],mFragment[preIndex]);
            preIndex = 3;

        } else if (item.getItemId() == R.id.menuSearch) {


            ARouter.getInstance().build("/hotsearch/SearchActivity").navigation();

        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if ((System.currentTimeMillis() - mExitTime) > 2000) {
                ToastUtils.showShort(R.string.exit_system);
                mExitTime = System.currentTimeMillis();
            } else {
                System.exit(0);
            }
            return true;
        }


        return super.onKeyDown(keyCode, event);
    }
}
