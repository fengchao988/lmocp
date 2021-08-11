package com.snszyk.iiot.marketization.market.domain.product.valobj;

import lombok.*;

import javax.persistence.Embeddable;

/**
 * 所属产品要素
 *
 * @author tengwang
 * @version 1.0.0
 * @date 2021/8/3 10:51 上午
 */
@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
@EqualsAndHashCode
@Embeddable
public class UnderProductElement {

    /**
     * 产品要素id
     */
    private String productElementId;
}
