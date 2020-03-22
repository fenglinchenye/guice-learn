package com.freedo.printdemo;

import com.freedo.Applets;
import com.google.inject.AbstractModule;

public class PrintLineModule extends AbstractModule {

    @Override
    protected void configure() {
//        bind(MyApplet.class)
//                .annotatedWith(Names.named("printLine"))
////                .to(PrintLineApplet.class);
//        MapBinder.newMapBinder(binder(),String.class,MyApplet.class)
//                .addBinding("print")
//                .to(PrintLineApplet.class);
        Applets.register(binder()).named("print").to(PrintLineApplet.class);
    }
}

