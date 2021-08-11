package com.snszyk.iiot.marketization.market.domain.product.valobj;

import lombok.*;

/**
 * 定价项
 *
 * @author tengwang
 * @version 1.0.0
 * @date 2021/8/3 10:36 上午
 */
@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
@EqualsAndHashCode
public class PriceItem {

    /**
     * 定价项名称
     */
    private String name;

    /**
     * 定价价格
     */
    private Double price;

    /**
     * 定价单位id
     */
    private String unitId;
}
