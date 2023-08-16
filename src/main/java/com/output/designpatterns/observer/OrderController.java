package com.output.designpatterns.observer;

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
    private final StockService stockService;
    private final AccountService accountService;
    private final SMSService smsService;

    public OrderController(final OrderService orderService, final StockService stockService,
                           final AccountService accountService, final SMSService smsService) {
        this.orderService = orderService;
        this.stockService = stockService;
        this.accountService = accountService;
        this.smsService = smsService;
    }

    @PostMapping("/cancelOrder")
    public void cancelOrder(@RequestParam("id") final Long id) {
        Order order = orderService.cancelOrder(id);
        stockService.increaseStock(order);
        accountService.increaseAmount(order);
        smsService.sendSMS(order);
    }
}
