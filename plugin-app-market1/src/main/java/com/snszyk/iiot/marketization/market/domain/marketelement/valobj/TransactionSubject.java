package com.snszyk.iiot.marketization.market.domain.marketelement.valobj;

import lombok.*;

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
    private MarketSubjectId buyerTypeId;

    /**
     * 卖方主体类型
     */
    private MarketSubjectId sellerTypeId;
}
