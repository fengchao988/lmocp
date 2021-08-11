package com.snszyk.iiot.marketization.demo.presentation.position.model;

import com.snszyk.iiot.marketization.demo.domain.position.entity.PositionType;
import lombok.Data;

import javax.persistence.Column;
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
@Table(name = "position")
public class PositionQueryModel {
    @Id
    private String id;
    private String name;
    private PositionType type;
    private String subordinateUnitId;
    @Column(name = "subordinate_unit_name")
    private String subordinateUnitName;
}
