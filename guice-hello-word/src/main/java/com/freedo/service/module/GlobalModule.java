package com.freedo.service.module;

import com.google.inject.AbstractModule;
import com.google.inject.multibindings.MapBinder;
import com.google.inject.multibindings.Multibinder;

public class GlobalModule extends AbstractModule {

    @Override
    protected void configure() {
        Multibinder<String> currencyBinder = Multibinder.newSetBinder(binder(), String.class);
        currencyBinder.addBinding().toInstance("EUR");
        currencyBinder.addBinding().toInstance("USD");

        MapBinder.newMapBinder(binder(),String.class,String.class).addBinding("uat").toInstance("3");
    }
}
