package com.snszyk.iiot.marketization.workplace.infrastructure.mybatis.repository.conditionView;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.snszyk.iiot.marketization.workplace.domain.condition.model.ConditionType;
import com.snszyk.iiot.marketization.workplace.domain.conditionView.ConditionPageView;
import com.snszyk.iiot.marketization.workplace.domain.conditionView.ConditionValueView;
import com.snszyk.iiot.marketization.workplace.domain.conditionView.ConditionView;
import com.snszyk.iiot.marketization.workplace.domain.conditionView.repository.ConditionViewRepository;
import com.snszyk.iiot.marketization.workplace.domain.intergration.unit.UnitRestRepository;
import com.snszyk.iiot.marketization.workplace.infrastructure.mybatis.mapper.ConditionMapper;
import com.snszyk.iiot.marketization.workplace.infrastructure.mybatis.mapper.ConditionValueMapper;
import com.snszyk.iiot.marketization.workplace.infrastructure.mybatis.po.ConditionPo;
import com.snszyk.iiot.marketization.workplace.infrastructure.mybatis.po.ConditionValuePo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Repository
public class ConditionViewRepositoryImpl implements ConditionViewRepository {

    @Autowired
    private ConditionMapper conditionMapper;

    @Autowired
    private ConditionValueMapper conditionValueMapper;

    @Resource
    private UnitRestRepository unitRestRepository;

    @Override
    public IPage<ConditionPageView> pageConditionPageView(String code, String name, ConditionType conditionType, Integer pageNo, Integer pageSize) {
        // 1.??????????????????
        QueryWrapper<ConditionPo> wrapper = new QueryWrapper<>();
        wrapper.lambda().like(!StringUtils.isEmpty(name), ConditionPo::getName, name);
        wrapper.lambda().like(!StringUtils.isEmpty(code), ConditionPo::getCode, code);
        wrapper.lambda().eq(null != conditionType, ConditionPo::getConditionType, conditionType);
        wrapper.lambda().orderByAsc(ConditionPo::getCreateTime);
        // 2.??????????????????
        IPage<ConditionPo> conditionPoPage = conditionMapper.selectPage(new Page<>(pageNo, pageSize), wrapper);
        // 3.??????????????????,?????????????????????,?????????Po???????????????
        IPage<ConditionPageView> conditionViewPage = new Page<>();
        List<ConditionPageView> conditionPageViews = new ArrayList<>();
        conditionPoPage.getRecords().forEach(conditionPo -> {
            ConditionPageView conditionPageView = conditionPo.convertToConditionPageView(unitRestRepository);
            // 4.??????????????????????????? ??????????????????????????????????????????????????????,???????????????,????????????????????????,??????,?????????????????????????????????(????????????????????????)
            // conditionPageView.????????????();
            conditionPageViews.add(conditionPageView);
        });
        // 5.??????????????????????????????????????????
        BeanUtils.copyProperties(conditionPoPage, conditionViewPage);
        conditionViewPage.setRecords(conditionPageViews);
        return conditionViewPage;
    }

    @Override
    public List<ConditionValueView> listConditionValues(String conditionId) {
        QueryWrapper<ConditionValuePo> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(ConditionValuePo::getConditionId, conditionId);
        wrapper.lambda().orderByAsc(ConditionValuePo::getCreateTime);
        return conditionValueMapper.selectList(wrapper).stream()
                .map(po -> po.convertToConditionValueViewDomain(po.getConditionId())).collect(Collectors.toList());
    }

    @Override
    public ConditionView getConditionByCode(String code) {
        QueryWrapper<ConditionPo> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(ConditionPo::getCode, code);
        ConditionPo conditionPo = conditionMapper.selectOne(wrapper);
        return null != conditionPo ? conditionPo.convertToConditionView(this, unitRestRepository) : null;
    }

    @Override
    public List<ConditionValueView> getConditionValueViewsByConditionId(String conditionId) {
        QueryWrapper<ConditionValuePo> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(ConditionValuePo::getConditionId, conditionId);
        wrapper.lambda().orderByAsc(ConditionValuePo::getCreateTime);
        List<ConditionValuePo> conditionValuePos = conditionValueMapper.selectList(wrapper);
        List<ConditionValueView> conditionValueViews = new ArrayList<>();
        conditionValuePos.stream().forEach(conditionValuePo -> {
            ConditionValueView conditionValueView = conditionValuePo.convertToConditionValueViewDomain(conditionId);
            conditionValueViews.add(conditionValueView);
        });
        return conditionValueViews;
    }

    @Override
    public ConditionView getConditionById(String id) {
        QueryWrapper<ConditionPo> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(ConditionPo::getId, id);
        ConditionPo conditionPo = conditionMapper.selectOne(wrapper);
        return null != conditionPo ? conditionPo.convertToConditionView(this, unitRestRepository) : null;
    }

    @Override
    public List<ConditionView> listConditionView(String code, String name, ConditionType conditionType) {
        QueryWrapper<ConditionPo> wrapper = new QueryWrapper<>();
        wrapper.lambda().like(!StringUtils.isEmpty(name), ConditionPo::getName, name);
        wrapper.lambda().like(!StringUtils.isEmpty(code), ConditionPo::getCode, code);
        wrapper.lambda().eq(null != conditionType, ConditionPo::getConditionType, conditionType);
        wrapper.lambda().orderByAsc(ConditionPo::getCreateTime);
        List<ConditionPo> conditionPos = this.conditionMapper.selectList(wrapper);
        List<ConditionView> conditionViews = new ArrayList<>();
        conditionPos.stream().forEach(conditionPo -> {
            conditionViews.add(conditionPo.convertToConditionView(this, unitRestRepository));
        });
        return conditionViews;
    }

    @Override
    public List<ConditionView> getConditionByIds(Collection<String> ids) {
        QueryWrapper<ConditionPo> wrapper = new QueryWrapper<>();
        wrapper.lambda().in(ConditionPo::getId, ids);
        wrapper.lambda().orderByAsc(ConditionPo::getCreateTime);
        List<ConditionPo> conditionPos = this.conditionMapper.selectList(wrapper);
        List<ConditionView> conditionViews = new ArrayList<>();
        conditionPos.forEach(conditionPo -> {
            conditionViews.add(conditionPo.convertToConditionView(this, unitRestRepository));
        });
        return conditionViews;
    }
}
