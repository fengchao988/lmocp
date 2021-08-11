package com.snszyk.iiot.marketization.demo.infrastructure.persistence.aggr.jpa;

import com.snszyk.iiot.marketization.demo.infrastructure.persistence.aggr.PositionPO;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * TODO
 *
 * @author tengwang
 * @version 1.0.0
 * @date 2021/7/12 4:40 下午
 */
@Repository
public interface PositionRepo extends JpaRepository<PositionPO, String>, JpaSpecificationExecutor {

     @Override
     <S extends PositionPO> List<S> saveAll(Iterable<S> iterable);

     @Override
     Page<PositionPO> findAll(Pageable pageable);

     @Override
     <S extends PositionPO> Page<S> findAll(Example<S> example, Pageable pageable);

     @Override
     Page findAll(Specification specification, Pageable pageable);

}
