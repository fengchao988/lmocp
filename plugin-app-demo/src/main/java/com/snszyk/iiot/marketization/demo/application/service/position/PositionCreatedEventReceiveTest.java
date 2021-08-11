package com.snszyk.iiot.marketization.demo.application.service.position;

import com.snszyk.iiot.marketization.demo.domain.position.event.PositionCreatedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 *
 *
 * @author tengwang
 * @version 1.0.0
 * @date 2021/7/15 11:41 上午
 */
@Component
public class PositionCreatedEventReceiveTest {

    @EventListener(value = PositionCreatedEvent.class)
    public void processAccountCreatedEvent1(PositionCreatedEvent event) {
        System.out.println("岗位创建事件接收成功" + event);
    }
}
