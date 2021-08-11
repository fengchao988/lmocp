package com.snszyk.iiot.marketization.market.domain.settlemarket.valobj;

import lombok.*;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * 结算市场标识
 *
 * @author tengwang
 * @version 1.0.0
 * @date 2021/7/26 2:08 下午
 */
@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Embeddable
public class SettleMarketId implements Serializable {

    /**
     * 结算市场ID
     */
    private String settleMarketId;
}
