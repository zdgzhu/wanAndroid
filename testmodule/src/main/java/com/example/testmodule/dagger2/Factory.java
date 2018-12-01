package com.example.testmodule.dagger2;

import android.util.Log;

import javax.inject.Inject;

public class Factory {
    String TAG = "TAG_" + getClass().getSimpleName();
    Product product;

    @Inject
    public Factory(Product product) {
        Log.d(TAG, "Factory: 构造方法");
        this.product = product;
    }


    public String getData() {

        return "我是factory  我的 product = "+product.getData();
    }


}
