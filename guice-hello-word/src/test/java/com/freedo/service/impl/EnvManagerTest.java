package com.freedo.service.impl;

import com.freedo.service.module.ServerModule;
import com.google.inject.Guice;
import org.junit.Before;
import org.junit.Test;

import javax.inject.Inject;
import java.util.Map;

public class EnvManagerTest {

    @Inject
    private EnviormentManager enviormentManager;

    @Before
    public void setUp(){
        Guice.createInjector(new ServerModule()).injectMembers(this);
    }

    @Test
    public void getEnvTest(){
        Map<String, String> envMap = enviormentManager.getEnv();
        System.out.println(envMap);
    }
}
