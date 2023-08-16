package com.output.designpatterns.observer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @ClassName OrderService
 * @Description
 * @Author ydh
 * @Date 2023/8/15 5:15 PM
 */
@Slf4j
@Service
public class OrderService {

    public Order cancelOrder(final Long id) {
        log.info("取消订单成功");
        return new Order();
    }

}
