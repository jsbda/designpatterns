package com.output.designpatterns.observer;

import java.math.BigDecimal;

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
    private Long orderId;

    /**
     * 订单状态
     */
    private Integer orderStatus;

    /**
     * 支付金额
     */
    private BigDecimal payAmount;

}
