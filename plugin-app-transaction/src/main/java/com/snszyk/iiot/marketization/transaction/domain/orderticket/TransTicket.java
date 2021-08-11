package com.snszyk.iiot.marketization.transaction.domain.transticket;

import com.snszyk.iiot.marketization.transaction.domain.orderticket.valobj.TransTime;
import com.snszyk.iiot.marketization.transaction.domain.transticket.valobj.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 交易单
 *
 * @author tengwang
 * @version 1.0.0
 * @date 2021/8/3 11:25 上午
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "Z_TRANS_TICKET")
public class TransTicket {

    /**
     * 交易单编号
     */
    @EmbeddedId
    private TransTicketNum transTicketNum;

    /**
     * 交易时间
     */
    @Embedded
    private TransTime transTime;

    /**
     * 交易物
     */
    @Embedded
    private Trade trade;

    /**
     * 交易流程
     */
    @Embedded
    private TransFlow transFlow;

    /**
     * 交易发生地
     */
    @Embedded
    private TransLocation transLocation;

    /**
     * 交易调控
     */
    @Embedded
    private TransAdjust transAdjust;

    /**
     * 交易双方
     */
    @Embedded
    private TradeOrganization tradeOrganization;

    /**
     * 交易金额
     */
    @Embedded
    private TransAmount transAmount;

    /**
     * 所属订单号
     */
    @Embedded
    private OrderTicketNum orderTicketNum;
}
