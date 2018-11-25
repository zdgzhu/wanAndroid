package com.example.testmodule.dagger2;

import dagger.Module;

@Module
public class MainModule {

    private  String TAG = "TAG";

    public MainModule(String str) {
        this.TAG = str;

    }



}
