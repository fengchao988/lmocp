package com.snszyk.iiot.marketization.market.domain.marketelement.valobj;

import lombok.*;

/**
 * 市场主体标识
 *
 * @author tengwang
 * @version 1.0.0
 * @date 2021/7/26 2:48 下午
 */
@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
@EqualsAndHashCode
public class MarketSubjectId {

    /**
     * 市场主体ID
     */
    private String marketSubjectId;
}
