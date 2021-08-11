package com.snszyk.iiot.marketization.market.domain.transmarket;

import com.alibaba.fastjson.JSON;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.snszyk.iiot.marketization.market.domain.marketelement.valobj.TransactionScope;
import com.snszyk.iiot.marketization.market.domain.settlemarket.valobj.SettleOrganization;
import com.snszyk.iiot.marketization.market.domain.transmarket.valobj.ContainedMarketElements;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.List;

@Converter(autoApply = true)
public class ContainedMarketElementsConverter implements AttributeConverter<ContainedMarketElements, String> {

    @Override
    public String convertToDatabaseColumn(ContainedMarketElements o) {
        return JSON.toJSONString(o);
    }

    @Override
    public ContainedMarketElements convertToEntityAttribute(String s) {
        Gson gson = new Gson();
        return gson.fromJson(s, new TypeToken<ContainedMarketElements>() {}.getType());
    }
}
