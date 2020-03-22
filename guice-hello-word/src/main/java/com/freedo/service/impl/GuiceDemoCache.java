package com.freedo.service.impl;

import com.google.common.cache.AbstractCache;
import org.checkerframework.checker.nullness.qual.Nullable;

import javax.inject.Singleton;
import java.util.HashMap;
import java.util.Map;

@Singleton
public class GuiceDemoCache extends AbstractCache<String,String> {

    private final Map<String,String> keyValues = new HashMap<>();

    @Nullable
    @Override
    public String getIfPresent(Object key) {
        return keyValues.get(key);
    }

    @Override
    public void put(String key, String value) {
        keyValues.put(key,value);
    }
}
