package com.snszyk.iiot.marketization.workplace.application.service;

import com.snszyk.iiot.marketization.workplace.application.dto.conditionValue.MakeCommand;
import com.snszyk.iiot.marketization.workplace.application.dto.conditionValue.ModifyCommand;
import com.snszyk.iiot.marketization.workplace.domain.condition.Condition;
import com.snszyk.iiot.marketization.workplace.domain.condition.repository.ConditionRepository;
import com.snszyk.iiot.marketization.workplace.domain.conditionView.ConditionValueView;
import com.snszyk.iiot.marketization.workplace.domain.conditionView.repository.ConditionViewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ConditionValueService {
    @Autowired
    ConditionRepository repository;
    @Autowired
    ConditionViewRepository viewRepository;


    public List<ConditionValueView> getConditionValueList(String conditionId) {
        // 这里写一个样例, 不需要通过读模型进行处理的
        return viewRepository.listConditionValues(conditionId);
    }

    @Transactional
    public void delete(String id, String conditionId) {
        // 这里有一个特殊的点 所有的实体的方法必须通过聚合进行调用
        Condition condition = repository.findConditionById(conditionId);
        condition.deleteConditionValue(id, repository);
    }

    @Transactional
    public void make(MakeCommand command) {
        Condition condition = repository.findConditionById(command.getConditionId());
        condition.maintainConditionValues(command.initDomain(), repository);
    }

    @Transactional
    public void modify(ModifyCommand command) {
        // 这里有一个特殊的点 所有的实体的方法必须通过聚合进行调用
        Condition condition = repository.findConditionById(command.getConditionId());
        condition.modifyConditionValueInfo(command.getId(), command.getName(), repository);
    }
}
