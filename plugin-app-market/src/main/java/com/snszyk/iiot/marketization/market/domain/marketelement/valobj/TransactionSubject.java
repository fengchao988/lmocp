package com.snszyk.iiot.marketization.market.domain.marketelement.valobj;

import lombok.*;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

/**
 * 交易主体
 *
 * @author tengwang
 * @version 1.0.0
 * @date 2021/7/26 1:54 下午
 */
@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
@EqualsAndHashCode
public class TransactionSubject {

    /**
     * 买方主体类型
     */
    @Enumerated(EnumType.STRING)
    private MarketSubjectType buyerType;

    /**
     * 卖方主体类型
     */
    @Enumerated(EnumType.STRING)
    private MarketSubjectType sellerType;
}
