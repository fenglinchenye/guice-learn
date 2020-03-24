package com.freedo.service.impl;

import com.freedo.cycle.FooPresenter;
import com.freedo.cycle.FooView;
import com.google.inject.Guice;
import org.junit.Before;

public class CycleDiTest {

    public static void main(String[] args) {
        FooView fooView = Guice.createInjector().getInstance(FooView.class);
        FooPresenter presenter = Guice.createInjector().getInstance(FooPresenter.class);

    }


}
