package com.snszyk.iiot.marketization.base.presentation.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "TMP_ORGANIZATION")
public class Organization {
    @Id
    private String id;
    private String name;
    private String parentId;
}
