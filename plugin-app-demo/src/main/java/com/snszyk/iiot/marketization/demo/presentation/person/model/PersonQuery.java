package com.snszyk.iiot.marketization.demo.presentation.person.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author zhaowang
 * @version 1.0.0
 * @since 2021/7/16 16:32
 */
@Repository
public interface PersonQuery extends JpaRepository<PersonQueryModel, String> {

    PersonQueryModel findByName(PersonQueryModel model);

    List<PersonQueryModel> findAllByNameLike(String name);

    List<PersonQueryModel> findAllByPositionId(String positionId);
}
