package com.snszyk.iiot.marketization.market.domain.product;

import com.snszyk.iiot.marketization.market.domain.product.valobj.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 产品
 *
 * @author tengwang
 * @version 1.0.0
 * @date 2021/8/2 8:41 下午
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "Z_PRODUCT")
public class Product {

    /**
     * 规格型号
     */
    @EmbeddedId
    private ProductId productId;

    /**
     * 产品明细
     */
    @Embedded
    private ProductDetail productDetail;

    /**
     * 生产地点
     */
    @Embedded
    private Yieldly yieldly;

    /**
     * 定额
     */
    @Embedded
    private Quota quota;

    /**
     * 产品定价
     */
    @Embedded
    private Price price;

    /**
     * 产品生产组织
     */
    @Embedded
    private ProductionOrganization productionOrganization;

    /**
     * 所属市场
     */
    @Embedded
    private UnderMarket underMarket;

    /**
     * 所属产品要素
     */
    @Embedded
    private UnderProductElement underProductElement;
}
