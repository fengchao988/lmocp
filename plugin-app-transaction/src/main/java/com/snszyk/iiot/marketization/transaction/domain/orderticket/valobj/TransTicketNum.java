package com.snszyk.iiot.marketization.transaction.domain.orderticket.valobj;

import lombok.*;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * 订单编号
 *
 * @author tengwang
 * @version 1.0.0
 * @date 2021/8/3 11:08 上午
 */
@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@Embeddable
public class TransTicketNum implements Serializable {

    /**
     * 订单编号
     */
    private String transTicketNum;
}
