package com.snszyk.iiot.marketization.workplace.application.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.snszyk.iiot.marketization.workplace.application.dto.LeanWorkplaceQueryDto;
import com.snszyk.iiot.marketization.workplace.application.service.ConditionService;
import com.snszyk.iiot.marketization.workplace.application.service.ILeanWorkplaceService;
import com.snszyk.iiot.marketization.workplace.domain.conditionView.ConditionView;
import com.snszyk.iiot.marketization.workplace.domain.model.LeanWorkplace;
import com.snszyk.iiot.marketization.workplace.domain.model.LeanWorkplaceOption;
import com.snszyk.iiot.marketization.workplace.domain.model.enums.WorkplaceType;
import com.snszyk.iiot.marketization.workplace.domain.repository.LeanWorkplaceRepository;
import com.snszyk.iiot.marketization.workplace.infrastructure.mybatis.mapper.LeanWorkplaceMapper;
import com.snszyk.iiot.marketization.workplace.infrastructure.mybatis.mapper.LeanWorkplaceOptionMapper;
import com.snszyk.iiot.marketization.workplace.infrastructure.mybatis.po.LeanWorkplaceOptionPo;
import com.snszyk.iiot.marketization.workplace.infrastructure.mybatis.po.LeanWorkplacePo;
import com.snszyk.iiot.marketization.workplace.infrastructure.resource.vo.LeanWorkplaceOptionVo;
import com.snszyk.iiot.marketization.workplace.infrastructure.resource.vo.LeanWorkplaceVo;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.jeecg.common.system.base.service.impl.JeecgServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;


/**
 * 工作地点 业务实现类
 *
 * @author tttt-boot
 * @version 1.0.0
 * @since 2021-01-12 16:13
 */
@Service
public class LeanWorkplaceServiceImpl extends JeecgServiceImpl<LeanWorkplaceMapper, LeanWorkplacePo> implements ILeanWorkplaceService {
    @Autowired
    private LeanWorkplaceRepository repository;
    @Autowired
    private LeanWorkplaceOptionMapper leanWorkplaceOptionMapper;

    @Override
    public IPage<LeanWorkplaceVo> queryPage(LeanWorkplaceQueryDto page) {
        IPage<LeanWorkplacePo> pageParam = page.initPage();
        String name = page.getName();
        WorkplaceType type = page.getType();

        QueryWrapper<LeanWorkplacePo> wrapper = new QueryWrapper<>();
        wrapper.lambda()
                .like(StringUtils.isNotEmpty(name), LeanWorkplacePo::getName, name)
                .eq(null != type, LeanWorkplacePo::getType, type)
                .orderByDesc(LeanWorkplacePo::getUpdateTime);
        IPage<LeanWorkplacePo> poPage = baseMapper.selectPage(pageParam, wrapper);
        List<LeanWorkplaceVo> voList = covertPo2Vo(poPage.getRecords());

        IPage<LeanWorkplaceVo> resultPage = new Page<>();
        BeanUtils.copyProperties(poPage, resultPage);
        resultPage.setRecords(voList);
        return resultPage;
    }

    @Override
    @Transactional
    public void savePo(LeanWorkplaceQueryDto dto) {
        LeanWorkplace domain = new LeanWorkplace(dto.getId(), dto.getName(), dto.getType());
        domain.save(repository);
    }

    @Override
    @Transactional
    public void updatePo(LeanWorkplaceQueryDto dto) {
        LeanWorkplace domain = new LeanWorkplace(dto.getId(), dto.getName(), dto.getType());
        domain.update(repository);
    }

    @Override
    @Transactional
    public void removePo(String id) {
        new LeanWorkplace(id).delete(repository);
    }

    @Override
    @Transactional
    public void removePoByIds(List<String> ids) {
        new LeanWorkplace(ids).deleteByIds(repository);
    }

