package com.freedo.cycle;

import com.google.inject.assistedinject.Assisted;

import javax.inject.Inject;

public class FooView {

    private final FooPresenter presenter;

    /**
     * 注解 @Assisted
     * 注释一个注入的参数或字段，其值来自工厂方法的参数。
     * 此参数的唯一名称。这与具有相同值的{@literal @Assisted}构造函数参数匹配。当参数类型不同时，名称不是必需的
     * @param presenter
     */
    @Inject
    public FooView(@Assisted FooPresenter presenter){
        this.presenter = presenter;
    }

    public void userDidSomething(){
        System.out.println("--------");
    }

    public static interface Factory {
        FooView create(FooPresenter presenter);
    }

}
