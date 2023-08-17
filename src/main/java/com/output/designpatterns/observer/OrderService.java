package com.output.designpatterns.observer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @ClassName OrderService
 * @Description
 * @Author ydh
 * @Date 2023/8/15 5:15 PM
 */
@Slf4j
@Service
public class OrderService {

    private final StockService stockService;
    private final AccountService accountService;
    private final SMSService smsService;

    public OrderService(final StockService stockService, final AccountService accountService,
                        final SMSService smsService) {
        this.stockService = stockService;
        this.accountService = accountService;
        this.smsService = smsService;
    }

    public void cancelOrder(final Long id) {
        // 订单取消,构造一个取消后订单对象模拟取消订单，省略获取订单，修改状态并持久化等逻辑
        Order order = new Order(id, 30);
        log.info("取消订单成功");

        // 库存增加
        stockService.increaseStock(order);
        // 账户总金额增
        accountService.increaseAmount(order);
        // 发送短信
        smsService.sendSMS(order);
    }

}
