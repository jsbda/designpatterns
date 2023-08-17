package com.output.designpatterns.observer.examplespring;

import com.output.designpatterns.observer.AccountService;
import com.output.designpatterns.observer.Order;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @ClassName OrderCancelAccountListener
 * @Description
 * @Author ydh
 * @Date 2023/8/17 5:55 PM
 */
@Component
public class OrderCancelAccountListener {

    private final AccountService accountService;

    public OrderCancelAccountListener(final AccountService accountService) {
        this.accountService = accountService;
    }

    @EventListener
    public void handleOrderCancelledEvent(final OrderCancelEvent orderCancelEvent) {
        Order order = (Order) orderCancelEvent.getSource();
        accountService.increaseAmount(order);
    }

}
