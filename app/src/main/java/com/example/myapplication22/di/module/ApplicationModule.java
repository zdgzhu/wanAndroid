package com.example.myapplication22.di.module;

import android.content.Context;

import com.example.myapplication22.base.MyApplication;
import com.example.myapplication22.di.scope.ContextLife;
import com.example.myapplication22.di.scope.PerApp;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {

    private MyApplication mApplication;

    public ApplicationModule(MyApplication application) {
        mApplication = application;
    }



    @Provides
    @PerApp
    @ContextLife("Application")
    public Context provideApplicationContext() {
        return mApplication.getApplicationContext();
    }


}
