package com.output.designpatterns.observer.examplebase;

import com.output.designpatterns.observer.AccountService;
import com.output.designpatterns.observer.Order;
import com.output.designpatterns.observer.SMSService;
import com.output.designpatterns.observer.StockService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName OrderObservable
 * @Description
 * @Author ydh
 * @Date 2023/8/17 2:14 PM
 */
@Slf4j
@Service
public class OrderCancelObservable {

    private final StockService stockService;
    private final AccountService accountService;
    private final SMSService smsService;
    private final List<OrderCancelObserver> orderCancelObservers = new ArrayList<>();

    public OrderCancelObservable(final StockService stockService, final AccountService accountService,
                                 final SMSService smsService) {
        this.stockService = stockService;
        this.accountService = accountService;
        this.smsService = smsService;
        orderCancelObservers.add(new OrderCancelStockObserver(this.stockService));
        orderCancelObservers.add(new OrderCancelAccountObserver(this.accountService));
        orderCancelObservers.add(new OrderCancelSMSObserver(this.smsService));
    }

    public void cancelOrder(final Long id) {
        // 订单取消,构造一个取消后订单对象模拟取消订单，省略获取订单，修改状态并持久化等逻辑
        Order order = new Order(id, 30);
        log.info("使用观察者模式 >>> 取消订单成功");

        // 取消订单成功后，观察者继续后面的行为
        for (OrderCancelObserver orderCancelObserver : orderCancelObservers) {
            orderCancelObserver.cancelOrderSuccess(order);
        }
    }

}
