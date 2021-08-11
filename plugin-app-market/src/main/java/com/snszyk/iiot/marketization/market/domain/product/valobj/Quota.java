package com.snszyk.iiot.marketization.market.domain.product.valobj;

import lombok.*;

import javax.persistence.Embeddable;
import java.math.BigDecimal;

/**
 * 产品定额
 *
 * @author tengwang
 * @version 1.0.0
 * @date 2021/8/3 10:32 上午
 */
@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
@EqualsAndHashCode
@Embeddable
public class Quota {

    /**
     * 定额值
     */
    private BigDecimal quotaValue;

    /**
     * 定额单位id
     */
    private String quotaUnitId;
}
