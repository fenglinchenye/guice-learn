package com.freedo.service.impl;

import com.freedo.service.module.ServerModule;
import com.google.inject.Guice;
import com.google.inject.Inject;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotEquals;

public class SessionManagerTest {

    @Inject
    private SessionManager sessionManager;

    @Before
    public void setUp(){
        Guice.createInjector(new ServerModule()).injectMembers(this);
    }

    @Test
    public void getSessionId() throws InterruptedException {
        Long sessionId = sessionManager.getSessionId();
        Thread.sleep(10000L);
        Long sessionId2 = sessionManager.getSessionId();
        assertNotEquals(sessionId,sessionId2);
    }
}
