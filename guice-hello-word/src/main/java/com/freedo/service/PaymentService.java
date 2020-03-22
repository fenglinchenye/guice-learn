package com.freedo.service;

public interface PaymentService {

    void pay(long orderId, long price, Long sessionId);

}
