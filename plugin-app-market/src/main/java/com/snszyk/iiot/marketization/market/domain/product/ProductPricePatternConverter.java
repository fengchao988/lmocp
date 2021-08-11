package com.snszyk.iiot.marketization.market.domain.product;

import com.snszyk.iiot.marketization.market.domain.product.valobj.PriceItem;
import com.snszyk.iiot.marketization.market.domain.product.valobj.ProductPricePattern;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;


@Converter(autoApply = true)
public class ProductPricePatternConverter implements AttributeConverter<ProductPricePattern, String> {

    @Override
    public String convertToDatabaseColumn(ProductPricePattern productPricePattern) {
        return productPricePattern.getName();
    }

    @Override
    public ProductPricePattern convertToEntityAttribute(String s) {
        return ProductPricePattern.valueOf(s);
    }
}
