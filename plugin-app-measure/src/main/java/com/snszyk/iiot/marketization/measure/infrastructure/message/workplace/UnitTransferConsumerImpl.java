package com.snszyk.iiot.marketization.measure.infrastructure.message.workplace;

import com.snszyk.iiot.marketization.measure.application.unit.MeasureUnitService;
import com.snszyk.iiot.marketization.measure.domain.unitView.MeasureUnitView;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class UnitTransferConsumerImpl implements UnitTransferConsumer {
    @Resource
    private MeasureUnitService measureUnitService;

    public UnitDto getById(String id) {
        return new UnitDto(measureUnitService.getMeasureUnitById(id));
    }

    @Override
    public Map<String, UnitDto> getMapByIdSet(Set<String> idSet) {
        return measureUnitService.getMeasureUnitByIds(idSet)
                .stream().collect(Collectors.toMap(MeasureUnitView::getId, UnitDto::new));
    }
}
