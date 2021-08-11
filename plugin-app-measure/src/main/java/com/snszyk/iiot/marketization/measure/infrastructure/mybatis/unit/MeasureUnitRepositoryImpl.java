package com.snszyk.iiot.marketization.measure.infrastructure.mybatis.unit;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.snszyk.iiot.marketization.measure.domain.unit.MeasureUnit;
import com.snszyk.iiot.marketization.measure.domain.unit.MeasureUnitCategory;
import com.snszyk.iiot.marketization.measure.domain.unit.MeasureUnitRepository;
import com.snszyk.iiot.marketization.measure.infrastructure.mybatis.mapper.MeasureUnitCategoryMapper;
import com.snszyk.iiot.marketization.measure.infrastructure.mybatis.mapper.MeasureUnitMapper;
import com.snszyk.iiot.marketization.measure.infrastructure.mybatis.po.MeasureUnitCategoryPo;
import com.snszyk.iiot.marketization.measure.infrastructure.mybatis.po.MeasureUnitPo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author windy
 * @date 2021-01-27 10:37:01
 */
@Repository
public class MeasureUnitRepositoryImpl implements MeasureUnitRepository {
    @Autowired
    private MeasureUnitCategoryMapper measureUnitCategoryMapper;

    @Autowired
    private MeasureUnitMapper measureUnitMapper;

    @Override
    public void saveUnitCategory(MeasureUnitCategory measureUnitCategory) {
        MeasureUnitCategoryPo measureUnitCategoryPo = new MeasureUnitCategoryPo(measureUnitCategory);
        measureUnitCategoryMapper.insert(measureUnitCategoryPo);

    }

    @Override
    public MeasureUnitCategory findMeasureUnitCategoryById(String id) {
        MeasureUnitCategoryPo measureUnitCategoryPo = measureUnitCategoryMapper.selectById(id);
        return null != measureUnitCategoryPo ? measureUnitCategoryPo.transferToDomain() : null;
    }

    @Override
    public void deleteMeasureUnitCategory(MeasureUnitCategory measureUnitCategory) {
        measureUnitCategoryMapper.deleteById(measureUnitCategory.getId());
    }

    @Override
    public void saveUnit(MeasureUnit measureUnit) {
        MeasureUnitPo measureUnitPo = new MeasureUnitPo(measureUnit);
        measureUnitMapper.insert(measureUnitPo);
    }

    @Override
    public MeasureUnit findMeasureUnitById(String id) {
        MeasureUnitPo measureUnitPo = measureUnitMapper.selectById(id);
        return null != measureUnitPo ? measureUnitPo.transferToDomain() : null;
    }

    @Override
    public void deleteMeasureUnit(MeasureUnit measureUnit) {
        measureUnitMapper.deleteById(measureUnit.getId());
    }

    @Override
    public void editUnitCategory(MeasureUnitCategory measureUnitCategory) {
        MeasureUnitCategoryPo measureUnitCategoryPo = measureUnitCategoryMapper.selectById(measureUnitCategory.getId());
        measureUnitCategoryPo.setEditAttr(measureUnitCategory);
        measureUnitCategoryMapper.updateById(measureUnitCategoryPo);
    }

    @Override
    public void editMeasureUnit(MeasureUnit measureUnit) {
        MeasureUnitPo measureUnitPo = measureUnitMapper.selectById(measureUnit.getId());
        measureUnitPo.setEditAttr(measureUnit);
        measureUnitMapper.updateById(measureUnitPo);
    }

    @Override
    public List<MeasureUnit> list(MeasureUnit measureUnit) {
        QueryWrapper<MeasureUnitPo> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(MeasureUnitPo::getCategoryId, measureUnit.getCategoryId())
                .eq(MeasureUnitPo::getName, measureUnit.getName())
                .eq(MeasureUnitPo::getSymbol, measureUnit.getSymbol());
        List<MeasureUnitPo> list = measureUnitMapper.selectList(queryWrapper);
        return CollectionUtils.isEmpty(list) ? Collections.emptyList() : list.stream().map(MeasureUnitPo::transferToDomain).collect(Collectors.toList());
    }

    @Override
    public MeasureUnitCategory getMeasureUnitCategoryByName(String name) {
        QueryWrapper<MeasureUnitCategoryPo> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(MeasureUnitCategoryPo::getName, name);
        MeasureUnitCategoryPo measureUnitCategoryPo = measureUnitCategoryMapper.selectOne(wrapper);
        return null != measureUnitCategoryPo ? measureUnitCategoryPo.transferToDomain() : null;
    }

    @Override
    public List<MeasureUnit> getMeasureUnitByMeasureUnitCategoryId(String id) {
        QueryWrapper<MeasureUnitPo> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(MeasureUnitPo::getCategoryId, id);
        wrapper.lambda().orderByAsc(MeasureUnitPo::getSort);
        List<MeasureUnitPo> measureUnitPos = this.measureUnitMapper.selectList(wrapper);
        List<MeasureUnit> measureUnits = new ArrayList<>();
        measureUnitPos.forEach(measureUnitPo -> {
            measureUnits.add(measureUnitPo.transferToDomain());
        });
        return measureUnits;
    }

}
