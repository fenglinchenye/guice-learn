package com.freedo.service.impl;

import com.freedo.service.OrderService;
import com.freedo.service.PaymentService;
import com.freedo.service.PriceService;

import javax.inject.Inject;

/**
 * @author freedo
 */
public class OrderServiceImpl implements OrderService {

    private final PriceService priceService;
    private final PaymentService paymentService;
    private final SessionManager sessionManager;

    @Inject
    public OrderServiceImpl(PriceService priceService, PaymentService paymentService, SessionManager sessionManager) {
        this.priceService = priceService;
        this.paymentService = paymentService;
        this.sessionManager = sessionManager;
    }

    private Long orderPaid = 0L;

    @Override
    @Logged
    public void sendToPayment(long orderId){
        long price = priceService.getPrice(orderId);
        paymentService.pay(orderId,price,sessionManager.getSessionId());
        orderPaid = orderPaid+1;
    }

}
