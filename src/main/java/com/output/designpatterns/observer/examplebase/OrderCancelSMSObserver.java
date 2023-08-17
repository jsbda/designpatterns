package com.output.designpatterns.observer.examplebase;

import com.output.designpatterns.observer.Order;
import com.output.designpatterns.observer.SMSService;

/**
 * @ClassName OrderCancelSMSObserver
 * @Description
 * @Author ydh
 * @Date 2023/8/15 7:26 PM
 */
public class OrderCancelSMSObserver implements OrderCancelObserver {

    private final SMSService smsService;

    public OrderCancelSMSObserver(final SMSService smsService) {
        this.smsService = smsService;
    }

    @Override
    public void cancelOrderSuccess(final Order order) {
        smsService.sendSMS(order);
    }
}
