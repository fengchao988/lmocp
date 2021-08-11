package com.snszyk.iiot.marketization.transaction.domain.transticket.entity;


import com.snszyk.iiot.marketization.transaction.domain.transticket.enums.PricingMarketEmum;
import com.snszyk.iiot.marketization.transaction.domain.transticket.enums.PricingRangeEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 定价类目
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "T_PRICING_CATEGORY")
public class PricingCategory implements Serializable {

    @Id
    private String id;
    private String categoryName;
    @Enumerated(EnumType.STRING)
    private PricingRangeEnum pricingRange;
    @Enumerated(EnumType.STRING)
    private PricingMarketEmum pricingMarket;

}
