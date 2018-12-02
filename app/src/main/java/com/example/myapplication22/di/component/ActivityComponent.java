package com.example.myapplication22.di.component;

import android.app.Activity;
import android.content.Context;

import com.example.myapplication22.MainActivity;
import com.example.myapplication22.di.module.ActivityModule;
import com.example.myapplication22.di.scope.ContextLife;
import com.example.myapplication22.di.scope.PerActivity;

import dagger.Component;


@PerActivity
@Component(dependencies = ApplicationComponent.class,modules = ActivityModule.class)
public interface ActivityComponent {

    @ContextLife("Activity")
    Context getActivityContext();

    @ContextLife("Application")
    Context getApplicationContext();


    Activity getActivity();

//    void inject(MainActivity activity);


}
