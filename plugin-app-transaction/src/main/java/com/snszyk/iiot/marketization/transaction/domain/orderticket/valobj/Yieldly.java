package com.snszyk.iiot.marketization.transaction.domain.orderticket.valobj;

import lombok.*;

import javax.persistence.Embeddable;

/**
 * 生产地点
 *
 * @author tengwang
 * @version 1.0.0
 * @date 2021/8/3 10:19 上午
 */
@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
@EqualsAndHashCode
@Embeddable
public class Yieldly {

    /**
     * 工作地点id
     */
    private String workplaceId;
}
