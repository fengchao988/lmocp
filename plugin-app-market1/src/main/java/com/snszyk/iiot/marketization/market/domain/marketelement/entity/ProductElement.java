package com.snszyk.iiot.marketization.market.domain.marketelement.entity;

import com.snszyk.iiot.marketization.market.domain.marketelement.MarketElement;
import com.snszyk.iiot.marketization.market.domain.marketelement.valobj.MarketElementId;
import com.snszyk.iiot.marketization.market.domain.marketelement.valobj.ProductElementId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * 产品要素
 *
 * @author tengwang
 * @version 1.0.0
 * @date 2021/7/26 1:52 下午
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "PRODUCT_ELEMENT")
public class ProductElement {

    /**
     * 产品要素ID
     */
    @EmbeddedId
    private ProductElementId productElementId;

    /**
     * 产品要素名称
     */
    private String name;

    /**
     * 所属市场要素ID
     */
    @Embedded
    private MarketElementId marketElementId;


/*    @ManyToOne(cascade = CascadeType.ALL,optional = false,fetch = FetchType.LAZY)
    @JoinColumn(name = "market_element_id")
    private MarketElement marketElementId;*/

    /**
     * 方便添加 marketElement
     * @param marketElement
     */
    /*private void addMarketElement(MarketElement marketElement){
        this.marketElementId = marketElement;
    }*/
}
