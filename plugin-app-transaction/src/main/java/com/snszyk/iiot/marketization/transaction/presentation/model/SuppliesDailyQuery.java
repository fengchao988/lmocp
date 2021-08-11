package com.snszyk.iiot.marketization.transaction.presentation.model;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;


@Repository
public interface SuppliesDailyQuery extends PagingAndSortingRepository<SuppliesDailyQueryModel, String>, JpaSpecificationExecutor<SuppliesDailyQueryModel> {

    Page<SuppliesDailyQueryModel> findAll(Specification<SuppliesDailyQueryModel> specification, Pageable pageable);

    Page<SuppliesDailyQueryModel> findAllByStatus(Pageable pageable, String status);

    Page<SuppliesDailyQueryModel> findAllByBusinessDateBetween(Pageable pageable, Date start, Date end);

    Page<SuppliesDailyQueryModel> findAllByBusinessDateBetweenAndStatus(Pageable pageable, Date start, Date end, String status);
}
