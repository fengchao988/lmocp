package com.snszyk.iiot.marketization.market.domain.marketelement.valobj;

import com.snszyk.iiot.marketization.market.domain.marketelement.entity.ProductElement;
import lombok.*;

import javax.persistence.Entity;

/**
 * 交易范围
 *
 * @author tengwang
 * @version 1.0.0
 * @date 2021/7/26 1:54 下午
 */
@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class TransactionScope {

    /**
     * 交易范围名称
     */
    private String scopeName;

    /**
     * 交易流程
     */
    private TransactionFlow transactionFlow;

    /**
     * 交易主体
     */
    private TransactionSubject transactionSubject;

    /**
     * 产品要素
     */
    private ProductElementId productElementId;
}
