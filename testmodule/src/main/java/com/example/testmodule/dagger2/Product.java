package com.example.testmodule.dagger2;


import javax.inject.Inject;

public class Product {
/*
* 将我们需要注入的对象的类的构造参数使用@Inject标注，告诉dagger2它可以实例化这个类；
*
* */
    @Inject
    public Product() {
    }


    public String createProduct() {

        return "成功";
    }





}
