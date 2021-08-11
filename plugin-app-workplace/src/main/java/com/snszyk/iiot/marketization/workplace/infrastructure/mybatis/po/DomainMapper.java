package com.snszyk.iiot.marketization.workplace.infrastructure.mybatis.po;

import com.snszyk.iiot.marketization.workplace.domain.model.LeanWorkplace;
import com.snszyk.iiot.marketization.workplace.domain.model.LeanWorkplaceOption;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface DomainMapper {
    DomainMapper INSTANCE = Mappers.getMapper(DomainMapper.class);

    @Mapping(target = "id", source = "id")
    LeanWorkplacePo covertByDomain(LeanWorkplace domain);

    @Mapping(target = "id", source = "id")
    LeanWorkplaceOptionPo covertByDomain(LeanWorkplaceOption domain);
}