    @Override
    public LeanWorkplaceVo getVoById(String id) {
        LeanWorkplacePo po = baseMapper.getById(id);
        List<LeanWorkplaceVo> vos = covertPo2Vo(Collections.singletonList(po));
        return CollectionUtils.isEmpty(vos) ? null : vos.get(0);
    }

    @Override
    @Transactional
    public void batchCreate(LeanWorkplaceQueryDto dto) {
        List<LeanWorkplaceOption> leanWorkplaceOptions = null;
        if (null != dto.getOptions()) {
            leanWorkplaceOptions = dto.getOptions().stream()
                    .map(leanWorkplaceOptionQueryDto -> new LeanWorkplaceOption(
                            leanWorkplaceOptionQueryDto.getId(),
                            leanWorkplaceOptionQueryDto.getParameter(),
                            leanWorkplaceOptionQueryDto.getValue(),
                            leanWorkplaceOptionQueryDto.getWorkplaceId()
                    )).collect(Collectors.toList());

        }
        LeanWorkplace leanWorkplace = new LeanWorkplace(
                dto.getId(),
                dto.getName(),
                dto.getType(),
                leanWorkplaceOptions
        );
        leanWorkplace.batchCreate(repository);
    }

    @Override
    public List<LeanWorkplaceVo> queryListByIds(List<String> idList) {
        if (idList.isEmpty()) {
            return Collections.emptyList();
        }
        QueryWrapper<LeanWorkplacePo> wrapper = new QueryWrapper<>();
        wrapper.lambda().in(LeanWorkplacePo::getId, idList);
        return covertPo2Vo(baseMapper.selectList(wrapper));
    }

    @Override
    public LeanWorkplaceVo queryByName(String name) {
        QueryWrapper<LeanWorkplacePo> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(LeanWorkplacePo::getName, name);
        LeanWorkplacePo workplacePo = baseMapper.selectOne(wrapper);
        if (workplacePo != null) {
            LeanWorkplaceVo vo = new LeanWorkplaceVo();
            BeanUtils.copyProperties(workplacePo, vo);
            return vo;
        }
        return null;
    }

    @Autowired
    private ConditionService conditionService;

    private List<LeanWorkplaceVo> covertPo2Vo(List<LeanWorkplacePo> pos) {
        if (!CollectionUtils.isEmpty(pos)) {
            List<String> workplaceIds = pos.stream().map(LeanWorkplacePo::getId).collect(Collectors.toList());

            QueryWrapper<LeanWorkplaceOptionPo> workplaceOptionPoQueryWrapper = new QueryWrapper<>();
            workplaceOptionPoQueryWrapper.lambda().in(LeanWorkplaceOptionPo::getWorkplaceId, workplaceIds);
            List<LeanWorkplaceOptionPo> optionPos = leanWorkplaceOptionMapper.selectList(workplaceOptionPoQueryWrapper);
            Set<String> parameterIds = optionPos.stream().map(LeanWorkplaceOptionPo::getParameter).collect(Collectors.toSet());
            Map<String, ConditionView> parameterPoMap;
            if (!CollectionUtils.isEmpty(parameterIds)) {
                List<ConditionView> conditionViewList = conditionService.getConditionByIds(parameterIds);
                parameterPoMap = conditionViewList.stream()
                        .collect(Collectors.toMap(ConditionView::getId, c -> c));
            } else {
                parameterPoMap = new HashMap<>();
            }

            return pos.stream().map(po -> {
                LeanWorkplaceVo leanWorkplaceVo = new LeanWorkplaceVo(po);
                List<LeanWorkplaceOptionVo> optionVos = optionPos.stream()
                        .filter(optionPo -> po.getId().equals(optionPo.getWorkplaceId()))
                        .map(optionPo -> new LeanWorkplaceOptionVo(optionPo, parameterPoMap.get(optionPo.getParameter())))
                        .collect(Collectors.toList());
                leanWorkplaceVo.setOptions(optionVos);
                return leanWorkplaceVo;
            }).collect(Collectors.toList());
        }
        return Collections.emptyList();
    }
}
