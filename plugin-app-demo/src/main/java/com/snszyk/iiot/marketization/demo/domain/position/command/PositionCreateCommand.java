package com.snszyk.iiot.marketization.demo.domain.position.command;

import com.snszyk.iiot.marketization.demo.domain.position.entity.Position;
import com.snszyk.iiot.marketization.demo.domain.position.entity.PositionStateMachine;
import com.snszyk.iiot.marketization.demo.domain.position.event.PositionCreatedEvent;
import com.snszyk.iiot.marketization.demo.domain.position.valobj.PositionInfo;
import lombok.Data;

/**
 * 创建岗位命令对象
 *
 * @author tengwang
 * @version 1.0.0
 * @date 2021/7/12 9:25 上午
 */
@Data
public class PositionCreateCommand {

    /**
     * 岗位信息
     */
    private PositionInfo positionInfo;

    /**
     * 流转前模型状态
     */
    private Position original;

    /**
     * 流转后模型状态
     */
    private Position target;

    /**
     * 流转前生命周期
     */
    private static final PositionStateMachine originalState = PositionStateMachine.INITIALIZTION;

    /**
     * 流转后生命周期
     */
    private static final PositionStateMachine targetState = PositionStateMachine.NORMAL;

    /**
     * 完成事件
     */
    private PositionCreatedEvent event;
}
