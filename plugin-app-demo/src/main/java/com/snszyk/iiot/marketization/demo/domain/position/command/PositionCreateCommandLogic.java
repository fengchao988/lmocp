package com.snszyk.iiot.marketization.demo.domain.position.command;

import com.snszyk.iiot.marketization.demo.domain.position.valobj.PositionInfo;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

/**
 * 岗位创建逻辑
 *
 * @author tengwang
 * @version 1.0.0
 * @date 2021/7/12 5:07 下午
 */
@Mapper(uses = PositionInfo.PositionMapper.class)
public abstract class PositionCreateCommandLogic {

    public static final PositionCreateCommandLogic INSTANCES = Mappers.getMapper(PositionCreateCommandLogic.class);

    public void exec(PositionCreateCommand command) { // 对外接口
        trans(command, command);
        event(command);
    }

    @BeanMapping(ignoreByDefault = true)
    @Mappings({
            @Mapping(source = "positionInfo", target = "target.positionName"),
            @Mapping(source = "positionInfo.positionType", target = "target.positionType"),
            @Mapping(source = "positionInfo", target = "target.subordinateUnit"),//todo to tengwang -> same 'name' will be copy,please check!
    })
    public abstract void trans(PositionCreateCommand original, @MappingTarget PositionCreateCommand target); // 外部也能调用，

    /**
     * 原始对象拷贝
     *
     * @param command
     */
    @BeforeMapping
    protected void before(PositionCreateCommand command) {
        // 约束校验

        // 规则校验
    }

    /**
     * 事件构造
     *
     * @param command
     */
    @AfterMapping
    protected void after(PositionCreateCommand command) {
        // 执行规则

        // 约束校验

        // 规则校验
    }

    /**
     * 构造事件
     *
     * @param command
     */
    public void event(PositionCreateCommand command) { // 对外接口
        this.convertEvent(command, command);
    }

    /**
     * 事件转换
     *
     * @return
     */
    @Mappings({
            @Mapping(source = "positionInfo", target = "event.positionInfo"),
            @Mapping(source = "original", target = "event.original"),
            @Mapping(source = "target", target = "event.target"),
    })
    public abstract void convertEvent(PositionCreateCommand originalCommand, @MappingTarget PositionCreateCommand targetCommand);
}
