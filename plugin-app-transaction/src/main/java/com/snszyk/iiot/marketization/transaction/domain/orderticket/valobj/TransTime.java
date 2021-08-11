package com.snszyk.iiot.marketization.transaction.domain.orderticket.valobj;

import lombok.*;

import javax.persistence.Embeddable;

/**
 * 交易时间
 *
 * @author tengwang
 * @version 1.0.0
 * @date 2021/8/3 11:10 上午
 */
@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@Embeddable
public class TransTime {

    /**
     * 交易时间
     */
    private Long transTime;
}
