package com.output.designpatterns.observer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @ClassName SMSService
 * @Description
 * @Author ydh
 * @Date 2023/8/15 6:33 PM
 */
@Slf4j
@Service
public class SMSService {

    void sendSMS(final Order order) {
        log.info("发送短信成功");
    }

}
