package com.example.myapplication22.di.scope;


import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;
import javax.inject.Singleton;


@Scope
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface PerApp {


}

/**
 * 可以看到定义一个Scope注解，必须添加以下三部分：
 * @Scope ：注明是Scope
 * @Documented ：标记在文档
 * @Retention(RUNTIME) ：运行时级别
 *
 *
 * 你可能会发现，这个自定义的@Scope 和@Singleton代码完全一样，那@PerApp是不是也能具有实现单例模式的功能? 答案是肯定的
 *
 *总结起来有以下两点好处：
 *
 * 更好的管理ApplicationComponent和Module之间的关系，Component和Component之间的依赖和继承关系。如果关系不匹配，在编译期间会报错，详解第6点。
 *
 * 代码可读性，让程序猿更好的了解Module中创建的类实例的使用范围。
 * ---------------------
 *@Documented
 *当一个注解类型被@Documented元注解所描述时，那么无论在哪里使用这个注解，都会被Javadoc工具文档化，
 *Retention表示@Documented这个注解能保留到运行时；
 *@Retention
 *这个注解表示一个注解类型会被保留到什么时候
 *其中，RetentionPolicy.xxx的取值有：
 *
 * SOURCE：表示在编译时这个注解会被移除，不会包含在编译后产生的class文件中。
 * CLASS：表示这个注解会被包含在class文件中，但在运行时会被移除。
 * RUNTIME：表示这个注解会被保留到运行时，我们可以在运行时通过反射解析这个注解
 *
 *这3个生命周期分别对应于：Java源文件(.java文件) ---> .class文件 ---> 内存中的字节码。
 *
 * 那怎么来选择合适的注解生命周期呢？
 *
 * 首先要明确生命周期长度 SOURCE < CLASS < RUNTIME ，所以前者能作用的地方后者一定也能作用。
 * 1、一般如果需要在运行时去动态获取注解信息，那只能用 RUNTIME 注解；
 * 2、如果要在编译时进行一些预处理操作，比如生成一些辅助代码（如 ButterKnife），就用 CLASS注解；
 * 3、如果只是做一些检查性的操作，比如 @Override 和 @SuppressWarnings，则可选用 SOURCE 注解。
 * ---------------------
 *
 * 在自定义注解前，有一些基础知识：
 *
 * 注解类型是用@interface关键字定义的。
 * 所有的方法均没有方法体，且只允许public和abstract这两种修饰符号，默认为public。
 * 注解方法只能返回：原始数据类型，String，Class，枚举类型，注解，它们的一维数组。
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */
