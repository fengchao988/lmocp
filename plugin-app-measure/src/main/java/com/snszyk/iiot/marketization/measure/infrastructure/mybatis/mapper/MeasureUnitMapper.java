package com.snszyk.iiot.marketization.measure.infrastructure.mybatis.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.snszyk.iiot.marketization.measure.infrastructure.mybatis.po.MeasureUnitPo;
import org.apache.ibatis.annotations.Mapper;

/**
 * 计量单位分类数据操作接口
 *
 * @author tttt-boot
 * @version 1.0.0
 * @since 2021-01-20 18:05
 */
@Mapper
public interface MeasureUnitMapper extends BaseMapper<MeasureUnitPo> {

}
