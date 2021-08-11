package com.snszyk.iiot.marketization.demo.domain.position.valobj;

import lombok.*;
import org.jeecg.common.util.UUIDGenerator;

import javax.persistence.Column;
import java.io.Serializable;

/**
 * 岗位标识
 *
 * @author tengwang
 * @version 1.0.0
 * @date 2021/7/13 12:07 下午
 */
@Value
@Builder
@ToString
@EqualsAndHashCode
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class PositionId implements Serializable {

    @Column(name ="id",nullable = false)
    private String id;

    public PositionId() {
        this.id = UUIDGenerator.generate();
    }
}
