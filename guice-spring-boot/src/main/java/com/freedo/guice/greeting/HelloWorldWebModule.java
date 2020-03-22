package com.freedo.guice.greeting;

import com.freedo.MyApplet;
import com.freedo.guice.server.WebDestination;
import com.freedo.helloworddemo.MyDestination;
import com.freedo.helloworddemo.Output;
import com.freedo.helloworddemo.StringWritingApplet;
import com.google.inject.AbstractModule;

public class HelloWorldWebModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(MyApplet.class).to(StringWritingApplet.class);
        bind(MyDestination.class).to(WebDestination.class);

        bind(String.class).annotatedWith(Output.class).toProvider(GreetingMessageProvider.class);
    }
}

