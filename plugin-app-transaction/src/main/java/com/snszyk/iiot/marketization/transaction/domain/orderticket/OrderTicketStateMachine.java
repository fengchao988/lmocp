package com.snszyk.iiot.marketization.transaction.domain.orderticket;


/**
 * 交易订单状态机
 *
 * @author tengwang
 * @version 1.0.0
 * @date 2021/7/26 2:01 下午
 */
public enum OrderTicketStateMachine {

    INITIAL {
        public String getDesc() {
            return "初始";
        }
    },
    CREATED {
        public String getDesc() {
            return "已创建";
        }
    },
    ;

    public abstract String getDesc();

    public String getName() {
        return this.name();
    }
}
