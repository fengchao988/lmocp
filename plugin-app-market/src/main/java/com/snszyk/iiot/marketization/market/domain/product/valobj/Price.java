package com.snszyk.iiot.marketization.market.domain.product.valobj;

import com.snszyk.iiot.marketization.market.domain.product.PriceItemConverter;
import com.snszyk.iiot.marketization.market.domain.product.ProductPricePatternConverter;
import com.snszyk.iiot.marketization.market.domain.transmarket.ContainedMarketElementsConverter;
import lombok.*;

import javax.persistence.Convert;
import javax.persistence.Converter;
import javax.persistence.Embeddable;
import java.math.BigDecimal;
import java.util.List;

/**
 * 产品定价
 *
 * @author tengwang
 * @version 1.0.0
 * @date 2021/8/3 10:32 上午
 */
@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
@EqualsAndHashCode
@Embeddable
public class Price {

    /**
     * 定价值
     */
    private BigDecimal priceValue;

    /**
     * 定价单位id
     */
    private String priceUnitId;

    /**
     * 定价项
     */
    @Convert(converter = PriceItemConverter.class)
    private List<PriceItem> priceItems;

    /**
     * 定价模式
     */
    @Convert(converter = ProductPricePatternConverter.class)
    private ProductPricePattern productPricePattern;
}
