package com.snszyk.iiot.marketization.market.domain.transmarket;

import com.snszyk.iiot.marketization.market.domain.transmarket.valobj.ContainedMarketElements;
import com.snszyk.iiot.marketization.market.domain.transmarket.valobj.TransMarketId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * 交易市场
 *
 * @author tengwang
 * @version 1.0.0
 * @date 2021/8/2 3:45 下午
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "Z_TRANSMARKET")
@Entity
public class TransMarket {

    /**
     * 交易市场标识
     */
    @EmbeddedId
    private TransMarketId transMarketId;

    /**
     * 交易市场名称
     */
    private String name;

    /**
     * 所含市场要素
     */
    @Convert(converter = ContainedMarketElementsConverter.class)
    @Column(columnDefinition="varchar(1000)")
    private ContainedMarketElements containedMarketElements;
}
