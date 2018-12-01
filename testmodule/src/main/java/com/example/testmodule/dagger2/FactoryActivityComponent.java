package com.example.testmodule.dagger2;

import com.example.testmodule.MainActivity;

import dagger.Component;

//@Component(modules = MainModule.class)
@Component
public interface FactoryActivityComponent {

  /*
  * 编写Component接口使用@Component进行标注，里面的void inject()的参数表示要将依赖注入到的目标位置；
  * */
    void inject(FactoryActivity factoryActivity) ;
    void inject1(MainActivity mainActivity) ;



}
