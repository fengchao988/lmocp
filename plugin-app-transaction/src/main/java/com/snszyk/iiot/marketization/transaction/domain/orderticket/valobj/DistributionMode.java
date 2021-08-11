package com.snszyk.iiot.marketization.transaction.domain.orderticket.valobj;


/**
 * 劳动班次
 *
 * @author tengwang
 * @version 1.0.0
 * @date 2021/7/26 2:01 下午
 */
public enum DistributionMode {

    FAST {
        public String getDesc() {
            return "快速分配";
        }
    },
    NORMAL {
        public String getDesc() {
            return "普通分配";
        }
    },
    ;

    public abstract String getDesc();

    public String getName() {
        return this.name();
    }
}
