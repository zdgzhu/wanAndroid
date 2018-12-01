package com.example.myapplication22.di.component;


import android.content.Context;

import com.example.myapplication22.di.module.ApplicationModule;
import com.example.myapplication22.di.scope.ContextLife;
import com.example.myapplication22.di.scope.PerApp;

import dagger.Component;

@PerApp
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    @ContextLife("Application")
    Context getApplication();




}
