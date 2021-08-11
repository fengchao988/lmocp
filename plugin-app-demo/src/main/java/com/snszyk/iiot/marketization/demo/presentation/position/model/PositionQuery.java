package com.snszyk.iiot.marketization.demo.presentation.position.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *
 * @author zhaowang
 * @version 1.0.0
 * @since  2021/7/16 16:32
 */
@Repository
public interface PositionQuery extends JpaRepository<PositionQueryModel, String> {

    PositionQueryModel findByName(PositionQueryModel model);

    List<PositionQueryModel> findAllByNameLike(PositionQueryModel model);
}
