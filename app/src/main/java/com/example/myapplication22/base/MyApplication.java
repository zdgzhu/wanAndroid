package com.example.myapplication22.base;

import android.app.Application;
import android.content.Context;

import com.alibaba.android.arouter.launcher.ARouter;
import com.blankj.utilcode.util.Utils;
import com.example.myapplication22.BuildConfig;
import com.example.myapplication22.di.component.ApplicationComponent;
import com.example.myapplication22.di.component.DaggerApplicationComponent;
import com.example.myapplication22.di.module.ApplicationModule;

import me.yokeyword.fragmentation.Fragmentation;

public class MyApplication extends Application {

    private ApplicationComponent mApplicationComponent;
    private static MyApplication mInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
        initApplicationComponent();
        Utils.init(this);
        initARouter();

        Fragmentation.builder()
                .stackViewMode(Fragmentation.BUBBLE)
                .debug(BuildConfig.DEBUG)
                .install();




    }


    /**
     * 初始化路由器
     */
    private void initARouter() {
        if (BuildConfig.DEBUG)   {    //下面这两行必须卸载init之前，否则这些配置在init过程中将无效
            ARouter.openLog();     //打印日志
            ARouter.openDebug();// 开启调试模式，（如果在 InstantRun 模式下运行，必须开启调试模式，线上版需要关闭，否则有安全风险）
        }
        ARouter.init(this); //尽可能的早，推荐在application中初始化
    }

    /**
     * 初始化 ApplicationComponent
     */
    private void initApplicationComponent() {
        mApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    public ApplicationComponent getApplicationComponent() {
        return mApplicationComponent;
    }

    public static Context getAppContext() {

        return mInstance.getApplicationContext();
    }

    public static MyApplication getInstance() {
        return mInstance;
    }



}
