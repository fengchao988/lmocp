package com.snszyk.iiot.marketization.market.domain.marketelement.valobj;

import lombok.*;

/**
 * 市场主体标识
 *
 * @author fengc
 * @version 1.0.0
 * @date 2021年8月5日10:18:47
 */

public enum MarketSubjectType {

    PRODUCTION_LINE
    {
        public String getDesc() {
            return "生产线";
        }
    },
    DISTRICT_TEAM
    {
        public String getDesc() {
            return "区队";
        }
    },
    TEAM {
        public String getDesc() {
            return "班组";
        }
    },
    PERSONAL {
        public String getDesc() {
            return "个人";
        }
    }
    ;

    public abstract String getDesc();

    public String getName() {
        return this.name();
    }
}
