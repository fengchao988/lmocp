package com.snszyk.iiot.marketization.market.domain.marketelement;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.snszyk.iiot.marketization.market.domain.marketelement.entity.ProductElement;
import com.snszyk.iiot.marketization.market.domain.marketelement.valobj.TransactionScope;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.List;

@Converter(autoApply = true)
public class TransactionScopeConverterListJson implements AttributeConverter<List<TransactionScope>, String> {

    @Override
    public String convertToDatabaseColumn(List<TransactionScope> o) {
        String mes = JSON.toJSONString(o);
        return JSON.toJSONString(o);
    }

    @Override
    public List<TransactionScope> convertToEntityAttribute(String s) {
        Gson gson = new Gson();
        return gson.fromJson(s, new TypeToken<List<TransactionScope>>() {}.getType());
    }
}
