package com.snszyk.iiot.marketization.market.domain.product.valobj;


import lombok.*;

/**
 * 定价模式
 *
 * @author tengwang
 * @version 1.0.0
 * @date 2021/7/26 2:01 下午
 */
public enum ProductPricePattern {

    SYNTHESIZE {
        public String getDesc() {
            return "综合定价";
        }
    },
    SINGLE {
        public String getDesc() {
            return "单项定价";
        }
    },
    TEMPORARY {
        public String getDesc() {
            return "交易时定价";
        }
    },
    ;

    public abstract String getDesc();

    public String getName() {
        return this.name();
    }
}
