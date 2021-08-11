package com.snszyk.iiot.marketization.workplace.domain.condition;

import com.snszyk.iiot.marketization.workplace.domain.condition.model.ConditionType;
import com.snszyk.iiot.marketization.workplace.domain.condition.model.ConditionValue;
import com.snszyk.iiot.marketization.workplace.domain.condition.repository.ConditionRepository;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import me.zhyd.oauth.utils.UuidUtils;
import org.jeecg.common.exception.JeecgBootException;
import org.springframework.util.StringUtils;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.List;

/**
 * 条件
 *
 * @author tengwang
 * @version 1.0.0
 * @date 2021/1/27 11:18 上午
 */
@Getter
@Slf4j
public class Condition {

    /**
     * 唯一标识
     */
    private String id;

    /**
     * 条件名称
     */
    private String name;

    /**
     * 计量单位ID
     */
    private String measuringUnitId;

    /**
     * 条件编码
     */
    private String code;

    /**
     * 条件类型
     */
    @Enumerated(EnumType.STRING)
    private ConditionType conditionType;

    /**
     * 固定值条件-条件可选值
     */
    private List<ConditionValue> conditionValues;

    /**
     * 条件备注
     */
    private String remark;

    public Condition(String id, String name, String code, String measuringUnitId, ConditionType conditionType, String remark) {
        this(name, measuringUnitId, conditionType, remark);
        this.id = id;
        this.code = code;
    }

    public Condition(String name, String code, String measuringUnitId, ConditionType conditionType, String remark) {
        this(name, measuringUnitId, conditionType, remark);
        this.code = code;
    }

    public Condition(String name, String measuringUnitId, ConditionType conditionType, String remark) {
        this.name = name;
        this.measuringUnitId = measuringUnitId;
        this.conditionType = conditionType;
        this.remark = remark;
    }

    /**
     * 获取当前条件的所有可选值
     *
     * @param conditionRepository
     * @return
     */
    public List<ConditionValue> getConditionValues(ConditionRepository conditionRepository) {
        // 如果领域模型中存在List的实体我们应该通过get方法进行获取
        if (null == conditionValues) {
            this.conditionValues = conditionRepository.getConditionValuesByConditionId(this.id);
        }
        return this.conditionValues;
    }

    /**
     * 编制定额条件
     *
     * @param conditionRepository 条件仓库
     */
    public void make(ConditionRepository conditionRepository) {
        this.id = UuidUtils.getUUID();
        this.canBeMake(conditionRepository);
        conditionRepository.saveCondition(this);
    }

    /**
     * 校验能否进行制定
     *
     * @param conditionRepository
     */
    private void canBeMake(ConditionRepository conditionRepository) {
        // 举例
        if (StringUtils.isEmpty(this.name) || StringUtils.isEmpty(this.code)) {
            throw new JeecgBootException("条件的名称或编码不可为空");
        }
        // 校验编码不可重复
        Condition condition = conditionRepository.findConditionByConditionCode(this.code);
        if (null != condition) {
            throw new JeecgBootException("条件编码不可重复");
        }
    }

    /**
     * 维护条件的条件值
     *
     * @param conditionRepository
     */
    public void maintainConditionValues(ConditionValue conditionValue, ConditionRepository conditionRepository) {
        conditionValue.make(this, conditionRepository);
    }

    /**
     * 修改条件信息
     *
     * @param conditionRepository
     */
    public void modifyInfo(ConditionRepository conditionRepository) {
        this.canBeModifyInfo(conditionRepository);
        conditionRepository.modifyCondition(this);
    }

    /**
     * 校验能否修改信息
     *
     * @param conditionRepository
     */
    private void canBeModifyInfo(ConditionRepository conditionRepository) {
        // 当条件值为范围值,如果其下有可选值,则不允许其修改,其必须先移除可选值
        if (ConditionType.RANGE == this.conditionType && (this.getConditionValues(conditionRepository).size() != 0)) {
            throw new JeecgBootException("该条件下有可选值,请移除后再更改条件类型");
        }
    }

    /**
     * 移除该条件
     *
     * @param conditionRepository
     */
    public void delete(ConditionRepository conditionRepository) {
        // 先移除自己的所有条件可选值
        List<ConditionValue> conditionValues = this.getConditionValues(conditionRepository);
        conditionValues.forEach(conditionValue -> {
            conditionValue.delete(conditionRepository);
        });
        conditionRepository.deleteCondition(this);
    }

    /**
     * 移除该条件下的条件可选值
     *
     * @param conditionValueId
     * @param conditionRepository
     */
    public void deleteConditionValue(String conditionValueId, ConditionRepository conditionRepository) {
        ConditionValue conditionValue = conditionRepository.findConditionValueById(conditionValueId);
        if (null == conditionValue) {
            throw new JeecgBootException("请选择正确的条件值");
        }
        conditionValue.delete(conditionRepository);
    }

    public void modifyConditionValueInfo(String conditionValueId, String conditionName, ConditionRepository conditionRepository) {
        ConditionValue conditionValue = conditionRepository.findConditionValueById(conditionValueId);
        if (null == conditionValue) {
            throw new JeecgBootException("请选择正确的条件值");
        }
        conditionValue.modifyInfo(this, conditionName, conditionRepository);
    }
}
