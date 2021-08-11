package com.snszyk.iiot.marketization.market.domain.marketelement.command;

import com.snszyk.iiot.marketization.market.domain.marketelement.MarketElement;
import com.snszyk.iiot.marketization.market.domain.marketelement.MarketElementStateMachine;
import com.snszyk.iiot.marketization.market.domain.marketelement.event.MarketElementImportedEvent;
import lombok.Data;

import java.util.List;

/**
 * 市场要素导入命令
 *
 * @author tengwang
 * @version 1.0.0
 * @date 2021/7/26 2:53 下午
 */
@Data
public class MarketElementImportCommand {
    /**
     * 岗位信息
     */
    private List<MarketElement> stayImportElements;

    /**
     * 流转前模型状态
     */
    private List<MarketElement> original;

    /**
     * 流转后模型状态
     */
    private List<MarketElement> target;

    /**
     * 流转前生命周期
     */
    private static final MarketElementStateMachine originalState = MarketElementStateMachine.INITIAL;

    /**
     * 流转后生命周期
     */
    private static final MarketElementStateMachine targetState = MarketElementStateMachine.NORMAL;

    /**
     * 完成事件
     */
    private MarketElementImportedEvent event;
}
