package com.snszyk.iiot.marketization.market.domain.transmarket.valobj;

import lombok.*;

import java.util.List;

/**
 * 所含要素
 *
 * @author tengwang
 * @version 1.0.0
 * @date 2021/8/2 3:48 下午
 */
@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
@EqualsAndHashCode
public class ContainedMarketElements {
    private List<MarketElementIdentify> marketElementsIdentifies;
}
