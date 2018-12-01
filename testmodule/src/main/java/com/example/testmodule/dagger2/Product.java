package com.example.testmodule.dagger2;


import android.util.Log;

import javax.inject.Inject;

public class Product {
    String TAG = "TAG_" + getClass().getSimpleName();
/*
* 将我们需要注入的对象的类的构造参数使用@Inject标注，告诉dagger2它可以实例化这个类；
*
* */
    @Inject
    public Product() {
        Log.d(TAG, "Product: 构造方法 ");

    }


    public String createProduct() {

        return "我是 Product()";
    }


    public String getData() {

        return "成功获取到了数据 product.getData()";
    }


}
