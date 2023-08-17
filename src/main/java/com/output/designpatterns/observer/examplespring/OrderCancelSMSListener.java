package com.output.designpatterns.observer.examplespring;

import com.output.designpatterns.observer.Order;
import com.output.designpatterns.observer.SMSService;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @ClassName OrderCancelSMSListener
 * @Description
 * @Author ydh
 * @Date 2023/8/17 5:55 PM
 */
@Component
public class OrderCancelSMSListener {

    private final SMSService smsService;

    public OrderCancelSMSListener(final SMSService smsService) {
        this.smsService = smsService;
    }

    @EventListener
    public void handleOrderCancelledEvent(final OrderCancelEvent orderCancelEvent) {
        Order order = (Order) orderCancelEvent.getSource();
        smsService.sendSMS(order);
    }

}
