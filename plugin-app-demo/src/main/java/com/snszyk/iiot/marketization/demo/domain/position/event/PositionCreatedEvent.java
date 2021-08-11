package com.snszyk.iiot.marketization.demo.domain.position.event;

import com.snszyk.iiot.marketization.demo.domain.position.entity.Position;
import com.snszyk.iiot.marketization.demo.domain.position.valobj.PositionInfo;
import lombok.Data;
import org.jeecg.common.util.UUIDGenerator;

/**
 * 岗位创建完成事件
 *
 * @author tengwang
 * @version 1.0.0
 * @date 2021/7/13 3:21 下午
 */
@Data
public class PositionCreatedEvent {

    /**
     * 事件标识
     */
    private static final String identify = UUIDGenerator.generate();

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
     * 事件发生时间
     */
    private static final Long occurredOn = System.currentTimeMillis();
}
