package com.output.designpatterns.observer;

/**
 * @ClassName OrderCancelObserver
 * @Description
 * @Author ydh
 * @Date 2023/8/15 7:23 PM
 */
public interface OrderCancelObserver {
    void cancelOrderSuccess(final Order order);
}
