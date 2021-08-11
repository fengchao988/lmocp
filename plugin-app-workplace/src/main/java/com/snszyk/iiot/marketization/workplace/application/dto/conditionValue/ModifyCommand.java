package com.snszyk.iiot.marketization.workplace.application.dto.conditionValue;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
@ApiModel("调整条件值")
public class ModifyCommand {
    private String id;

    @NotEmpty(message = "请选择正确的条件")
    @ApiModelProperty(value = "所属条件ID", required = true)
    private String conditionId;

    @NotEmpty(message = "条件值名称")
    @ApiModelProperty(value = "条件值名称", required = true)
    private String name;
}
