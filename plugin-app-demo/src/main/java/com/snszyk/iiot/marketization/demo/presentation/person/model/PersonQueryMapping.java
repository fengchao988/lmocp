package com.snszyk.iiot.marketization.demo.presentation.person.model;

import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PersonQueryMapping {
    PersonQueryModel toData(PersonQueryModel person);

    List<PersonQueryModel> toData(List<PersonQueryModel> personList);
}
