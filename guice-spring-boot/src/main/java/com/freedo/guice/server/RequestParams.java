package com.freedo.guice.server;

import com.google.inject.servlet.RequestScoped;
import lombok.Data;

@Data
@RequestScoped
public class RequestParams {

    private String greetingName;

}
