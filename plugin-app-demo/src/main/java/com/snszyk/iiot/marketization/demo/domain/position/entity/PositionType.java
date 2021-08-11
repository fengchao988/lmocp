package com.snszyk.iiot.marketization.demo.domain.position.entity;

/**
 * 岗位类型
 *
 * @author tengwang
 * @version 1.0.0
 * @date 2021/7/13 12:19 下午
 */
public enum PositionType  {
    DIRECT {
        public String getDesc () {
            return "创建中";
        }
    },
    INDIRECT {

        public String getDesc () {
            return "创建完成";
        }
    },
    ASSIST {

        public String getDesc () {
            return "创建中";
        }
    };

    public abstract String getDesc();

    public String getName() {
        return this.name();
    }
}
