package com.snszyk.iiot.marketization.market.domain.product;

import com.alibaba.fastjson.JSON;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.snszyk.iiot.marketization.market.domain.product.valobj.PriceItem;
import com.snszyk.iiot.marketization.market.domain.transmarket.valobj.ContainedMarketElements;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.List;

@Converter(autoApply = true)
public class PriceItemConverter implements AttributeConverter<List<PriceItem>, String> {

    @Override
    public String convertToDatabaseColumn(List<PriceItem> o) {
        return JSON.toJSONString(o);
    }

    @Override
    public List<PriceItem> convertToEntityAttribute(String s) {
        Gson gson = new Gson();
        return gson.fromJson(s, new TypeToken<List<PriceItem>>() {}.getType());
    }
}
