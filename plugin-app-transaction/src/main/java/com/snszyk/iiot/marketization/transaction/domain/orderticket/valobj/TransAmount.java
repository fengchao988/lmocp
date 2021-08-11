package com.snszyk.iiot.marketization.transaction.domain.orderticket.valobj;

import lombok.*;

import javax.persistence.Embeddable;

import lombok.*;

import javax.persistence.Embeddable;

/**
 * 交易金额
 *
 * @author tengwang
 * @version 1.0.0
 * @date 2021/8/3 2:12 下午
 */
@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@Embeddable
public class TransAmount {

    /**
     * 单价
     */
    private Double unitPrice;

    /**
     * 交易数量
     */
    private Double count;

    /**
     * 交易总价
     */
    private Double sumPrice;
}
