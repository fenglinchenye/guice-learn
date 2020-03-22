package com.freedo.service.impl;

import com.freedo.service.PriceService;
import com.google.common.cache.Cache;
import com.google.common.collect.Lists;

import javax.inject.Inject;
import java.util.List;
import java.util.Set;

public class PriceServiceImpl implements PriceService {

    private final Set<String> supportedCurrencies;
    private final Cache<String,String> cache;

    @Inject
    public PriceServiceImpl(Set<String> supportedCurrencies,Cache<String,String> cache) {
        this.supportedCurrencies = supportedCurrencies;
        this.cache = cache;
    }

    @Override
    public long getPrice(long orderId) {
        return 456L;
    }

    @Override
    public List<String> getSupportedCurrencies() {
        return Lists.newArrayList(supportedCurrencies);
    }

    public String getCachedValue(String key){
        return cache.getIfPresent(key);
    }
}
