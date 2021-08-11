package com.snszyk.iiot.marketization.measure.application.unit.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.jeecg.common.system.base.dto.RequestPage;

@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel("计量单位类别分页查询参数")
public class MeasureUnitCategoryPageSearchCommand extends RequestPage {

    @ApiModelProperty("名称")
    private String name;
}
