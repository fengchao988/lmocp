package com.snszyk.iiot.marketization.transaction.domain.transticket.entity;

import com.snszyk.iiot.marketization.transaction.domain.transticket.enums.OperationalBehaviorEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 定价变更记录
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "T_PRICE_UPDATE_RECORD")
public class PriceUpdateRecord implements Serializable {

    @Id
    private String id;

    private Long operateTime;

    @Enumerated(EnumType.STRING)
    private OperationalBehaviorEnum operationalBehavior;

    private String beforeObj;

    private String afterObj;

    private String operateUserId;
}

