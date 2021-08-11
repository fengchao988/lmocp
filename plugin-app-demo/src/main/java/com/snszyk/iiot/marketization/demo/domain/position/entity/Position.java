package com.snszyk.iiot.marketization.demo.domain.position.entity;

import com.snszyk.iiot.marketization.demo.domain.position.valobj.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.GroupSequence;

/**
 * 岗位模型
 *
 * @author tengwang
 * @version 1.0.0
 * @date 2021/7/12 9:23 上午
 */
@Data
@ToString
@EqualsAndHashCode(exclude = {"positionId"})
public class Position {

    /**
     * 岗位标识
     */
    private PositionId positionId = new PositionId();

    /**
     * 岗位名称
     */
    private PositionName positionName;

    /**
     * 岗位类型
     */
    private PositionType positionType;

    /**
     * 所属单位
     */
    private SubordinateUnit subordinateUnit;

    /**
     * 岗位失效状态
     */
    private LoseEfficacyState loseEfficacyState = LoseEfficacyState.NORMAL;

    /**
     * 生命周期时间
     */
    private FailureTime failureTime;

    /* 校验组定义 */
    public interface InitializtionValidate {
    }

    public interface NormalValidate {
    }

    public interface FailureValidate {
    }

    public interface DeletionValidate {
    }

    /* 校验序列定义 */
    @GroupSequence({InitializtionValidate.class})
    public interface InitializtionSequence {
    }

    @GroupSequence({NormalValidate.class})
    public interface NormalSequence {
    }

    @GroupSequence({FailureValidate.class})
    public interface FailureSequence {
    }

    @GroupSequence({DeletionValidate.class})
    public interface DeletionSequence {
    }
}
