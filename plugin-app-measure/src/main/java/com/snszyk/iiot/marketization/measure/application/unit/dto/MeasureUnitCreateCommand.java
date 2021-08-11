package com.snszyk.iiot.marketization.measure.application.unit.dto;

import com.snszyk.iiot.marketization.measure.domain.unit.MeasureUnit;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
@ApiModel("计量单位创建对象")
public class MeasureUnitCreateCommand {

    @NotEmpty(message = "请输入名称")
    @ApiModelProperty(value = "名称")
    private String name;

    @NotEmpty(message = "请输入展示符号")
    @ApiModelProperty(value = "展示符号")
    private String symbol;

    @NotEmpty(message = "请选择分类")
    @ApiModelProperty(value = "分类ID")
    private String categoryId;

    @ApiModelProperty(value = "排序")
    private int sort;

    @ApiModelProperty(value = "描述")
    private String description;

    public MeasureUnit initDomain() {
        return new MeasureUnit(name, symbol, categoryId, sort, description);
    }
}
