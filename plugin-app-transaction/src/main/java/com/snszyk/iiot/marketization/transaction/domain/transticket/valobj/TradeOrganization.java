package com.snszyk.iiot.marketization.transaction.domain.transticket.valobj;

import lombok.*;

import javax.persistence.*;

/**
 * 交易组织
 *
 * @author tengwang
 * @version 1.0.0
 * @date 2021/8/3 2:03 下午
 */
@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@Embeddable
public class TradeOrganization {

    /**
     * 买方
     */
    @Embedded
    @AttributeOverrides({@AttributeOverride(name="organizationId", column=@Column(name = "buyer_organization_id"))})
    private TransOrganization buyer;

    /**
     * 卖方
     */
    @Embedded
    @AttributeOverrides({@AttributeOverride(name="organizationId", column=@Column(name = "seller_organization_id"))})
    private TransOrganization seller;

}
