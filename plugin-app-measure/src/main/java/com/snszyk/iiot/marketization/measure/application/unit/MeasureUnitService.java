package com.snszyk.iiot.marketization.measure.application.unit;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.snszyk.iiot.marketization.measure.application.unit.dto.MeasureUnitCreateCommand;
import com.snszyk.iiot.marketization.measure.application.unit.dto.MeasureUnitEditCommand;
import com.snszyk.iiot.marketization.measure.application.unit.dto.MeasureUnitPageSearchCommand;
import com.snszyk.iiot.marketization.measure.domain.unit.MeasureUnit;
import com.snszyk.iiot.marketization.measure.domain.unit.MeasureUnitRepository;
import com.snszyk.iiot.marketization.measure.domain.unitView.MeasureUnitView;
import com.snszyk.iiot.marketization.measure.domain.unitView.MeasureUnitViewRepository;
import com.snszyk.iiot.marketization.measure.infrastructure.mybatis.po.MeasureUnitPo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

@Service
public class MeasureUnitService {
    @Autowired
    MeasureUnitRepository repository;

    @Autowired
    MeasureUnitViewRepository viewRepository;

    public MeasureUnitView getMeasureUnitById(String id) {
        return viewRepository.getMeasureUnitById(id);
    }

    public List<MeasureUnitView> getMeasureUnitByIds(Set<String> ids) {
        return viewRepository.getMeasureUnitByIds(ids);
    }

    public IPage<MeasureUnitView> getMeasureUnitPages(MeasureUnitPageSearchCommand command) {
        IPage<MeasureUnitPo> pageParam = command.initPage();

        return viewRepository.getMeasureUnitPages(command.getCategoryId(), command.getName(), pageParam);
    }

    public List<MeasureUnitView> getMeasureUnitsByCategoryId(String categoryId) {
        return viewRepository.getMeasureUnitsByCategoryId(categoryId);
    }

    @Transactional
    public void create(MeasureUnitCreateCommand command) throws Exception {
        MeasureUnit measureUnit = command.initDomain();
        measureUnit.create(repository);
    }

    @Transactional(rollbackOn = Exception.class)
    public void edit(MeasureUnitEditCommand command) {
        MeasureUnit measureUnit = command.initDomain();
        measureUnit.edit(repository);
    }

    @Transactional
    public void delete(String id) {
        // TODO 删除校验(所有引用的地方应该都检查是否有引用,若有则提醒不能删除)
        MeasureUnit measureUnit = repository.findMeasureUnitById(id);
        measureUnit.delete(repository);
    }
}
