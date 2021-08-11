package com.snszyk.iiot.marketization.transaction.domain.transticket.enums;

import org.jeecg.common.util.oConvertUtils;

/**
 * 定价类型
 */
public enum PricingTypeEnum {

    //综合定价
    COMPREHENSIVE_PRICING("COMPREHENSIVE_PRICING"),
    //单项定价
    INDIVIDUAL_PRICING("INDIVIDUAL_PRICING"),
    //交易时定价
    TRANSACTING_PRICING("TRANSACTING_PRICING");

    private String value;

    PricingTypeEnum(String value) {
        this.value = value;
    }
    public String getValue() {
        return value;
    }

    public static PricingTypeEnum getByValue(Object value) {
        if (oConvertUtils.isEmpty(value)) {
            return null;
        }
        return getByValue(value.toString());
    }

    public static PricingTypeEnum getByValue(String value) {
        if (oConvertUtils.isEmpty(value)) {
            return null;
        }
        for (PricingTypeEnum val : values()) {
            if (val.getValue().toLowerCase().equals(value.toLowerCase())) {
                return val;
            }
        }
        return null;
    }
}
