package com.snszyk.iiot.marketization.workplace.infrastructure.mybatis.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.snszyk.iiot.marketization.workplace.infrastructure.mybatis.po.LeanWorkplacePo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * 工作地点 数据操作接口
 *
 * @author tttt-boot
 * @version 1.0.0
 * @since 2021-01-12 16:13
 */
@Mapper
public interface LeanWorkplaceMapper extends BaseMapper<LeanWorkplacePo> {
    @Select("select * from lc_workplace_info where id=#{id}")
    LeanWorkplacePo getById(@Param("id") String id);
}
