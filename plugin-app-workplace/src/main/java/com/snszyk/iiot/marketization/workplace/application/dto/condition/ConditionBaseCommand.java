package com.snszyk.iiot.marketization.workplace.application.dto.condition;

import com.snszyk.iiot.marketization.workplace.domain.condition.model.ConditionType;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
public class ConditionBaseCommand {
    @NotEmpty(message = "请输入条件名称")
    @ApiModelProperty(value = "条件名称", required = true)
    private String name;

    @ApiModelProperty(value = "计量单位ID", required = false)
    private String measuringUnitId;

    @Enumerated(EnumType.STRING)
    @ApiModelProperty(value = "条件类型", required = true)
    private ConditionType conditionType;

    @Size(min = 0, max = 4000, message = "长度在4000字符以内")
    @ApiModelProperty(value = "条件备注")
    private String remark;
}
