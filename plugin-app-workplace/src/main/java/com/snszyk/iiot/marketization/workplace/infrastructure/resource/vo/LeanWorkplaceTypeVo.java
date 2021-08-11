package com.snszyk.iiot.marketization.workplace.infrastructure.resource.vo;

import com.snszyk.iiot.marketization.workplace.domain.model.enums.WorkplaceType;
import lombok.Data;

@Data
public class LeanWorkplaceTypeVo {
    private String key;
    private String label;
    private String value;

    public LeanWorkplaceTypeVo(WorkplaceType type) {
        if (type != null) {
            this.key = type.name();
            this.label = type.getLabel();
            this.value = type.name();
        }
    }
}
