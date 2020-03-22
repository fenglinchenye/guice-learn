package com.freedo.helloworddemo;

import com.freedo.Applets;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;

import java.io.PrintStream;
import java.util.List;

public class HelloWorldModule extends AbstractModule {

    @Override
    protected void configure() {
        // 1、使用@Name 做命名区分
//        bind(MyApplet.class)
//                .annotatedWith(Names.named("helloworld"))
//                .to(StringWritingApplet.class);
        //2、使用Map 将多个实现进行Map存储
//        MapBinder.newMapBinder(binder(),String.class,MyApplet.class)
//                .addBinding("hello").to(StringWritingApplet.class);

        Applets.register(binder()).named("hello").to(StringWritingApplet.class);

        bind(MyDestination.class).to(PrintStreamWriter.class);
        bind(PrintStream.class).toInstance(System.out);
        // 使用注解限定注入。注解需要放入注入的位置(即：在构造方法的注入值前)
        // 表示使用@Output 注解绑定的才注入 Hello World 实例
    }

    @Provides
    @Output
    private String getOutputString(@Args List<String> args){
        return args.get(1);
    }
}
