package com.snszyk.iiot.marketization.demo.domain.position.valobj;


/**
 * 失效状态
 *
 * @author tengwang
 * @version 1.0.0
 * @date 2021/7/14 2:01 下午
 */
public enum LoseEfficacyState {
    NORMAL {
        public String getDesc() {
            return "正常";
        }
    },
    FAILURE {
        public String getDesc() {
            return "失效";
        }
    },
    ;

    public abstract String getDesc();

    public String getName() {
        return this.name();
    }
}
