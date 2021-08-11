package com.snszyk.iiot.marketization.workplace.application.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.snszyk.iiot.marketization.workplace.application.dto.LeanWorkplaceOptionQueryDto;
import com.snszyk.iiot.marketization.workplace.application.service.ConditionService;
import com.snszyk.iiot.marketization.workplace.application.service.ILeanWorkplaceOptionService;
import com.snszyk.iiot.marketization.workplace.domain.conditionView.ConditionView;
import com.snszyk.iiot.marketization.workplace.domain.model.LeanWorkplaceOption;
import com.snszyk.iiot.marketization.workplace.domain.repository.LeanWorkplaceOptionRepository;
import com.snszyk.iiot.marketization.workplace.infrastructure.mybatis.mapper.LeanWorkplaceOptionMapper;
import com.snszyk.iiot.marketization.workplace.infrastructure.mybatis.po.LeanWorkplaceOptionPo;
import com.snszyk.iiot.marketization.workplace.infrastructure.resource.vo.LeanWorkplaceOptionVo;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.jeecg.common.system.base.service.impl.JeecgServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;


/**
 * 工作地点作业参数 业务实现类
 *
 * @author tttt-boot
 * @version 1.0.0
 * @since 2021-01-12 16:14
 */
@Service
public class LeanWorkplaceOptionServiceImpl extends JeecgServiceImpl<LeanWorkplaceOptionMapper, LeanWorkplaceOptionPo> implements ILeanWorkplaceOptionService {
    @Autowired
    private LeanWorkplaceOptionRepository repository;

    @Autowired
    private ConditionService conditionService;

    @Override
    public IPage<LeanWorkplaceOptionVo> queryPage(LeanWorkplaceOptionQueryDto page) {
        IPage<LeanWorkplaceOptionPo> pageParam = page.initPage();

        LambdaQueryWrapper<LeanWorkplaceOptionPo> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(StringUtils.isNotBlank(page.getWorkplaceId()), LeanWorkplaceOptionPo::getWorkplaceId, page.getWorkplaceId());
        IPage<LeanWorkplaceOptionPo> poPage = baseMapper.selectPage(pageParam, wrapper);
        List<LeanWorkplaceOptionPo> poList = poPage.getRecords();
        Set<String> parameterIds = poList.stream().map(LeanWorkplaceOptionPo::getParameter).collect(Collectors.toSet());

        Map<String, ConditionView> parameterPos;
        if (CollectionUtils.isEmpty(parameterIds)) {
            parameterPos = Collections.emptyMap();
        } else {
            List<ConditionView> conditionViewList = conditionService.getConditionByIds(parameterIds);
            parameterPos = conditionViewList.stream()
                    .collect(Collectors.toMap(ConditionView::getId, c -> c));
        }
        List<LeanWorkplaceOptionVo> voList = poList.stream()
                .map(optionPo -> new LeanWorkplaceOptionVo(optionPo, parameterPos.get(optionPo.getParameter())))
                .collect(Collectors.toList());
        IPage<LeanWorkplaceOptionVo> resultPage = new Page<>();
        BeanUtils.copyProperties(poPage, resultPage);
        resultPage.setRecords(voList);
        return resultPage;
    }

    @Override
    @Transactional
    public void savePo(LeanWorkplaceOptionQueryDto dto) {
        LeanWorkplaceOption domain = new LeanWorkplaceOption(dto.getParameter(), dto.getValue(), dto.getWorkplaceId());
        domain.save(repository);
    }

    @Override
    @Transactional
    public void updatePo(LeanWorkplaceOptionQueryDto dto) {
        LeanWorkplaceOption domain = new LeanWorkplaceOption(dto.getId(), dto.getParameter(), dto.getValue(), dto.getWorkplaceId());
        domain.update(repository);
    }

    @Override
    @Transactional
    public void removePo(String id) {
        new LeanWorkplaceOption(id).delete(repository);
    }

    @Override
    @Transactional
    public void removePoByIds(List<String> ids) {
        new LeanWorkplaceOption(ids).deleteByIds(repository);
    }

    @Override
    public LeanWorkplaceOptionVo getVoById(String id) {
        LeanWorkplaceOptionPo po = baseMapper.selectById(id);
        return new LeanWorkplaceOptionVo(po);
    }

    @Override
    public List<LeanWorkplaceOptionVo> getOptionsByWorkplaceId(String id) {
        QueryWrapper<LeanWorkplaceOptionPo> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda()
                .eq(LeanWorkplaceOptionPo::getWorkplaceId, id);
        return baseMapper.selectList(queryWrapper).stream()
                .map(LeanWorkplaceOptionVo::new)
                .collect(Collectors.toList());
    }
}
