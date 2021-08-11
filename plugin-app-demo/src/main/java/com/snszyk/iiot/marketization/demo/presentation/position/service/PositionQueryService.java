package com.snszyk.iiot.marketization.demo.presentation.position.service;

import com.snszyk.iiot.marketization.demo.presentation.position.model.PositionQuery;
import com.snszyk.iiot.marketization.demo.presentation.position.model.PositionQueryModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PositionQueryService {
    @Autowired
    private PositionQuery positionQuery;

    PositionQueryModel queryByName(PositionQueryModel position) {
        return positionQuery.findByName(position);
    }

    List<PositionQueryModel> queryList(PositionQueryModel position) {
        return positionQuery.findAllByNameLike(position);
    }
}
