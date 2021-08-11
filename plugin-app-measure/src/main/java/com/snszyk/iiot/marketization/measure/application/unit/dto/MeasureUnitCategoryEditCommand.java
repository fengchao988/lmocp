package com.snszyk.iiot.marketization.measure.application.unit.dto;

import com.snszyk.iiot.marketization.measure.domain.unit.MeasureUnitCategory;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
@ApiModel("计量单位类别编辑对象")
public class MeasureUnitCategoryEditCommand extends MeasureUnitCategoryCreateCommand {
    @ApiModelProperty(value = "分类ID")
    @NotEmpty(message = "请传入分类ID")
    private String id;

    public MeasureUnitCategory initDomain() {
        return new MeasureUnitCategory(id, getName(), getSort(), getDescription());
    }
}
