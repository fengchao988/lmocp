package com.snszyk.iiot.marketization.transaction.domain.transticket.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 定价项
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "T_PRICED_ITEM")
public class PricedItem implements Serializable {
    @Id
    private String id;

    private String pricedItemName;

    private String unitId;

    private BigDecimal price;

    private String pricedItemsId;
}
