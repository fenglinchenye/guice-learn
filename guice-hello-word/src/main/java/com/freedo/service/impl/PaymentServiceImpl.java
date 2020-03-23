package com.freedo.service.impl;

import com.freedo.service.PaymentService;
import com.google.common.cache.Cache;

public class PaymentServiceImpl implements PaymentService {

    private final Cache<String,String> cache;

    public PaymentServiceImpl(Cache<String, String> cache) {
        this.cache = cache;
    }

    @Override
    @Logged
    public void pay(long orderId, long price, Long sessionId) {
        System.out.println("pay+----------orderId:"+orderId+" price:"+price+" sessionId:"+sessionId);
    }

    public void putCache(String key,String value){
        cache.put(key, value);
    }

}
