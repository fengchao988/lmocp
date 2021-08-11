package com.snszyk.iiot.marketization.demo.domain.position.entity;

/**
 * 岗位状态机
 *
 * @author tengwang
 * @version 1.0.0
 * @date 2021/7/13 12:19 下午
 */
public enum PositionStateMachine {
    INITIALIZTION {
        public String getDesc() {
            return "初始化";
        }
    },
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
    DELETION {
        public String getDesc() {
            return "删除";
        }
    };

    public abstract String getDesc();

    public String getName() {
        return this.name();
    }
}
