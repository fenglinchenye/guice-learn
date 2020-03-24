package com.freedo.service.impl;

import com.google.inject.Provider;

import javax.inject.Inject;

public class SessionManager {

    /**
     * 使用 Provider 注入
     * Provider 注入问题：
     * 1、单纯的Provider并不能声明已检查异常,如果需要使用可以使用{@link com.google.inject.throwingproviders.CheckedProvider}
     * 2、Provider 不支持超时机制（针对IO相关需要注意）
     * 3、Provider 没有定义重试策略。当一个值不可用,多次调用get()可能会导致多个失败的规定。
     *
     */
    private final Provider<Long> sessionIdProvider;

    @Inject
    public SessionManager(@SessionId Provider<Long> sessionIdProvider) {
        this.sessionIdProvider = sessionIdProvider;
    }

    public Long getSessionId() {
        return sessionIdProvider.get();
    }
}
