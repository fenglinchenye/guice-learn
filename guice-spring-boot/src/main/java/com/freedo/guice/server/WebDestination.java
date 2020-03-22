package com.freedo.guice.server;

import com.freedo.helloworddemo.MyDestination;
import com.google.inject.servlet.RequestScoped;

@RequestScoped
public class WebDestination implements MyDestination {

    private final StringBuilder sb = new StringBuilder();

    @Override
    public void write(String s) {
        sb.append(s);
    }

    public String getResult() {
        return sb.toString();
    }
}
