package com.snszyk.iiot.marketization.market.domain.product.valobj;

import lombok.*;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;

/**
 * 产品明细
 *
 * @author tengwang
 * @version 1.0.0
 * @date 2021/8/3 10:11 上午
 */
@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
@EqualsAndHashCode
@Embeddable
public class ProductDetail {

    /**
     * 产品原始标识
     */
    @Embedded
    private OriginalIdentify originalIdentify;

    /**
     * 产品名称
     */
    private String name;

    /**
     * 产品规格
     */
    @Embedded
    private Specification specification;
}
