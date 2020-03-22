package com.freedo.service;

import java.util.List;

public interface PriceService {

    /**
     * 根据订单ID获取价格
     * @param orderId
     * @return
     */
    long getPrice(long orderId);

    /**
     * 获得支持的货币
     * @return
     */
    List<String> getSupportedCurrencies();
}
