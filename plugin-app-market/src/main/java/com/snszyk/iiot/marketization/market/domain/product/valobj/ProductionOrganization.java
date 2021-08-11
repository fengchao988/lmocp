package com.snszyk.iiot.marketization.market.domain.product.valobj;

import lombok.*;

import javax.persistence.Embeddable;

/**
 * 产品生产组织
 *
 * @author tengwang
 * @version 1.0.0
 * @date 2021/8/3 10:45 上午
 */
@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
@EqualsAndHashCode
@Embeddable
public class ProductionOrganization {

    /**
     * 组织机构Id
     */
    private String organizationId;
}
