package com.snszyk.iiot.marketization.workplace.infrastructure.mybatis.repository.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.snszyk.iiot.marketization.workplace.domain.model.LeanWorkplaceOption;
import com.snszyk.iiot.marketization.workplace.domain.repository.LeanWorkplaceOptionRepository;
import com.snszyk.iiot.marketization.workplace.infrastructure.mybatis.mapper.LeanWorkplaceOptionMapper;
import com.snszyk.iiot.marketization.workplace.infrastructure.mybatis.po.DomainMapper;
import com.snszyk.iiot.marketization.workplace.infrastructure.mybatis.po.LeanWorkplaceOptionPo;
import lombok.extern.slf4j.Slf4j;
import org.jeecg.common.system.base.service.impl.JeecgServiceImpl;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 工作地点作业参数数据仓库实现类
 *
 * @author tttt-boot
 * @version 1.0.0
 * @since 2021-01-12 16:14
 */
@Repository
@Slf4j
public class LeanWorkplaceOptionRepositoryImpl extends JeecgServiceImpl<LeanWorkplaceOptionMapper, LeanWorkplaceOptionPo> implements LeanWorkplaceOptionRepository {
    @Override
    public String save(LeanWorkplaceOption leanWorkplaceOption) {
        LeanWorkplaceOptionPo po = DomainMapper.INSTANCE.covertByDomain(leanWorkplaceOption);
        baseMapper.insert(po);
        return po.getId();
    }

    @Override
    public Boolean update(LeanWorkplaceOption leanWorkplaceOption) {
        LeanWorkplaceOptionPo po = DomainMapper.INSTANCE.covertByDomain(leanWorkplaceOption);
        return baseMapper.updateById(po) == 1;
    }

    @Override
    public Boolean delete(String id) {
        return baseMapper.deleteById(id) == 1;
    }

    @Override
    public Boolean deleteByIds(List<String> ids) {
        QueryWrapper<LeanWorkplaceOptionPo> wrapper = new QueryWrapper<>();
        wrapper.lambda().in(LeanWorkplaceOptionPo::getId, ids);
        baseMapper.delete(wrapper);
        return true;
    }
}
