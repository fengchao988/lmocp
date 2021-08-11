package com.snszyk.iiot.marketization.market.domain.marketelement.event;

import com.snszyk.iiot.marketization.market.domain.marketelement.MarketElementStateMachine;
import lombok.*;

/**
 * 市场要素导入
 *
 * @author tengwang
 * @version 1.0.0
 * @date 2021/7/26 3:02 下午
 */
@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
@EqualsAndHashCode
public class MarketElementImportedEvent {

    /**
     * 事件标识
     */
    private static final String identify = System.currentTimeMillis()+"";

    /**
     * 负载
     */
    private Object payload;

    /**
     * 流转前生命周期
     */
    private static final MarketElementStateMachine originalState = MarketElementStateMachine.INITIAL;

    /**
     * 流转后生命周期
     */
    private static final MarketElementStateMachine targetState = MarketElementStateMachine.NORMAL;

    /**
     * 事件发生时间
     */
    private static final Long occurredOn = System.currentTimeMillis();
}
