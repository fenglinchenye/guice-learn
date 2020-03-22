package com.freedo.service.impl;

import com.google.inject.Provider;

import javax.inject.Inject;

public class SessionManager {

    /**
     * 使用 Provider 注入
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
