package com.snszyk.iiot.marketization.transaction.domain.transticket.entity;

import com.snszyk.iiot.marketization.transaction.domain.transticket.enums.PricingMarketEmum;
import com.snszyk.iiot.marketization.transaction.domain.transticket.enums.PricingRangeEnum;
import com.snszyk.iiot.marketization.transaction.domain.transticket.enums.PricingStatusEnum;
import com.snszyk.iiot.marketization.transaction.domain.transticket.enums.PricingTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 定价物
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "T_PRICED_ITEMS")
public class PricedItems implements Serializable {

    @Id
    private String id;

    //产品要素Id
    private String productElementId;
    //产品要素Name
    private String productElementName;
    //规格描述
    private String SpecificationDescription;
    //计量单位
    private String unitId;
    //单价
    private BigDecimal price;
    //定价状态
    @Enumerated(EnumType.STRING)
    private PricingStatusEnum pricingStatus;
    //所属类目
    private String pricingCategoryId;
    //定价人
    private String pricedUserId;
    //定价组织
    private String pricedOrgId;
    //备注
    private String pricedNote;
    //定价范围
    @Enumerated(EnumType.STRING)
    private PricingRangeEnum pricingRange;
    @Enumerated(EnumType.STRING)
    private PricingTypeEnum pricingType;
    @Enumerated(EnumType.STRING)
    private PricingMarketEmum pricingMarket;
}
