package com.snszyk.iiot.marketization.market.domain.transmarket.repository;

import com.snszyk.iiot.marketization.market.domain.transmarket.TransMarket;
import com.snszyk.iiot.marketization.market.domain.transmarket.valobj.TransMarketId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * add by fengc
 */
@Repository
public interface TransMarketRepository extends JpaRepository<TransMarket, TransMarketId> {

}
