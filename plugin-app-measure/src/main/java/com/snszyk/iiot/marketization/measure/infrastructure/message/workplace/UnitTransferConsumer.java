package com.snszyk.iiot.marketization.measure.infrastructure.message.workplace;

import io.ttyys.micrc.annotations.technology.LocalTransferConsumer;

import java.util.Map;
import java.util.Set;

@LocalTransferConsumer(endpoint = "unit", adapterClassName = "unitTransferConsumerImpl")
public interface UnitTransferConsumer {
    UnitDto getById(String id);

    Map<String, UnitDto> getMapByIdSet(Set<String> idSet);
//    List<MeasureUnitView> getMeasureUnitByIds(Set<String> ids);
}
