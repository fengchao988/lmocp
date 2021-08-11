package com.snszyk.iiot.marketization.transaction.domain.transticket.enums;

import org.jeecg.common.util.oConvertUtils;

/**
 * 定价状态
 */
public enum PricingStatusEnum {
    OPEN("OPEN"),

    CLOSE("CLOSE");

    private String value;

    PricingStatusEnum(String value) {
        this.value = value;
    }
    public String getValue() {
        return value;
    }

    public static PricingStatusEnum getByValue(Object value) {
        if (oConvertUtils.isEmpty(value)) {
            return null;
        }
        return getByValue(value.toString());
    }

    public static PricingStatusEnum getByValue(String value) {
        if (oConvertUtils.isEmpty(value)) {
            return null;
        }
        for (PricingStatusEnum val : values()) {
            if (val.getValue().toLowerCase().equals(value.toLowerCase())) {
                return val;
            }
        }
        return null;
    }
}
