package com.freedo.guice.controller;

import com.freedo.guice.persistence.SampleDao;
import com.google.inject.AbstractModule;
import com.google.inject.Inject;
import com.google.inject.Provides;
import com.google.inject.servlet.ServletModule;
import org.springframework.context.ApplicationContext;

import javax.inject.Singleton;

public class SpringAwareServletModule extends AbstractModule {

    private final ApplicationContext applicationContext;

    @Inject
    public SpringAwareServletModule(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    protected void configure() {
        // 需要知道什么时候进入request 请求，什么时候出request请求。注入 ServletModule
        install(new ServletModule());

        bind(ApplicationContext.class).toInstance(applicationContext);
    }

    @Provides
    @Singleton
    private SampleDao getSampleDao(){
        return applicationContext.getBean(SampleDao.class);
    }
}
