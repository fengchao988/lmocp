package com.snszyk.iiot.marketization.transaction.domain.transticket.enums;

import org.jeecg.common.util.oConvertUtils;

/**
 * 操作行为
 */
public enum OperationalBehaviorEnum {

    CREATE("CREATE"),
    UPDATE("UPDATE"),
    OPEN("OPEN"),
    CLOSE("CLOSE"),
    DELETE("DELETE");

    private String value;

    OperationalBehaviorEnum(String value) {
        this.value = value;
    }
    public String getValue() {
        return value;
    }

    public static OperationalBehaviorEnum getByValue(Object value) {
        if (oConvertUtils.isEmpty(value)) {
            return null;
        }
        return getByValue(value.toString());
    }

    public static OperationalBehaviorEnum getByValue(String value) {
        if (oConvertUtils.isEmpty(value)) {
            return null;
        }
        for (OperationalBehaviorEnum val : values()) {
            if (val.getValue().toLowerCase().equals(value.toLowerCase())) {
                return val;
            }
        }
        return null;
    }
}
