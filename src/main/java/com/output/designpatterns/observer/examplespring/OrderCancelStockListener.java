package com.output.designpatterns.observer.examplespring;

import com.output.designpatterns.observer.Order;
import com.output.designpatterns.observer.StockService;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @ClassName OrderCancelStockListener
 * @Description
 * @Author ydh
 * @Date 2023/8/17 5:55 PM
 */
@Component
public class OrderCancelStockListener {

    private final StockService stockService;

    public OrderCancelStockListener(final StockService stockService) {
        this.stockService = stockService;
    }

    @EventListener
    public void handleOrderCancelledEvent(final OrderCancelEvent orderCancelEvent) {
        Order order = (Order) orderCancelEvent.getSource();
        stockService.increaseStock(order);
    }

}
