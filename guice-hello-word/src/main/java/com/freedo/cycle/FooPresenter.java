package com.freedo.cycle;

import javax.inject.Inject;

public class FooPresenter {

    private final FooView fooView;

    @Inject
    public FooPresenter(FooView.Factory factory){
        fooView = factory.create(this);
    }

    public void doSomething(){
        fooView.userDidSomething();
    }

}
