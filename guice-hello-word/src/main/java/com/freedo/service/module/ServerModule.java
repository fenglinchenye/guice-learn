package com.freedo.service.module;

import com.freedo.service.OrderService;
import com.freedo.service.PaymentService;
import com.freedo.service.PriceService;
import com.freedo.service.impl.*;
import com.google.common.cache.Cache;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.TypeLiteral;
import com.google.inject.matcher.Matchers;

import javax.inject.Named;
import java.util.List;

/**
 * 服务Module
 * @author XU
 */
public class ServerModule extends AbstractModule {

    /**
     * Module 之前的相互关系
     * 1、并列 Guice.createInjector(module1,module2...)
     *    很多时候Module 会过多。可以利用嵌套到一个大的Module中。然后统一注入
     * 2、嵌套 install(module)
     * 3、覆盖 Modules.override(module1).with(module2)
     *    overrider() with()方法 用于解决依赖冲突时，优先使用的module中的绑定关系。
     */
    @Override
    protected void configure() {
        // 安装Module
        install(new GlobalModule());
        install(new ChinaModule());

        bind(PaymentService.class).to(PaymentServiceImpl.class);
        bind(PriceService.class).to(PriceServiceImpl.class);
        bind(OrderService.class).to(OrderServiceImpl.class);
        // 使用方法toProvider() 绑定
        // bind(PriceService.class).toProvider();

        bind(new TypeLiteral<Cache<String,String>>(){})
                .to(GuiceDemoCache.class);

        LoggingInterceptor loggingInterceptor = new LoggingInterceptor();
        // 使用了成员变量注入
        requestInjection(loggingInterceptor);

        bindInterceptor(Matchers.any(), Matchers.annotatedWith(Logged.class), loggingInterceptor);
    }

    @Provides
    @SessionId
    private Long generateSessionId(){
        return System.currentTimeMillis();
    }

    /**
     * Providers 方法的注入是可以使用入参的
     * 注入的参数是依赖
     * @param priceService
     * @return
     */
    @Provides
    /**
     * 命名绑定
     */
    @Named("supportCurrencies")
    private List<String> getSupportCurrencies(PriceService priceService){
        return priceService.getSupportedCurrencies();
    }
}
