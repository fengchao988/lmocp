package com.snszyk.iiot.marketization.measure.application.unit;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.snszyk.iiot.marketization.measure.application.unit.dto.MeasureUnitCategoryCreateCommand;
import com.snszyk.iiot.marketization.measure.application.unit.dto.MeasureUnitCategoryEditCommand;
import com.snszyk.iiot.marketization.measure.application.unit.dto.MeasureUnitCategoryPageSearchCommand;
import com.snszyk.iiot.marketization.measure.domain.unit.MeasureUnit;
import com.snszyk.iiot.marketization.measure.domain.unit.MeasureUnitCategory;
import com.snszyk.iiot.marketization.measure.domain.unit.MeasureUnitRepository;
import com.snszyk.iiot.marketization.measure.domain.unitView.MeasureUnitCategoryPageView;
import com.snszyk.iiot.marketization.measure.domain.unitView.MeasureUnitCategoryView;
import com.snszyk.iiot.marketization.measure.domain.unitView.MeasureUnitViewRepository;
import com.snszyk.iiot.marketization.measure.infrastructure.mybatis.po.MeasureUnitCategoryPo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MeasureUnitCategoryService {
    @Autowired
    MeasureUnitRepository repository;

    @Autowired
    MeasureUnitViewRepository viewRepository;


    public MeasureUnitCategoryView getMeasureUnitCategoryById(String id) {
        return viewRepository.getMeasureUnitCategoryById(id);
    }

    public IPage<MeasureUnitCategoryPageView> pageMeasureUnitCategoryView(MeasureUnitCategoryPageSearchCommand command) {
        IPage<MeasureUnitCategoryPo> pageParam = command.initPage();
        return viewRepository.pageMeasureUnitCategoryView(command.getName(), pageParam);
    }

    public List<MeasureUnitCategoryView> getMeasureUnitCategoryViews(String name) {
        return viewRepository.getMeasureUnitCategoryViews(name);
    }

    @Transactional
    public void create(MeasureUnitCategoryCreateCommand command) {
        MeasureUnitCategory measureUnitCategory = command.initDomain();
        measureUnitCategory.create(repository);
    }

    @Transactional(rollbackOn = Exception.class)
    public void edit(MeasureUnitCategoryEditCommand command) throws Exception {
        MeasureUnitCategory measureUnitCategory = command.initDomain();
        measureUnitCategory.edit(repository);
    }

    @Transactional
    public void delete(String id) {
        // TODO 删除校验(所有引用的地方应该都检查是否有引用,若有则提醒不能删除)
        // 根据类型id获取所有单位id
        List<String> unitIdList = repository.getMeasureUnitByMeasureUnitCategoryId(id)
                .stream().map(MeasureUnit::getId)
                .collect(Collectors.toList());

        MeasureUnitCategory measureUnitCategory = repository.findMeasureUnitCategoryById(id);
        measureUnitCategory.delete(repository);
    }
}
