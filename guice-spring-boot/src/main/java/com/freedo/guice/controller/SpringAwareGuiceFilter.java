package com.freedo.guice.controller;

import com.google.inject.servlet.GuiceFilter;

import javax.servlet.annotation.WebFilter;

/**
 * 需要将GuiceFilter 注入Spring 工厂中使用{@link org.springframework.web.context.annotation.RequestScope} 注解
 * 将Servlet 的 request 周期通知Guice
 */
@WebFilter
public class SpringAwareGuiceFilter extends GuiceFilter {
}
