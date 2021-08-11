package com.snszyk.iiot.marketization.demo.domain.position.valobj;

import lombok.*;

import javax.persistence.Embeddable;

/**
 * 岗位生命时间
 *
 * @author tengwang
 * @version 1.0.0
 * @date 2021/7/14 1:59 下午
 */
@Value
@Builder
@ToString
@EqualsAndHashCode
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class FailureTime {

    //失效时间
    private Long failureTime;

    public FailureTime() {
        this.failureTime = System.currentTimeMillis();
    }

}
