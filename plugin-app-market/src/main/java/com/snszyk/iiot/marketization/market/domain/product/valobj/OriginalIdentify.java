package com.snszyk.iiot.marketization.market.domain.product.valobj;

import lombok.*;

import javax.persistence.Embeddable;

/**
 * 原始标识
 *
 * @author tengwang
 * @version 1.0.0
 * @date 2021/8/3 10:12 上午
 */
@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
@EqualsAndHashCode
@Embeddable
public class OriginalIdentify {

    /**
     * 原始物品Id
     */
    private String originalId;
}
