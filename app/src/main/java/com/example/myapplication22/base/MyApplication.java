package com.example.myapplication22.base;

import android.app.Application;
import android.content.Context;
import android.support.annotation.NonNull;

import com.alibaba.android.arouter.launcher.ARouter;
import com.blankj.utilcode.util.Utils;
import com.example.myapplication22.BuildConfig;
import com.example.myapplication22.di.component.ApplicationComponent;
import com.example.myapplication22.di.component.DaggerApplicationComponent;
import com.example.myapplication22.di.module.ApplicationModule;
import com.tencent.bugly.crashreport.CrashReport;

import java.util.Timer;

import me.yokeyword.fragmentation.Fragmentation;
import me.yokeyword.fragmentation.helper.ExceptionHandler;
import timber.log.Timber;

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
                // 设置 栈视图 模式为 悬浮球模式   SHAKE: 摇一摇唤出   NONE：隐藏
                .stackViewMode(Fragmentation.BUBBLE)
                .debug(BuildConfig.DEBUG)
                // 在遇到After onSaveInstanceState时，不会抛出异常，会回调到下面的ExceptionHandler
                .handleException(new ExceptionHandler() {
                    @Override
                    public void onException(@NonNull Exception e) {
                        // 建议在该回调处上传至我们的Crash监测服务器
                        // 以Bugtags为例子: 手动把捕获到的 Exception 传到 Bugtags 后台。
                        // Bugtags.sendException(e);
                    }
                })
                .install();
        initTimber();
        CrashReport.initCrashReport(getApplicationContext(), "544dbeaab5", true);

    }


    /**
     * 初始化路由器
     */
    private void initARouter() {
        if (BuildConfig.DEBUG) {    //下面这两行必须卸载init之前，否则这些配置在init过程中将无效
            ARouter.openLog();     //打印日志
            ARouter.openDebug();// 开启调试模式，（如果在 InstantRun 模式下运行，必须开启调试模式，线上版需要关闭，否则有安全风险）
        }
        ARouter.init(this); //尽可能的早，推荐在application中初始化
    }

//  初始化 timber
    private void initTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }

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
