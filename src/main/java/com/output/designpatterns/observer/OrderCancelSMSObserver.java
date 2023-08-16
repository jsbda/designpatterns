package com.output.designpatterns.observer;

/**
 * @ClassName OrderCancelSMSObserver
 * @Description
 * @Author ydh
 * @Date 2023/8/15 7:26 PM
 */
public class OrderCancelSMSObserver implements OrderCancelObserver {

    private SMSService smsService;

    public OrderCancelSMSObserver(final SMSService smsService) {
        this.smsService = smsService;
    }

    @Override
    public void cancelOrderSuccess(final Order order) {
        smsService.sendSMS(order);
    }
}
