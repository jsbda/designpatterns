package com.output.designpatterns.observer;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName OrderObservableController
 * @Description
 * @Author ydh
 * @Date 2023/8/15 7:40 PM
 */
@RestController
@RequestMapping("/orderObservable")
public class OrderObservableController {

    private final OrderService orderService;
    private final StockService stockService;
    private final AccountService accountService;
    private final SMSService smsService;
    private final List<OrderCancelObserver> orderCancelObservers = new ArrayList<>();

    public OrderObservableController(final OrderService orderService, final StockService stockService,
                                     final AccountService accountService, final SMSService smsService) {
        this.orderService = orderService;
        this.stockService = stockService;
        this.accountService = accountService;
        this.smsService = smsService;
        orderCancelObservers.add(new OrderCancelStockObserver(this.stockService));
        orderCancelObservers.add(new OrderCancelAccountObserver(this.accountService));
        orderCancelObservers.add(new OrderCancelSMSObserver(this.smsService));
    }

    @PostMapping("/cancelOrder")
    public void cancelOrder(@RequestParam("id") final Long id) {
        Order order = orderService.cancelOrder(id);

        for (OrderCancelObserver orderCancelObserver : orderCancelObservers) {
            orderCancelObserver.cancelOrderSuccess(order);
        }
    }

}
