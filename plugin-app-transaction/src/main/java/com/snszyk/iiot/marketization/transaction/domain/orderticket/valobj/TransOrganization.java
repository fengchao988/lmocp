package com.snszyk.iiot.marketization.transaction.domain.orderticket.valobj;

import lombok.*;

import javax.persistence.Embeddable;

/**
 * 交易组织
 *
 * @author tengwang
 * @version 1.0.0
 * @date 2021/8/3 2:09 下午
 */
@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@Embeddable
public class TransOrganization {

    /**
     * 交易组织Id
     */
    private String organizationId;
}
