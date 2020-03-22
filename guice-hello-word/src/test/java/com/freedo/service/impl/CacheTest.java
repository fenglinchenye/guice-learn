package com.freedo.service.impl;

import com.freedo.service.module.ServerModule;
import com.google.inject.Guice;
import com.google.inject.Inject;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CacheTest {

    @Inject
    private PaymentServiceImpl paymentService;
    @Inject
    private PriceServiceImpl priceService;

    @Before
    public void setUp(){
        Guice.createInjector(new ServerModule()).injectMembers(this);
    }

    @Test
    public void testCache(){
        paymentService.putCache("testKey","testValue");
        String testValue = priceService.getCachedValue("testKey");
        Assert.assertEquals("testValue",testValue);
    }
}
