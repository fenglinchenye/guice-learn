package com.freedo.guice.greeting;

import com.freedo.guice.server.RequestParams;
import com.freedo.guice.persistence.SampleDao;
import com.google.inject.Provider;

import javax.inject.Inject;

public class GreetingMessageProvider implements Provider<String> {

    private final RequestParams requestParams;

    private final SampleDao sampleDao;

    @Inject
    public GreetingMessageProvider(RequestParams requestParams,SampleDao sampleDao) {
        this.requestParams = requestParams;
        this.sampleDao = sampleDao;
    }

    @Override
    public String get() {
        String name = requestParams.getGreetingName();
        String byName = sampleDao.getByName(name);
        return "hello "+byName;
    }
}
