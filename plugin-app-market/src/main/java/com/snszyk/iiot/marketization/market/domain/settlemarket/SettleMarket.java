package com.snszyk.iiot.marketization.market.domain.settlemarket;

import com.snszyk.iiot.marketization.market.domain.settlemarket.valobj.SettleMarketId;
import com.snszyk.iiot.marketization.market.domain.settlemarket.valobj.SettleOrganization;
import com.snszyk.iiot.marketization.market.domain.transmarket.ContainedMarketElementsConverter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 结算市场
 *
 * @author tengwang
 * @version 1.0.0
 * @date 2021/8/2 3:44 下午
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "Z_SETTLEMARKET")
public class SettleMarket implements Serializable {

    /**
     * 结算市场标识
     */
    @EmbeddedId
    private SettleMarketId settleMarketId;

    /**
     * 结算市场名称
     */
    private String name;

    /**
     * 结算组织
     */
    @Embedded
    private SettleOrganization settleOrganization;
}
