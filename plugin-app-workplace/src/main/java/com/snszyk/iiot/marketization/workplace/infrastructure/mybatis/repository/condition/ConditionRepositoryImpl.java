package com.snszyk.iiot.marketization.workplace.infrastructure.mybatis.repository.condition;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.snszyk.iiot.marketization.workplace.domain.condition.Condition;
import com.snszyk.iiot.marketization.workplace.domain.condition.model.ConditionValue;
import com.snszyk.iiot.marketization.workplace.domain.condition.repository.ConditionRepository;
import com.snszyk.iiot.marketization.workplace.infrastructure.mybatis.mapper.ConditionMapper;
import com.snszyk.iiot.marketization.workplace.infrastructure.mybatis.mapper.ConditionValueMapper;
import com.snszyk.iiot.marketization.workplace.infrastructure.mybatis.po.ConditionPo;
import com.snszyk.iiot.marketization.workplace.infrastructure.mybatis.po.ConditionValuePo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * 定额条件仓库
 */
@Repository
class ConditionRepositoryImpl implements ConditionRepository {

    @Autowired
    ConditionMapper conditionMapper;

    @Autowired
    ConditionValueMapper conditionValueMapper;

    @Override
    public void saveCondition(Condition condition) {
        ConditionPo conditionPo = new ConditionPo(condition);
        // 我认为不会在新增时候增加定额条件值,所以存下本身就行
        conditionMapper.insert(conditionPo);
    }

    @Override
    public Condition findConditionById(String id) {
        ConditionPo conditionPo = conditionMapper.selectById(id);
        return null == conditionPo ? null : conditionPo.convertToDomain();
    }

    @Override
    public List<ConditionValue> getConditionValuesByConditionId(String conditionId) {
        QueryWrapper<ConditionValuePo> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(ConditionValuePo::getConditionId, conditionId);
        List<ConditionValuePo> conditionValuePos = conditionValueMapper.selectList(wrapper);
        List<ConditionValue> conditionValues = new ArrayList<>();
        conditionValuePos.forEach(conditionValuePo -> {
            conditionValues.add(conditionValuePo.convertToDomain());
        });
        return conditionValues;
    }

    @Override
    public Condition findConditionByConditionCode(String code) {
        QueryWrapper<ConditionPo> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(ConditionPo::getCode, code);
        ConditionPo conditionPo = conditionMapper.selectOne(wrapper);
        return null == conditionPo ? null : conditionPo.convertToDomain();
    }

    @Override
    public void saveConditionValue(ConditionValue conditionValue, Condition condition) {
        ConditionValuePo conditionValuePo = new ConditionValuePo(conditionValue, condition.getId());
        conditionValueMapper.insert(conditionValuePo);
    }

    @Override
    public void modifyCondition(Condition condition) {
        ConditionPo conditionPo = new ConditionPo(condition);
        this.conditionMapper.updateById(conditionPo);
    }

    @Override
    public void deleteCondition(Condition condition) {
        this.conditionMapper.deleteById(condition.getId());
    }

    @Override
    public void deleteConditionValue(ConditionValue conditionValue) {
        this.conditionValueMapper.deleteById(conditionValue.getId());
    }

    @Override
    public ConditionValue findConditionValueById(String conditionValueId) {
        ConditionValuePo conditionValuePo = this.conditionValueMapper.selectById(conditionValueId);
        return null != conditionValuePo ? conditionValuePo.convertToDomain() : null;
    }

    @Override
    public void modifyConditionValue(ConditionValue conditionValue, Condition condition) {
        ConditionValuePo conditionValuePo = new ConditionValuePo(conditionValue, condition.getId());
        this.conditionValueMapper.updateById(conditionValuePo);
    }
}
