package com.output.designpatterns.observer;

/**
 * @ClassName Order
 * @Description
 * @Author ydh
 * @Date 2023/8/15 5:59 PM
 */
public class Order {

    /**
     * 订单Id
     */
    private final Long orderId;

    /**
     * 订单状态(0-未知，10-已创建，20-已支付，30-已取消)
     */
    private final Integer orderStatus;

    public Order(final Long orderId, final Integer orderStatus) {
        this.orderId = orderId;
        this.orderStatus = orderStatus;
    }

}
