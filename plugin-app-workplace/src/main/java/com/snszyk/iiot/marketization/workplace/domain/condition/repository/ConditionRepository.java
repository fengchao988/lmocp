package com.snszyk.iiot.marketization.workplace.domain.condition.repository;

import com.snszyk.iiot.marketization.workplace.domain.condition.Condition;
import com.snszyk.iiot.marketization.workplace.domain.condition.model.ConditionValue;

import java.util.List;

/**
 * 条件仓库
 *
 * @author tengwang
 * @version 1.0.0
 * @date 2021/1/27 11:51 上午
 */
public interface ConditionRepository {

    /**
     * 存储条件
     *
     * @param condition
     */
    void saveCondition(Condition condition);

    /**
     * ID查询条件
     *
     * @param id
     * @return
     */
    Condition findConditionById(String id);

    /**
     * 得到条件的所有条件值
     *
     * @param id
     * @return
     */
    List<ConditionValue> getConditionValuesByConditionId(String id);

    /**
     * 通过条件编码获取条件
     *
     * @param code
     * @return
     */
    Condition findConditionByConditionCode(String code);

    /**
     * 存储条件值
     *
     * @param conditionValue
     * @param condition
     */
    void saveConditionValue(ConditionValue conditionValue, Condition condition);

    /**
     * 修改条件信息
     *
     * @param condition
     */
    void modifyCondition(Condition condition);

    /**
     * 移除条件
     *
     * @param condition
     */
    void deleteCondition(Condition condition);

    /**
     * 移除条件可选值
     *
     * @param conditionValue
     */
    void deleteConditionValue(ConditionValue conditionValue);

    /**
     * 查询条件可选值通过其ID
     *
     * @param conditionValueId
     * @return
     */
    ConditionValue findConditionValueById(String conditionValueId);

    /**
     * 修改条件可选值信息
     *
     * @param conditionValue
     * @param condition
     */
    void modifyConditionValue(ConditionValue conditionValue, Condition condition);
}
