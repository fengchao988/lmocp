package com.snszyk.iiot.marketization.measure.application.unit.dto;

import com.snszyk.iiot.marketization.measure.domain.unit.MeasureUnitCategory;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
@ApiModel("计量单位类别创建对象")
public class MeasureUnitCategoryCreateCommand {
    @ApiModelProperty(value = "分类名称")
    @NotEmpty(message = "请输入分类名称")
    private String name;

    @ApiModelProperty(value = "排序")
    private int sort;

    @ApiModelProperty(value = "描述")
    private String description;

    public MeasureUnitCategory initDomain() {
        return new MeasureUnitCategory(name, sort, description);
    }
}
