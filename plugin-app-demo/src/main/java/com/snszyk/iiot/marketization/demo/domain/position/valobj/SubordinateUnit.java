package com.snszyk.iiot.marketization.demo.domain.position.valobj;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * 所属单位
 *
 * @author tengwang
 * @version 1.0.0
 * @date 2021/7/13 1:27 下午
 */
@Value
@Builder
@ToString
@EqualsAndHashCode
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class SubordinateUnit {

    private String organizationId;

    @Column(name = "subordinate_unit_name")
    private String name;
}
