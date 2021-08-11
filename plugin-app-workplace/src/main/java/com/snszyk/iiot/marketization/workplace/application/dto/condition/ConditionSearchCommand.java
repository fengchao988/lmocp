package com.snszyk.iiot.marketization.workplace.application.dto.condition;

import com.snszyk.iiot.marketization.workplace.domain.condition.model.ConditionType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.jeecg.common.system.base.dto.RequestPage;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("条件查询参数对象")
public class ConditionSearchCommand extends RequestPage {
    @ApiModelProperty("条件名称")
    private String name;

    @ApiModelProperty("条件编码")
    private String code;

    @ApiModelProperty("条件类型")
    @Enumerated(EnumType.STRING)
    private ConditionType conditionType;
}
