package com.snszyk.iiot.marketization.workplace.application.dto.conditionValue;

import com.snszyk.iiot.marketization.workplace.domain.condition.model.ConditionValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
@ApiModel("条件值添加")
public class MakeCommand {
    @NotEmpty(message = "请选择正确的条件")
    @ApiModelProperty("条件ID")
    private String conditionId;

    @NotEmpty(message = "请输入条件值名称")
    @ApiModelProperty("条件值名称")
    private String name;

    @NotEmpty(message = "请输入条件值编码")
    @ApiModelProperty("条件值编码")
    private String code;

    public ConditionValue initDomain() {
        return new ConditionValue(name, code);
    }
}
