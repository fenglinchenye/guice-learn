package com.freedo.helloworddemo;

import com.google.common.collect.Lists;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;

import javax.inject.Inject;
import java.util.List;

public class CommandLineModule extends AbstractModule {

    private final String[] args;

    @Inject
    public CommandLineModule(String[] args) {
        this.args = args;
    }

    @Override
    protected void configure() {
    }

    @Provides
    @Args
    private List<String> getCommandLineArgs(){
        return Lists.newArrayList(args);
    }
}
