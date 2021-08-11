package com.snszyk.iiot.marketization.market.domain.marketelement.valobj;

import lombok.*;

/**
 * 交易流程
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
public class TransactionFlow {

    /**
     * 流程ID
     */
    private String flowId;
}
