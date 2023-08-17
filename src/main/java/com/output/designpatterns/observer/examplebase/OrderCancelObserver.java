package com.output.designpatterns.observer.examplebase;

import com.output.designpatterns.observer.Order;

/**
 * @ClassName OrderCancelObserver
 * @Description
 * @Author ydh
 * @Date 2023/8/15 7:23 PM
 */
public interface OrderCancelObserver {
    void cancelOrderSuccess(final Order order);
}
