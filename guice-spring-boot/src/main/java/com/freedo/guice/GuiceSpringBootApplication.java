package com.freedo.guice;

import com.freedo.guice.controller.SpringAwareServletModule;
import com.freedo.guice.greeting.GreetingHandler;
import com.freedo.guice.greeting.HelloWorldWebModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.context.annotation.RequestScope;

@SpringBootApplication
/**
 * 针对Servlet 进行扫描注入 可以是@WebFilter
 */
@ServletComponentScan
public class GuiceSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(GuiceSpringBootApplication.class, args);
    }

    @Bean
    @RequestScope
    public GreetingHandler greetingHandler(Injector injector){
        return injector.getInstance(GreetingHandler.class);
    }

    @Bean
    @RequestScope
    public Injector injector(ApplicationContext context){
        return Guice.createInjector(new HelloWorldWebModule(), new SpringAwareServletModule(context));
    }
}
