package com.snszyk.iiot.marketization.workplace.infrastructure.resource.vo;

import lombok.Data;

/**
 * 条件-单查领域模型
 */
@Data
public class ConditionValueViewDto {

        /**
         * 唯一编码
         */
        private String id;

        /**
         * 条件值
         */
        private String value;

        /**
         * 条件值编码
         */
        private String code;

        /**
         * 所属条件ID
         */
        private String conditionId;

        public ConditionValueViewDto(String id, String value, String code, String conditionId) {
            this.id = id;
            this.value = value;
            this.code = code;
            this.conditionId = conditionId;
        }
}
