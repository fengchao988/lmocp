package com.snszyk.iiot.marketization.workplace.domain.conditionView;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * 条件-单查领域模型
 *
 * @author tengwang
 * @version 1.0.0
 * @date 2021/1/27 11:18 上午
 */
@Data
@Slf4j
@NoArgsConstructor
public class ConditionValueView {

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

    public ConditionValueView(String id, String value, String code, String conditionId) {
        this.id = id;
        this.value = value;
        this.code = code;
        this.conditionId = conditionId;
    }
}
