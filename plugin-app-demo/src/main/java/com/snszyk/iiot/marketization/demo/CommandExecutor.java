package com.snszyk.iiot.marketization.demo;

import lombok.SneakyThrows;
import org.mapstruct.factory.Mappers;
import org.springframework.util.ClassUtils;

/**
 * 封装mapstruct的api，对外屏蔽所有除exec之外的转换方法，把逻辑执行实际是个转换这个事实隐藏起来
 *
 * @author tengwang
 * @version 1.0.0
 * @date 2021/7/19 10:56 上午
 */
public abstract class CommandExecutor {
//    public abstract static class CommandLogic<T> {
//       abstract T exec(T t);
//    }
//
//    @SuppressWarnings("unchecked")
//    public static <T> void EXEC(T command) {
//        ((CommandLogic<T>) Mappers.getMapper(conventionalExecutorName(command.getClass()))).exec(command);
//    }
//
//    @SuppressWarnings("unchecked")
//    @SneakyThrows
//    private static <T> Class<? extends CommandLogic<T>> conventionalExecutorName(Class<? extends T> commandType) {
//        String executorName = commandType.getName() + "Logic";
//        return (Class<? extends CommandLogic<T>>) ClassUtils.forName(executorName, CommandExecutor.class.getClassLoader());
//    }
}
