package com.snszyk.iiot.marketization.transaction.domain.orderticket.valobj;


/**
 * 劳动班次
 *
 * @author tengwang
 * @version 1.0.0
 * @date 2021/7/26 2:01 下午
 */
public enum WorkingShift {

    MORNING {
        public String getDesc() {
            return "早班";
        }
    },
    AFTER {
        public String getDesc() {
            return "中班";
        }
    },
    NIGHT {
        public String getDesc() {
            return "晚班";
        }
    },
    ;

    public abstract String getDesc();

    public String getName() {
        return this.name();
    }
}
