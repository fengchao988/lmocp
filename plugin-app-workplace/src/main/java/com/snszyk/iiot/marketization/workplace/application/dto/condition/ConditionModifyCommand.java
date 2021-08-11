package com.snszyk.iiot.marketization.workplace.application.dto.condition;

import com.snszyk.iiot.marketization.workplace.domain.condition.Condition;
import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel("条件调整对象")
public class ConditionModifyCommand extends ConditionBaseCommand {
    String id;

    public Condition initDomain() {
        return new Condition(id, getName(), null, getMeasuringUnitId(), getConditionType(), getRemark());
    }
}
