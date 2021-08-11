package com.snszyk.iiot.marketization.market.domain.product.valobj;

import lombok.*;

import javax.persistence.Embeddable;

/**
 * 产品规格
 *
 * @author tengwang
 * @version 1.0.0
 * @date 2021/8/3 10:13 上午
 */
@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Embeddable
@ToString
@EqualsAndHashCode
public class Specification {

    /**
     * 型号
     */
    private String model;

    /**
     * 规格描述
     */
    private String description;
}
