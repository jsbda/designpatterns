package com.output.designpatterns.observer.examplebase;

import com.output.designpatterns.observer.AccountService;
import com.output.designpatterns.observer.Order;

/**
 * @ClassName OrderCancelAccountObserver
 * @Description
 * @Author ydh
 * @Date 2023/8/15 7:33 PM
 */
public class OrderCancelAccountObserver implements OrderCancelObserver {

    private final AccountService accountService;

    public OrderCancelAccountObserver(final AccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    public void cancelOrderSuccess(final Order order) {
        accountService.increaseAmount(order);
    }
}
