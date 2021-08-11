package com.snszyk.iiot.marketization.demo.domain.position.repository;

import com.snszyk.iiot.marketization.demo.domain.position.command.PositionCreateCommand;
import com.snszyk.iiot.marketization.demo.domain.position.entity.Position;
import com.snszyk.iiot.marketization.demo.domain.position.valobj.PositionId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

/**
 * TODO
 *
 * @author tengwang
 * @version 1.0.0
 * @date 2021/7/12 4:38 下午
 */
public interface PositionRepository {

    void clone(PositionCreateCommand command);

    Position fromId(PositionId positionId);

    void remove(Position position);

    void save(Position position);

    void saveAll(List<Position> list);

    Page<Position> findAll(Pageable pageable);

    Page findAll(Specification specification, Pageable pageable);

}
