package com.example.myapplication22.di.component;


import android.app.Activity;
import android.content.Context;

import com.example.myapplication22.di.module.FragmentModule;
import com.example.myapplication22.di.scope.ContextLife;
import com.example.myapplication22.di.scope.PerFragment;
import com.example.myapplication22.ui.home.HomeFragment;

import dagger.Component;

@PerFragment
@Component(dependencies = ApplicationComponent.class,modules = FragmentModule.class)
public interface FragmentComponent {


    @ContextLife("Activity")
    Context getActivityContext();

    @ContextLife("Application")
    Context getApplicationContext();


    Activity getActivity();


    void inject(HomeFragment fragment);



}
