package com.snszyk.iiot.marketization.market.domain.product.valobj;

import lombok.*;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * 产品标识
 *
 * @author tengwang
 * @version 1.0.0
 * @date 2021/7/26 2:08 下午
 */
@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
@EqualsAndHashCode
@Embeddable
public class ProductId implements Serializable {

    /**
     * 结算市场ID
     */
    private String settleMarketId;
}
