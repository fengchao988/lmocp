package com.snszyk.iiot.marketization.measure.infrastructure.mybatis.unitView;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.snszyk.iiot.marketization.measure.domain.unitView.MeasureUnitCategoryPageView;
import com.snszyk.iiot.marketization.measure.domain.unitView.MeasureUnitCategoryView;
import com.snszyk.iiot.marketization.measure.domain.unitView.MeasureUnitView;
import com.snszyk.iiot.marketization.measure.domain.unitView.MeasureUnitViewRepository;
import com.snszyk.iiot.marketization.measure.infrastructure.mybatis.mapper.MeasureUnitCategoryMapper;
import com.snszyk.iiot.marketization.measure.infrastructure.mybatis.po.MeasureUnitCategoryPo;
import com.snszyk.iiot.marketization.measure.infrastructure.mybatis.mapper.MeasureUnitMapper;
import com.snszyk.iiot.marketization.measure.infrastructure.mybatis.po.MeasureUnitPo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author windy
 * @date 2021-01-27 10:37:01
 */
@Repository
public class MeasureUnitViewRepositoryImpl implements MeasureUnitViewRepository {

    @Autowired
    MeasureUnitMapper measureUnitMapper;

    @Autowired
    MeasureUnitCategoryMapper measureUnitCategoryMapper;

    @Override
    public IPage<MeasureUnitCategoryPageView> pageMeasureUnitCategoryView(String name, IPage<MeasureUnitCategoryPo> pageParam) {
        LambdaQueryWrapper<MeasureUnitCategoryPo> wrapper = new LambdaQueryWrapper<>();
        //noinspection unchecked
        wrapper.like(!StringUtils.isEmpty(name), MeasureUnitCategoryPo::getName, name)
                .orderByAsc(MeasureUnitCategoryPo::getSort, MeasureUnitCategoryPo::getCreateTime);
        IPage<MeasureUnitCategoryPo> measureUnitCategoryPoPages = measureUnitCategoryMapper.selectPage(pageParam, wrapper);
        IPage<MeasureUnitCategoryPageView> measureUnitCategoryViewPages = new Page<>();
        List<MeasureUnitCategoryPageView> measureUnitCategoryPageViews = measureUnitCategoryPoPages.getRecords()
                .stream().map(MeasureUnitCategoryPo::convertToMeasureUnitCategoryPageView).collect(Collectors.toList());
        BeanUtils.copyProperties(measureUnitCategoryPoPages, measureUnitCategoryViewPages);
        measureUnitCategoryViewPages.setRecords(measureUnitCategoryPageViews);
        return measureUnitCategoryViewPages;
    }

    @Override
    public MeasureUnitCategoryView getMeasureUnitCategoryById(String id) {
        MeasureUnitCategoryPo measureUnitCategoryPo = measureUnitCategoryMapper.selectById(id);
        return null != measureUnitCategoryPo ? measureUnitCategoryPo.convertToMeasureUnitCategoryView(this) : null;
    }

    @Override
    public List<MeasureUnitView> getMeasureUnitsByCategoryId(String id) {
        LambdaQueryWrapper<MeasureUnitPo> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(MeasureUnitPo::getCategoryId, id);
        //noinspection unchecked
        wrapper.orderByAsc(MeasureUnitPo::getSort, MeasureUnitPo::getCreateTime);
        List<MeasureUnitPo> measureUnitPos = this.measureUnitMapper.selectList(wrapper);
        return measureUnitPos.stream()
                .map(MeasureUnitPo::convertToMeasureUnitView).collect(Collectors.toList());
    }

    @Override
    public MeasureUnitView getMeasureUnitById(String id) {
        MeasureUnitPo measureUnitPo = measureUnitMapper.selectById(id);
        return null != measureUnitPo ? measureUnitPo.convertToMeasureUnitView() : null;
    }

    @Override
    public List<MeasureUnitView> getMeasureUnitByIds(Collection<String> ids) {
        LambdaQueryWrapper<MeasureUnitPo> wrapper = new LambdaQueryWrapper<>();
        wrapper.in(MeasureUnitPo::getId, ids);
        List<MeasureUnitPo> measureUnitPoList = measureUnitMapper.selectList(wrapper);
        return measureUnitPoList.stream().map(MeasureUnitPo::convertToMeasureUnitView).collect(Collectors.toList());
    }

    @Override
    public IPage<MeasureUnitView> getMeasureUnitPages(String categoryId, String name, IPage<MeasureUnitPo> page) {
        LambdaQueryWrapper<MeasureUnitPo> wrapper = new LambdaQueryWrapper<>();
        wrapper.like(!StringUtils.isEmpty(name), MeasureUnitPo::getName, name)
                .eq(MeasureUnitPo::getCategoryId, categoryId);
        //noinspection unchecked
        wrapper.orderByAsc(MeasureUnitPo::getSort, MeasureUnitPo::getCreateTime);
        IPage<MeasureUnitPo> measureUnitPoPages = measureUnitMapper.selectPage(page, wrapper);
        IPage<MeasureUnitView> measureUnitViewPages = new Page<>();
        List<MeasureUnitView> measureUnitPageViews = measureUnitPoPages.getRecords().stream()
                .map(MeasureUnitPo::convertToMeasureUnitView).collect(Collectors.toList());
        BeanUtils.copyProperties(measureUnitPoPages, measureUnitViewPages);
        measureUnitViewPages.setRecords(measureUnitPageViews);
        return measureUnitViewPages;
    }

    @Override
    public List<MeasureUnitCategoryView> getMeasureUnitCategoryViews(String name) {
        LambdaQueryWrapper<MeasureUnitCategoryPo> wrapper = new LambdaQueryWrapper<>();
        wrapper.like(!StringUtils.isEmpty(name), MeasureUnitCategoryPo::getName, name);
        //noinspection unchecked
        wrapper.orderByAsc(MeasureUnitCategoryPo::getSort, MeasureUnitCategoryPo::getCreateTime);
        List<MeasureUnitCategoryPo> measureUnitCategoryPos = measureUnitCategoryMapper.selectList(wrapper);
        return measureUnitCategoryPos.stream()
                .map(category -> category.convertToMeasureUnitCategoryView(this))
                .collect(Collectors.toList());
    }

    @Override
    public List<MeasureUnitView> findByIds(List<String> idList) {
        QueryWrapper<MeasureUnitPo> wrapper = new QueryWrapper<>();
        wrapper.lambda().in(MeasureUnitPo::getId, idList);
        List<MeasureUnitPo> list = measureUnitMapper.selectList(wrapper);
        if (CollectionUtils.isEmpty(list)) {
            return Collections.emptyList();
        }
        return list.stream().map(MeasureUnitPo::convertToMeasureUnitView).collect(Collectors.toList());
    }
}
