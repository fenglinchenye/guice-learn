package com.freedo.helloworddemo;

import com.freedo.MyApplet;
import com.google.inject.Provider;

import javax.inject.Inject;

public class StringWritingApplet implements MyApplet {

    private MyDestination destination;
    private Provider<String> stringProvider;

    @Inject
    public StringWritingApplet(MyDestination destination,@Output Provider<String> provider) {
        this.destination = destination;
        this.stringProvider = provider;
    }

    private void writeString() {
        destination.write(stringProvider.get());
    }

    @Override
    public void run() {
        writeString();
    }
}
