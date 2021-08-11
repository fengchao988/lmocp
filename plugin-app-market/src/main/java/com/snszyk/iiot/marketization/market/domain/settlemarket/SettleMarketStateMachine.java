package com.snszyk.iiot.marketization.market.domain.settlemarket;


/**
 * 结算市场状态机
 *
 * @author tengwang
 * @version 1.0.0
 * @date 2021/7/26 2:01 下午
 */
public enum SettleMarketStateMachine {

    INITIAL {
        public String getDesc() {
            return "初始";
        }
    },
    NORMAL {
        public String getDesc() {
            return "正常";
        }
    },
    ;

    public abstract String getDesc();

    public String getName() {
        return this.name();
    }
}
