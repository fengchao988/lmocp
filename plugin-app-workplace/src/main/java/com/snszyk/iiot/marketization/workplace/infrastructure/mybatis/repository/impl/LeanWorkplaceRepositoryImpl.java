package com.snszyk.iiot.marketization.workplace.infrastructure.mybatis.repository.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.snszyk.iiot.marketization.workplace.domain.model.LeanWorkplace;
import com.snszyk.iiot.marketization.workplace.domain.model.LeanWorkplaceOption;
import com.snszyk.iiot.marketization.workplace.domain.repository.LeanWorkplaceRepository;
import com.snszyk.iiot.marketization.workplace.infrastructure.mybatis.mapper.LeanWorkplaceMapper;
import com.snszyk.iiot.marketization.workplace.infrastructure.mybatis.mapper.LeanWorkplaceOptionMapper;
import com.snszyk.iiot.marketization.workplace.infrastructure.mybatis.po.DomainMapper;
import com.snszyk.iiot.marketization.workplace.infrastructure.mybatis.po.LeanWorkplaceOptionPo;
import com.snszyk.iiot.marketization.workplace.infrastructure.mybatis.po.LeanWorkplacePo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.jeecg.common.system.base.service.impl.JeecgServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 工作地点数据仓库实现类
 *
 * @author tttt-boot
 * @version 1.0.0
 * @since 2021-01-12 16:13
 */
@Repository
@Slf4j
public class LeanWorkplaceRepositoryImpl extends JeecgServiceImpl<LeanWorkplaceMapper, LeanWorkplacePo> implements LeanWorkplaceRepository {
    @Autowired
    private LeanWorkplaceOptionMapper leanWorkplaceOptionMapper;

    @Override
    public String save(LeanWorkplace leanWorkplace) {
        LeanWorkplacePo po = DomainMapper.INSTANCE.covertByDomain(leanWorkplace);
        baseMapper.insert(po);
        return po.getId();
    }

    @Override
    public Boolean update(LeanWorkplace leanWorkplace) {
        LeanWorkplacePo po = DomainMapper.INSTANCE.covertByDomain(leanWorkplace);
        return baseMapper.updateById(po) == 1;
    }

    @Override
    public Boolean delete(String id) {
        QueryWrapper<LeanWorkplaceOptionPo> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda()
                .eq(LeanWorkplaceOptionPo::getWorkplaceId, id);
        List<LeanWorkplaceOptionPo> leanWorkplaceOptionPos = leanWorkplaceOptionMapper.selectList(queryWrapper);
        List<String> optionIds = leanWorkplaceOptionPos.stream()
                .map(LeanWorkplaceOptionPo::getId)
                .collect(Collectors.toList());
        if (optionIds.size() > 0) {
            leanWorkplaceOptionMapper.deleteBatchIds(optionIds);
        }
        return baseMapper.deleteById(id) == 1;
    }

    @Override
    public Boolean deleteByIds(List<String> ids) {
        QueryWrapper<LeanWorkplacePo> wrapper = new QueryWrapper<>();
        wrapper.lambda().in(LeanWorkplacePo::getId, ids);
        QueryWrapper<LeanWorkplaceOptionPo> optionPoQueryWrapper = new QueryWrapper<>();
        optionPoQueryWrapper.lambda().in(LeanWorkplaceOptionPo::getWorkplaceId, ids);
        List<LeanWorkplaceOptionPo> leanWorkplaceOptionPos = leanWorkplaceOptionMapper.selectList(optionPoQueryWrapper);
        List<String> optionIds = leanWorkplaceOptionPos.stream()
                .map(LeanWorkplaceOptionPo::getId)
                .collect(Collectors.toList());
        baseMapper.delete(wrapper);
        if (optionIds.size() > 0) {
            leanWorkplaceOptionMapper.deleteBatchIds(optionIds);
        }
        return true;
    }

    @Override
    public void create(LeanWorkplace leanWorkplace) {
        LeanWorkplacePo leanWorkplacePo = DomainMapper.INSTANCE.covertByDomain(leanWorkplace);
        baseMapper.insert(leanWorkplacePo);
        leanWorkplace.setId(leanWorkplacePo.getId());
    }

    @Override
    public void batchCreateOptions(List<LeanWorkplaceOption> options) {
        options.forEach(leanWorkplaceOption -> {
            LeanWorkplaceOptionPo leanWorkplaceOptionPo = DomainMapper.INSTANCE.covertByDomain(leanWorkplaceOption);
            leanWorkplaceOptionMapper.insert(leanWorkplaceOptionPo);
        });
    }

    @Override
    public void batchModifyOptions(List<LeanWorkplaceOption> options) {
        options.forEach(leanWorkplaceOption -> {
            LeanWorkplaceOptionPo leanWorkplaceOptionPo = DomainMapper.INSTANCE.covertByDomain(leanWorkplaceOption);
            leanWorkplaceOptionMapper.updateById(leanWorkplaceOptionPo);
        });
    }

    @Override
    public boolean existsName(LeanWorkplace leanWorkplace) {
        LambdaQueryWrapper<LeanWorkplacePo> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(LeanWorkplacePo::getName, leanWorkplace.getName())
                .ne(StringUtils.isNotBlank(leanWorkplace.getId()), LeanWorkplacePo::getId, leanWorkplace.getId());
        return baseMapper.selectCount(wrapper) > 0;
    }
}
