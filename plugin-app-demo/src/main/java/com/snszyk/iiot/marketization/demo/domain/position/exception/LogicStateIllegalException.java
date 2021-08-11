package com.snszyk.iiot.marketization.demo.domain.position.exception;

/**
 * 通用异常 逻辑状态不合法异常 // TODO tengwang 抽取至核心包
 *
 * @author tengwang
 * @version 1.0.0
 * @date 2021/7/13 3:33 下午
 */
public class LogicStateIllegalException extends RuntimeException{

    public LogicStateIllegalException(String message) {
        super(message);
    }

    public LogicStateIllegalException(Throwable cause) {
        super(cause);
    }

    public LogicStateIllegalException(String message, Throwable cause) {
        super(message, cause);
    }
}
