package com.snszyk.iiot.marketization.transaction.domain.orderticket.command;

import com.snszyk.iiot.marketization.transaction.domain.orderticket.OrderTicket;
import com.snszyk.iiot.marketization.transaction.domain.orderticket.OrderTicketStateMachine;
import com.snszyk.iiot.marketization.transaction.domain.orderticket.valobj.*;
import lombok.Data;

/**
 * 订单创建命令
 *
 * @author tengwang
 * @version 1.0.0
 * @date 2021/8/3 7:27 下午
 */
@Data
public class OrderTicketCreateCommand {

    /**
     * 分配方式
     */
    private DistributionMode distributionMode;

    /**
     * 劳动班次
     */
    private WorkingShift workingShift;

    /**
     * 订单创建人
     */
    private OrderCreator orderCreator;

    /**
     * 业务期间
     */
    private TransTime transTime;

    /**
     * 出勤情况
     */
    private Attendance attendance;

    /**
     * 跟班队长
     */
    private AccompanyMonitor accompanyMonitor;

    /**
     * 工作地点
     */
    private Yieldly yieldly;

    /**
     * 流转前模型状态
     */
    private OrderTicket original;

    /**
     * 流转后模型状态
     */
    private OrderTicket target;

    /**
     * 流转前生命周期
     */
    private static final OrderTicketStateMachine originalState = OrderTicketStateMachine.INITIAL;

    /**
     * 流转后生命周期
     */
    private static final OrderTicketStateMachine targetState = OrderTicketStateMachine.CREATED;
}
