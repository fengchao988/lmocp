package com.snszyk.iiot.marketization.workplace.domain.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 工作地点类型
 */
@Getter
@AllArgsConstructor
public enum WorkplaceType {
    ROADWAY_SHAFT("巷道/井下"),
    FACE("工作面/井下"),
    TUNNELING("掘进迎头/井下"),
    AUXILIARY_TRANSPORT_ROADWAY("辅运巷道/井下"),
    SHAFT("井下"),
    FLOOR("地面"),
    ROADWAY("巷道"),
    ;

    private String label;
}
