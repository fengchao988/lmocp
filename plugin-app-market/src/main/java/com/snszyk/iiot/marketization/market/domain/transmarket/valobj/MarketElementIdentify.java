package com.snszyk.iiot.marketization.market.domain.transmarket.valobj;

import lombok.*;

/**
 * 市场要素标识
 *
 * @author tengwang
 * @version 1.0.0
 * @date 2021/7/26 2:08 下午
 */
@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
@EqualsAndHashCode
public class MarketElementIdentify {

    /**
     * 市场要素ID
     */
    private String marketElementId;
}
