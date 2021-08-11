package com.snszyk.iiot.marketization.demo.presentation.person.service;

import com.snszyk.iiot.marketization.demo.presentation.person.model.PersonQuery;
import com.snszyk.iiot.marketization.demo.presentation.person.model.PersonQueryModel;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PersonQueryService {
    @Autowired
    private PersonQuery positionQuery;

    PersonQueryModel queryByName(PersonQueryModel position) {
        return positionQuery.findByName(position);
    }

    List<PersonQueryModel> queryList(PersonQueryModel position) {
        if (StringUtils.isBlank(position.getName())) {
            return positionQuery.findAll();
        } else {
            return positionQuery.findAllByNameLike(position.getName());
        }
    }
}
