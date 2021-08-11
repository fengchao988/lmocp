package com.snszyk.iiot.marketization.transaction.domain.transticket.valobj;

import lombok.*;

import javax.persistence.Embeddable;
import java.util.List;

/**
 * 产品定价
 *
 * @author tengwang
 * @version 1.0.0
 * @date 2021/8/3 10:32 上午
 */
@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Embeddable
public class Price {

    /**
     * 定价值
     */
    private Double priceValue;

    /**
     * 定价单位id
     */
    private String priceUnitId;
}
