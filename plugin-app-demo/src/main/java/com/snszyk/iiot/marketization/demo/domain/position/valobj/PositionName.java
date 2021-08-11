package com.snszyk.iiot.marketization.demo.domain.position.valobj;

import lombok.*;

import javax.persistence.Column;

/**
 * 岗位名称
 *
 * @author tengwang
 * @version 1.0.0
 * @date 2021/7/13 12:08 下午
 */
@Value
@Builder
@ToString
@EqualsAndHashCode
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class PositionName {

    public String name;
}
