package com.snszyk.iiot.marketization.workplace.infrastructure.resource.vo;

import java.util.HashMap;
import java.util.Map;

public enum ConditionType {
    RANGE {
        public String getDesc() {
            return "范围值";
        }
    },
    REGULAR {
        public String getDesc() {
            return "固定值";
        }
    };


    /**
     * 得到所有枚举的列表
     *
     * @return
     */
    public static Map<String, Object> getEnums() {
        Map<String, Object> map = new HashMap<>();
        for (ConditionType enumInstance : ConditionType.values()) {
            map.put(enumInstance.getName(), enumInstance.getDesc());
        }
        return map;
    }

    public abstract String getDesc();

    public String getName() {
        return this.name();
    }
}
