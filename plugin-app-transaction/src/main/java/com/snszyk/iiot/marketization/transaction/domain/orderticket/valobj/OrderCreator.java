package com.snszyk.iiot.marketization.transaction.domain.orderticket.valobj;

import lombok.*;

import javax.persistence.Embeddable;

/**
 * 订单创建者
 *
 * @author tengwang
 * @version 1.0.0
 * @date 2021/8/3 11:11 上午
 */
@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@Embeddable
public class OrderCreator {

    /**
     * 创建人
     */
    private String createPersonId;

    /**
     * 创建部门
     */
    private String organizationId;
}
