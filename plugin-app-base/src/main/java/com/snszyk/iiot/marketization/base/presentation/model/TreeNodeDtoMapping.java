package com.snszyk.iiot.marketization.base.presentation.model;

import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TreeNodeDtoMapping {
    TreeNodeDto toData(TreeNodeDto dto);

    List<TreeNodeDto> toData(List<TreeNodeDto> dto);
}
