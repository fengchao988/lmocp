package com.snszyk.iiot.marketization.demo.presentation.person.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author tengwang
 * @version 1.0.0
 * @since 2021/7/16 16:32
 */
@Data
@Entity
@Table(name = "person")
public class PersonQueryModel {
    @Id
    private String id;
    private String name;
    private String positionId;
    private String positionName;
}
