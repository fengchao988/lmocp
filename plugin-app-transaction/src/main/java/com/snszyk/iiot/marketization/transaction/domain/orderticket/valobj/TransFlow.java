package com.snszyk.iiot.marketization.transaction.domain.orderticket.valobj;

import lombok.*;

import javax.persistence.Embeddable;

import lombok.*;

import javax.persistence.Embeddable;

/**
 * 交易流程
 *
 * @author tengwang
 * @version 1.0.0
 * @date 2021/8/3 1:54 下午
 */
@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@Embeddable
public class TransFlow {

    /**
     * 流程id
     */
    private String flowId;

    /**
     * 流程实例id
     */
    private String flowInstanceId;
}
