package com.snszyk.iiot.marketization.transaction.domain.orderticket;

import com.snszyk.iiot.marketization.transaction.domain.orderticket.valobj.OrderCreator;
import com.snszyk.iiot.marketization.transaction.domain.orderticket.valobj.OrderTicketNum;
import com.snszyk.iiot.marketization.transaction.domain.orderticket.valobj.TransTime;
import lombok.Data;

/**
 * 交易订单
 *
 * @author tengwang
 * @version 1.0.0
 * @date 2021/8/3 11:04 上午
 */
@Data
public class OrderTicket {

    /**
     * 订单编号
     */
    private OrderTicketNum orderTicketNum;

    /**
     * 下订单时间
     */
    private TransTime transTime;

    /**
     * 订单创建者
     */
    private OrderCreator orderCreator;
}
