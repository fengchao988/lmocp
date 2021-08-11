package com.snszyk.iiot.marketization.market.domain.product.valobj;

import lombok.*;

import javax.persistence.Embeddable;

/**
 * 所属市场
 *
 * @author tengwang
 * @version 1.0.0
 * @date 2021/8/3 10:47 上午
 */
@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
@EqualsAndHashCode
@Embeddable
public class UnderMarket {

    /**
     * 交易市场Id
     */
    private String transMarketId;
}
