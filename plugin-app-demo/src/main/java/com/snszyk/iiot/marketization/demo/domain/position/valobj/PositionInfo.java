package com.snszyk.iiot.marketization.demo.domain.position.valobj;

import com.snszyk.iiot.marketization.demo.domain.position.entity.PositionType;
import lombok.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * 待创建的岗位信息 // TODO tengwang  考虑要不要分离这种command用的值对象和领域用的值对象 因为其在生命周期的开始不一样 一个是从springmvc起来的 一个是从mp  SpringMVC的对象映射不支持不可变对象的Builder创建方法
 *
 * @author tengwang
 * @version 1.0.0
 * @date 2021/7/13 1:52 下午
 */
@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class PositionInfo {

    /**
     * 岗位名称
     */
    private String name;

    /**
     * 岗位类型
     */
    private PositionType positionType;

    /**
     * 所属单位
     */
    private String organizationId;

    @Mapper
    public interface PositionMapper {
        @Mapping( source = "positionInfo.name", target = ".")
        PositionName positionNameTrans(PositionInfo positionInfo);
        @Mapping(source = "positionInfo.organizationId", target = ".")
        SubordinateUnit subordinateUnitTrans(PositionInfo positionInfo);
    }
}

