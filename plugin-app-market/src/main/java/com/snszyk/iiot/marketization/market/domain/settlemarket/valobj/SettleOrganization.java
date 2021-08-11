package com.snszyk.iiot.marketization.market.domain.settlemarket.valobj;

import lombok.*;

import javax.persistence.Embeddable;

/**
 * 结算组织
 *
 * @author tengwang
 * @version 1.0.0
 * @date 2021/8/2 8:30 下午
 */
@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Embeddable
public class SettleOrganization {

    /**
     * 结算组织标识
     */
    private String organizationId;
}
