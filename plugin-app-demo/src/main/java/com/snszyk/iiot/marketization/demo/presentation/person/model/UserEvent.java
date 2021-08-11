package com.snszyk.iiot.marketization.demo.presentation.person.model;

import org.springframework.context.ApplicationEvent;

/**
 * 用户更新事件
 *
 * @author zhaowang
 * @version 1.0.0
 * @since 2021/7/16 17:21 下午
 */
public class UserEvent extends ApplicationEvent {

    public UserEvent(Object source, UserModel target) {
        super(source);
        this.target = target;
    }

    /**
     * 流转后模型状态
     */
    private UserModel target;

    public UserModel getTarget() {
        return target;
    }
}
