package com.freedo.guice.greeting;

import com.freedo.MyApplet;
import com.freedo.guice.server.RequestParams;
import com.freedo.guice.server.WebDestination;
import com.google.inject.Inject;
import com.google.inject.servlet.RequestScoped;

@RequestScoped
public class GreetingHandler {

    private final RequestParams params;
    private final WebDestination webDestination;
    private final MyApplet myApplet;

    @Inject
    public GreetingHandler(RequestParams params, WebDestination webDestination, MyApplet myApplet) {
        this.params = params;
        this.webDestination = webDestination;
        this.myApplet = myApplet;
    }

    public String getByName(String name) {
        params.setGreetingName(name);
        myApplet.run();
        return webDestination.getResult();
    }



}
