package com.snszyk.iiot.marketization.market.domain.settlemarket.repository;

import com.snszyk.iiot.marketization.market.domain.settlemarket.SettleMarket;
import com.snszyk.iiot.marketization.market.domain.settlemarket.valobj.SettleMarketId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SettleMarketRepository extends JpaRepository<SettleMarket, SettleMarketId> {
}
