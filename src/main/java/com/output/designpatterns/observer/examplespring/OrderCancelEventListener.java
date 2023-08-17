package com.output.designpatterns.observer.examplespring;

import com.output.designpatterns.observer.AccountService;
import com.output.designpatterns.observer.Order;
import com.output.designpatterns.observer.SMSService;
import com.output.designpatterns.observer.StockService;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @ClassName OrderCancelEventListener
 * @Description
 * @Author ydh
 * @Date 2023/8/17 11:15 AM
 */
@Component
public class OrderCancelEventListener {

    private final StockService stockService;
    private final AccountService accountService;
    private final SMSService smsService;

    public OrderCancelEventListener(final StockService stockService, final AccountService accountService,
                                    final SMSService smsService) {
        this.stockService = stockService;
        this.accountService = accountService;
        this.smsService = smsService;
    }

    @EventListener
    public void handleOrderCancelledEvent(final OrderCancelEvent orderCancelEvent) {
        Order order = (Order) orderCancelEvent.getSource();
        stockService.increaseStock(order);
        accountService.increaseAmount(order);
        smsService.sendSMS(order);
    }

}
