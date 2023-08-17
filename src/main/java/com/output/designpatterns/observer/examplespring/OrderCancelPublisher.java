package com.output.designpatterns.observer.examplespring;

import com.output.designpatterns.observer.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

/**
 * @ClassName OrderCancelPublisher
 * @Description
 * @Author ydh
 * @Date 2023/8/17 2:35 PM
 */
@Slf4j
@Service
public class OrderCancelPublisher {

    private final ApplicationEventPublisher eventPublisher;

    public OrderCancelPublisher(final ApplicationEventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }

    public void cancelOrder(final Long id) {
        // 订单取消,构造一个取消后订单对象模拟取消订单，省略获取订单，修改状态并持久化等逻辑
        Order order = new Order(id, 30);
        log.info("使用Spring ApplicationEvent >>> 取消订单成功");

        eventPublisher.publishEvent(new OrderCancelEvent(order));
    }

}
