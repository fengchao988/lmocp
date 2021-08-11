package com.snszyk.iiot.marketization.measure.application.unit.dto;

import com.snszyk.iiot.marketization.measure.domain.unit.MeasureUnit;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotEmpty;

@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel("计量单位编辑对象")
public class MeasureUnitEditCommand extends MeasureUnitCreateCommand {

    @NotEmpty(message = "请输入计量单位ID")
    @ApiModelProperty(value = "计量单位ID")
    private String id;

    @Override
    public MeasureUnit initDomain() {
        return new MeasureUnit(id, getName(), getSymbol(), getCategoryId(), getSort(), getDescription());
    }
}
