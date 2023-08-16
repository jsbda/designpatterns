package com.output.designpatterns.observer;

/**
 * @ClassName OrderCancelStockObserver
 * @Description
 * @Author ydh
 * @Date 2023/8/15 7:31 PM
 */
public class OrderCancelStockObserver implements OrderCancelObserver {

    private StockService stockService;

    public OrderCancelStockObserver(final StockService stockService) {
        this.stockService = stockService;
    }

    @Override
    public void cancelOrderSuccess(final Order order) {
        stockService.increaseStock(order);
    }
}
