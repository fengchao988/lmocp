package com.snszyk.iiot.marketization.demo.presentation.person.model;

import com.snszyk.iiot.marketization.demo.presentation.position.model.PositionQueryModel;
import org.springframework.context.ApplicationEvent;

public class PositionEvent extends ApplicationEvent {

    public PositionEvent(Object source, PositionQueryModel target) {
        super(source);
        this.target = target;
    }

    private PositionQueryModel target;

    public PositionQueryModel getTarget() {
        return target;
    }
}
