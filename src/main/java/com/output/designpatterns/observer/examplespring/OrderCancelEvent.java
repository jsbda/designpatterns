package com.output.designpatterns.observer.examplespring;

import com.output.designpatterns.observer.Order;
import org.springframework.context.ApplicationEvent;

/**
 * @ClassName OrderCancelEvent
 * @Description
 * @Author ydh
 * @Date 2023/8/17 10:50 AM
 */
public class OrderCancelEvent extends ApplicationEvent {

    public OrderCancelEvent(Order order) {
        super(order);
    }

}
