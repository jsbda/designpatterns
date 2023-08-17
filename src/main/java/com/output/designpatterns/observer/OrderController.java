package com.output.designpatterns.observer;

import com.output.designpatterns.observer.examplebase.OrderCancelObservable;
import com.output.designpatterns.observer.examplespring.OrderCancelPublisher;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName OrderController
 * @Description
 * @Author ydh
 * @Date 2023/8/15 5:14 PM
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;
    private final OrderCancelObservable orderCancelObservable;
    private final OrderCancelPublisher orderCancelPublisher;

    public OrderController(final OrderService orderService, final OrderCancelObservable orderCancelObservable,
                           final OrderCancelPublisher orderCancelPublisher) {
        this.orderService = orderService;
        this.orderCancelObservable = orderCancelObservable;
        this.orderCancelPublisher = orderCancelPublisher;
    }

    /**
     * 取消订单
     *
     * @param id
     * @return void
     * @auther ydh
     * @date 2023/8/17 2:45 PM
     */
    @PostMapping("/cancelOrder")
    public void cancelOrder(@RequestParam("id") final Long id) {
        orderService.cancelOrder(id);
    }

    /**
     * 取消订单(使用观察者模式)
     *
     * @param id
     * @return void
     * @auther ydh
     * @date 2023/8/17 2:45 PM
     */
    @PostMapping("/observer/cancelOrder")
    public void cancelOrderUseObserver(@RequestParam("id") final Long id) {
        orderCancelObservable.cancelOrder(id);
    }

    /**
     * 取消订单(使用Spring ApplicationEvent)
     *
     * @param id
     * @return void
     * @auther ydh
     * @date 2023/8/17 2:46 PM
     */
    @PostMapping("/applicationEvent/cancelOrder")
    public void cancelOrderUseApplicationEvent(@RequestParam("id") final Long id) {
        orderCancelPublisher.cancelOrder(id);
    }
}
