package com.freedo.service.impl;

import javax.inject.Inject;
import java.util.Map;

public class EnviormentManager {

    private final Map<String,String> enviormentProperty;

    @Inject
    public EnviormentManager(Map<String, String> envPro) {
        this.enviormentProperty = envPro;
    }

    public Map<String,String> getEnv(){
        return enviormentProperty;
    }
}
