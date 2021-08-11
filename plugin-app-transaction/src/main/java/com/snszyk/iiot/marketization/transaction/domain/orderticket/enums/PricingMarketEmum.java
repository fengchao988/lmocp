package com.snszyk.iiot.marketization.transaction.domain.transticket.enums;

import org.jeecg.common.util.oConvertUtils;

/**
 * 定价市场
 */
public enum PricingMarketEmum {
    //产量市场、产品综合单价
    PRODUCTION_MARKET_PRODUCT_COMPREHENSIVE_UNIT_PRICE("PRODUCTION_MARKET_PRODUCT_COMPREHENSIVE_UNIT_PRICE"),
    //工程市场-零星工作
    ENGINEERING_MARKET_SPORADIC_WORK("ENGINEERING_MARKET_SPORADIC_WORK"),
    //生产工序单价
    WORKLOAD_MARKET_PROCESS_UNIT_PRICE("WORKLOAD_MARKET_PROCESS_UNIT_PRICE"),
    //运输市场
    TRANSPORTATION_MARKET("TRANSPORTATION_MARKET"),
    //物资市场
    MATERIAL_MARKET("MATERIAL_MARKET"),
    //租赁市场
    RENTAL_MARKET("RENTAL_MARKET"),
    //培训市场-学习培训单价
    TRAINING_MARKET("MARKET"),
    //精益管理单价
    LEAN_MANAGEMENT_PRICE("LEAN_MANAGEMENT_PRICE"),
    //包岗工资单价
    PACKAGE_SALARY_UNIT_PRICE("PACKAGE_SALARY_UNIT_PRICE"),
    //技能工资单价
    SKILL_SALARY_UNIT_PRICE("RENTAL_MARKET");

    private String value;

    PricingMarketEmum(String value) {
        this.value = value;
    }
    public String getValue() {
        return value;
    }

    public static PricingMarketEmum getByValue(Object value) {
        if (oConvertUtils.isEmpty(value)) {
            return null;
        }
        return getByValue(value.toString());
    }

    public static PricingMarketEmum getByValue(String value) {
        if (oConvertUtils.isEmpty(value)) {
            return null;
        }
        for (PricingMarketEmum val : values()) {
            if (val.getValue().toLowerCase().equals(value.toLowerCase())) {
                return val;
            }
        }
        return null;
    }
}
