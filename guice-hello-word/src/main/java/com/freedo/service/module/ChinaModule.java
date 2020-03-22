package com.freedo.service.module;

import com.google.inject.AbstractModule;
import com.google.inject.multibindings.MapBinder;
import com.google.inject.multibindings.Multibinder;

public class ChinaModule extends AbstractModule {

    @Override
    protected void configure() {
        // 集合绑定
        // Set 绑定
        Multibinder.newSetBinder(binder(),String.class).addBinding().toInstance("CNY");

        //Map 的绑定
        MapBinder<String, String> currentMapBinder = MapBinder.newMapBinder(binder(), String.class, String.class);
        currentMapBinder.addBinding("dev").toInstance("1");
        currentMapBinder.addBinding("prod").toInstance("2");
    }
}
