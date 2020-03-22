package com.freedo.service.impl;

import com.freedo.service.OrderService;
import com.freedo.service.PriceService;
import com.freedo.service.module.ServerModule;
import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Module;
import com.google.inject.Provider;
import com.google.inject.util.Modules;
import org.junit.Before;
import org.junit.Test;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;
import java.util.Set;

class PriceServiceMock extends PriceServiceImpl{

    @Inject
    public PriceServiceMock(Set<String> supportedCurrencies) {
        super(supportedCurrencies,null);
    }

    @Override
    public long getPrice(long orderId) {
        return 567L;
    }
}


public class OrderServiceTest {

    @Inject
    private OrderService orderService;
    @Inject
    @Named("supportCurrencies")
    private Provider<List<String>> supportCurrenciesProvider;

    @Before
    public void setUp(){
        Guice.createInjector(Modules
                .override(new ServerModule())
                .with(new AbstractModule() {
                    @Override
                    protected void configure() {
                        bind(PriceService.class).to(PriceServiceMock.class);
                    }
                })).injectMembers(this);
    }

    @Test
    public void testSendToPayment(){
        orderService.sendToPayment(256L);
    }

    @Test
    public void testSupportedCurrencies(){
        throw new RuntimeException(supportCurrenciesProvider.get().toString());
    }
}
