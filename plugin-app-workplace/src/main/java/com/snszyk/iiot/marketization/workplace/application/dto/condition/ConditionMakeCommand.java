package com.snszyk.iiot.marketization.workplace.application.dto.condition;

import com.snszyk.iiot.marketization.workplace.domain.condition.Condition;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotEmpty;


@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel("条件编制对象")
public class ConditionMakeCommand extends ConditionBaseCommand {

    @NotEmpty(message = "请输入条件编码")
    @ApiModelProperty(value = "条件编码", required = true)
    private String code;

    public Condition initDomain() {
        return new Condition(getName(), code, getMeasuringUnitId(), getConditionType(), getRemark());
    }
}
