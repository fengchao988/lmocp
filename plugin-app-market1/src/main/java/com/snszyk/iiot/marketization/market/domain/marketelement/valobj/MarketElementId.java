package com.snszyk.iiot.marketization.market.domain.marketelement.valobj;

import lombok.*;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * 市场要素标识
 *
 * @author tengwang
 * @version 1.0.0
 * @date 2021/7/26 2:08 下午
 */
@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@Embeddable
public class MarketElementId implements Serializable {

    /**
     * 市场要素ID
     */
    private String marketElementId;
}
