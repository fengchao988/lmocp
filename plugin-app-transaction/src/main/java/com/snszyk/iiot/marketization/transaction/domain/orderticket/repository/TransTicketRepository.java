package com.snszyk.iiot.marketization.transaction.domain.transticket.repository;

import com.snszyk.iiot.marketization.transaction.domain.transticket.TransTicket;
import com.snszyk.iiot.marketization.transaction.domain.transticket.valobj.TransTicketNum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransTicketRepository extends JpaRepository<TransTicket, TransTicketNum> {

}
