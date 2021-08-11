package com.snszyk.iiot.marketization.market.domain.marketelement;

import com.snszyk.iiot.marketization.market.domain.marketelement.entity.ProductElement;
import com.snszyk.iiot.marketization.market.domain.marketelement.valobj.MarketElementId;
import com.snszyk.iiot.marketization.market.domain.marketelement.valobj.TransactionScope;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * 市场要素
 *
 * @author tengwang
 * @version 1.0.0
 * @date 2021/7/26 1:48 下午
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "Z_MARKET_ELEMENT")
public class MarketElement implements Serializable {

    /**
     * 标识
     */
    @EmbeddedId
    private MarketElementId marketElementId;

    private String marketElementName;

    /**
     * 产品要素
     */
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<ProductElement> productElements;

    /**
     * 市场要素
     */
    @Convert(converter = TransactionScopeConverterListJson.class)
    @Column(columnDefinition="varchar(1000)")
    private List<TransactionScope> transactionScopes;

}
