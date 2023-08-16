package com.output.designpatterns.observer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @ClassName StockService
 * @Description
 * @Author ydh
 * @Date 2023/8/15 5:16 PM
 */
@Slf4j
@Service
public class StockService {

    public void increaseStock(final Order order) {
        log.info("库存增加成功");
    }

}
