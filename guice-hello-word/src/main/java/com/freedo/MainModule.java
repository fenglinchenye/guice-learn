package com.freedo;

import com.freedo.helloworddemo.HelloWorldModule;
import com.freedo.printdemo.PrintLineModule;
import com.google.inject.AbstractModule;

public class MainModule extends AbstractModule {

    @Override
    protected void configure() {
        install(new HelloWorldModule());
        install(new PrintLineModule());
    }
}
