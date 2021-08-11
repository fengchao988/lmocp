package com.snszyk.iiot.marketization.transaction.presentation.model;

import org.jeecg.common.system.base.dto.ResponsePage;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SuppliesDailyQueryModelMapping {

    SuppliesDailyQueryModel toData(SuppliesDailyQueryModel model);

    List<SuppliesDailyQueryModel> toData(List<SuppliesDailyQueryModel> model);

    ResponsePage<SuppliesDailyQueryModel> toData(ResponsePage<SuppliesDailyQueryModel> model);
}
