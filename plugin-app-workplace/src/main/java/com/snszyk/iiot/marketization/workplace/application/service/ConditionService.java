package com.snszyk.iiot.marketization.workplace.application.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.snszyk.iiot.marketization.workplace.application.dto.condition.ConditionMakeCommand;
import com.snszyk.iiot.marketization.workplace.application.dto.condition.ConditionModifyCommand;
import com.snszyk.iiot.marketization.workplace.application.dto.condition.ConditionSearchCommand;
import com.snszyk.iiot.marketization.workplace.domain.condition.Condition;
import com.snszyk.iiot.marketization.workplace.domain.condition.model.ConditionType;
import com.snszyk.iiot.marketization.workplace.domain.condition.repository.ConditionRepository;
import com.snszyk.iiot.marketization.workplace.domain.conditionView.ConditionPageView;
import com.snszyk.iiot.marketization.workplace.domain.conditionView.ConditionView;
import com.snszyk.iiot.marketization.workplace.domain.conditionView.repository.ConditionViewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class ConditionService {

    @Autowired
    ConditionRepository repository;
    @Autowired
    ConditionViewRepository viewRepository;

    public ConditionView getConditionByCode(String code) {
        return viewRepository.getConditionByCode(code);
    }

    public ConditionView getConditionById(String id) {
        return viewRepository.getConditionById(id);
    }

    public List<ConditionView> getConditionByIds(Set<String> ids) {
        return viewRepository.getConditionByIds(ids);
    }

    public List<ConditionView> getList(ConditionSearchCommand command) {
        return viewRepository.listConditionView(command.getCode(), command.getName(), command.getConditionType());
    }

    public IPage<ConditionPageView> getPage(ConditionSearchCommand command) {
        // 在必要的时候需要构造读模型,不一定必须构造读模型,有时候PO返回也是可以接受的(我认为的,不一定对),构造读模型.里面可以存在例如身份证脱敏,密码脱敏等逻辑
        // 这里演示一个构造读模型,但是读模型并不存在读表的,存在读表会多一个读PO,否则使用原有PO进行模型构建也可以
        return viewRepository.pageConditionPageView(command.getCode(), command.getName(), command.getConditionType(), command.getPageNo(), command.getPageSize());
    }

    public Map<String, Object> getConditionTypeMap() {
        // 在必要的时候需要构造读模型,不一定必须构造读模型,有时候PO返回也是可以接受的(我认为的,不一定对),构造读模型.里面可以存在例如身份证脱敏,密码脱敏等逻辑
        // 这里演示一个构造读模型,但是读模型并不存在读表的,存在读表会多一个读PO,否则使用原有PO进行模型构建也可以
        return ConditionType.getEnums();
    }

    @Transactional
    public void make(ConditionMakeCommand command) {
        // 这里我习惯用构造传一些必要的条件进行初始化,简而言之意思就是 没有这些必要条件,该模型就不是该模型或者意义严重不完整- 这里是举例子可以这样写
        Condition condition = command.initDomain();
        // 这里的方法就是调用领域逻辑,该逻辑就处理实际进行处理时所需参数
        condition.make(repository);
    }

    @Transactional
    public void modify(ConditionModifyCommand command) {
        Condition condition = command.initDomain();
        condition.modifyInfo(repository);
    }

    @Transactional
    public void delete(String id) {
        Condition condition = repository.findConditionById(id);
        condition.delete(repository);
    }
}
