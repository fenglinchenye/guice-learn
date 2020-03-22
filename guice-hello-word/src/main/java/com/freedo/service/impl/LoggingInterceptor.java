package com.freedo.service.impl;

import com.google.common.base.Joiner;
import com.google.inject.Inject;
import com.google.inject.Provider;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import java.lang.reflect.Method;

public class LoggingInterceptor implements MethodInterceptor {

    @SessionId
    @Inject
    private Provider<Long> sessionIdProvider;

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        Method method = invocation.getMethod();
        System.out.println(String.format("In session %d: Calling %s#%s(%s)",
                sessionIdProvider.get(),
                method.getDeclaringClass().getName(),
                method.getName(),
                Joiner.on(",").join(invocation.getArguments())));
        return invocation.proceed();
    }
}
