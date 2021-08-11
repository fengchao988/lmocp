package com.snszyk.iiot.marketization.measure.application.unit.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.jeecg.common.system.base.dto.RequestPage;

@EqualsAndHashCode(callSuper = true)
@SuppressWarnings("rawtypes")
@Data
@ApiModel("计量单位分页查询参数")
public class MeasureUnitPageSearchCommand extends RequestPage {
    @ApiModelProperty(value = "分类ID", required = true)
    private String categoryId;

    @ApiModelProperty("名称")
    private String name;
}
