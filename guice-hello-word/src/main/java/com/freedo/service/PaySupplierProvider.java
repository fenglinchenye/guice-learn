package com.freedo.service;

import com.freedo.service.exception.NotSupportPaySupplierException;
import com.google.inject.throwingproviders.CheckedProvider;

/**
 * 异常Provider 是可以抛出异常的
 * @param <T>
 */
public interface PaySupplierProvider<T> extends CheckedProvider<T> {

    @Override
    T get() throws NotSupportPaySupplierException;

}
