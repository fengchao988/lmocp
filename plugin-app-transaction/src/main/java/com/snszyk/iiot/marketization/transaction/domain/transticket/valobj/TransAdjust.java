package com.snszyk.iiot.marketization.transaction.domain.transticket.valobj;

import lombok.*;

import javax.persistence.Embeddable;

/**
 * 交易调控
 *
 * @author tengwang
 * @version 1.0.0
 * @date 2021/8/3 2:01 下午
 */
@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@Embeddable
public class TransAdjust {

    /**
     * 调整系数
     */
    private Double adjustCoefficient;
}
