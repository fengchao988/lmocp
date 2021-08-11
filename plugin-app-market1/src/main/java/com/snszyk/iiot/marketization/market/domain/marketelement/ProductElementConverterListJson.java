package com.snszyk.iiot.marketization.market.domain.marketelement;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.snszyk.iiot.marketization.market.domain.marketelement.entity.ProductElement;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.List;

@Converter(autoApply = true)
public class ProductElementConverterListJson implements AttributeConverter<List<ProductElement>, String> {

    @Override
    public String convertToDatabaseColumn(List<ProductElement> o) {
        return JSON.toJSONString(o);
    }

    @Override
    public List<ProductElement> convertToEntityAttribute(String s) {
        List<ProductElement> list = JSONObject.parseArray(JSON.parseArray(s).toJSONString(), ProductElement.class);
        return list;
    }
}
