package com.output.designpatterns.observer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @ClassName AccountService
 * @Description
 * @Author ydh
 * @Date 2023/8/15 5:18 PM
 */
@Slf4j
@Service
public class AccountService {

    public void increaseAmount(final Order order) {
        log.info("账户总金额增加成功");
    }

}
