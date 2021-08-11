package com.snszyk.iiot.marketization.demo.presentation.position.model;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PositionQueryMapping {
    public static final PositionQueryMapping INSTANCES = Mappers.getMapper(PositionQueryMapping.class);

    PositionQueryModel toData(PositionQueryModel position);

    List<PositionQueryModel> toData(List<PositionQueryModel> positionList);
}
