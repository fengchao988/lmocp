package com.snszyk.iiot.marketization.market.domain.marketelement.repo;

import com.snszyk.iiot.marketization.market.domain.marketelement.MarketElement;
import com.snszyk.iiot.marketization.market.domain.marketelement.valobj.MarketElementId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarketElementRepo extends JpaRepository<MarketElement, MarketElementId> {
}
