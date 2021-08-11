package com.snszyk.iiot.marketization.market.domain.marketelement.valobj;

import lombok.*;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * 产品要素标识
 *
 * @author tengwang
 * @version 1.0.0
 * @date 2021/7/26 2:15 下午
 */
@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Embeddable
public class ProductElementId implements Serializable {

    /**
     * 产品要素ID
     */
    private String productElementId;
}
