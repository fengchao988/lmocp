package com.snszyk.iiot.marketization.demo.infrastructure.api.rpc.position;

import com.snszyk.iiot.marketization.demo.domain.position.command.PositionCreateCommand;
import com.snszyk.iiot.marketization.demo.domain.position.entity.PositionType;
import lombok.Data;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

/**
 * 岗位=创建数据传输对象
 *
 * @author tengwang
 * @version 1.0.0
 * @date 2021/7/12 10:21 上午
 */
@Data
public class PositionCreateDto {

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
}

@Mapper(componentModel = "spring")
abstract class PositionCreateTargetMapping {
    public static final PositionCreateTargetMapping INSTANCES = Mappers.getMapper(PositionCreateTargetMapping.class);

//    @Mappings({
//            @Mapping(source = "name", target = "positionInfo.name"),
//            @Mapping(source = "positionType", target = "positionInfo.positionType"),
//            @Mapping(source = "organizationId", target = "positionInfo.organizationId"),
//    })
//    abstract PositionCreateCommand dtoToCommand(PositionCreateDto dto);

}
