package com.snszyk.iiot.marketization.workplace.domain.condition.model;

import com.snszyk.iiot.marketization.workplace.domain.condition.Condition;
import com.snszyk.iiot.marketization.workplace.domain.condition.repository.ConditionRepository;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.zhyd.oauth.utils.UuidUtils;
import org.jeecg.common.exception.JeecgBootException;

import java.util.List;
import java.util.Objects;

/**
 * 条件可选值
 *
 * @author tengwang
 * @version 1.0.0
 * @date 2021/1/27 11:38 上午
 */
@Data
@Slf4j
@NoArgsConstructor
public class ConditionValue {

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

    public ConditionValue(String name, String code) {
        this.value = name;
        this.code = code;
    }

    public ConditionValue(String id, String name, String code) {
        this(name, code);
        this.id = id;
    }

    /**
     * 编制定额条件值
     *
     * @param condition
     * @param conditionRepository
     */
    public void make(Condition condition, ConditionRepository conditionRepository) {
        this.id = UuidUtils.getUUID();
        this.code = condition.getCode() + "-" + this.code;
        this.checkCanBeMake(condition, conditionRepository);
        conditionRepository.saveConditionValue(this, condition);
    }

    /**
     * 检查条件值能否被创建
     *
     * @param condition
     * @param conditionRepository
     */
    private void checkCanBeMake(Condition condition, ConditionRepository conditionRepository) {
        List<ConditionValue> conditionValues = condition.getConditionValues(conditionRepository);
        if (conditionValues.contains(this)) {
            throw new JeecgBootException("条件值编码重复,请检查条件值编码");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConditionValue that = (ConditionValue) o;
        return Objects.equals(code, that.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code);
    }

    /**
     * 删除
     *
     * @param conditionRepository
     */
    public void delete(ConditionRepository conditionRepository) {
        conditionRepository.deleteConditionValue(this);
    }

    /**
     * 修改条件可选值信息
     *
     * @param condition
     * @param conditionName
     * @param conditionRepository
     */
    public void modifyInfo(Condition condition, String conditionName, ConditionRepository conditionRepository) {
        this.value = conditionName;
        conditionRepository.modifyConditionValue(this, condition);
    }
}
