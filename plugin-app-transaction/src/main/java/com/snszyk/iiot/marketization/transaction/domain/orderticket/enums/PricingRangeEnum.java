package com.snszyk.iiot.marketization.transaction.domain.transticket.enums;

import org.jeecg.common.util.oConvertUtils;

/**
 * 定价范围
 */
public enum PricingRangeEnum {

    FIVE_TIER_MARKET("FIVE_TIER_MARKET"),
    FOUR_TIER_MARKET("FOUR_TIER_MARKET"),
    TERTIARY_MARKET("TERTIARY_MARKET");

    private String value;

    PricingRangeEnum(String value) {
        this.value = value;
    }
    public String getValue() {
        return value;
    }

    public static PricingRangeEnum getByValue(Object value) {
        if (oConvertUtils.isEmpty(value)) {
            return null;
        }
        return getByValue(value.toString());
    }

    public static PricingRangeEnum getByValue(String value) {
        if (oConvertUtils.isEmpty(value)) {
            return null;
        }
        for (PricingRangeEnum val : values()) {
            if (val.getValue().toLowerCase().equals(value.toLowerCase())) {
                return val;
            }
        }
        return null;
    }
}
