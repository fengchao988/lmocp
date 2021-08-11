package com.snszyk.iiot.marketization.transaction.domain.orderticket.valobj;

import lombok.*;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;

import lombok.*;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;

/**
 * 交易物
 *
 * @author tengwang
 * @version 1.0.0
 * @date 2021/8/3 1:55 下午
 */
@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@Embeddable
public class Trade {

    /**
     * 产品标识
     */
    @Embedded
    private ProductIdentify productIdentify;

    /**
     * 产品名称
     */
    private String productName;

    /**
     * 产品价格
     */
    @Embedded
    private Price price;

    /**
     * 产品定额
     */
    @Embedded
    private Quota quota;

    /**
     * 产品规格
     */
    @Embedded
    private Specification specification;
}
