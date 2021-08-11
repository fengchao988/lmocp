package com.snszyk.iiot.marketization.demo.infrastructure.persistence.aggr;

import com.snszyk.iiot.marketization.demo.domain.position.entity.Position;
import com.snszyk.iiot.marketization.demo.domain.position.entity.PositionType;
import com.snszyk.iiot.marketization.demo.domain.position.valobj.*;
import lombok.Data;
import lombok.Setter;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

/**
 * TODO
 *
 * @author tengwang
 * @version 1.0.0
 * @date 2021/7/12 4:37 下午
 */
@Data
@Entity(name = "position")
public class PositionPO {
    @Id
    private String id;
    private String name;
    private PositionType positionType;
    private String organizationId;
    private String organizationName;
    private LoseEfficacyState loseEfficacyState = LoseEfficacyState.NORMAL;
    private Long failureTime;

    @Mapper
    public interface PositionPoTransDomainMapper {
        @Mapping(source = "po.failureTime", target = ".")
        FailureTime failureTimeTrans(PositionPO po);

//        @Mapping(source = "po.name", target = ".")
//        PositionName positionNameTrans(PositionPO po);

        @Mappings({
                @Mapping(source = "po.organizationId", target = "organizationId"),
                @Mapping(source = "po.organizationName", target = "name")
        })
        SubordinateUnit subordinateUnitTrans(PositionPO po);
    }
}

@Mapper(uses = PositionPO.PositionPoTransDomainMapper.class)
interface PositionPO2DomainMapper {
    PositionPO2DomainMapper INSTANCE = Mappers.getMapper(PositionPO2DomainMapper.class);

    @BeanMapping(ignoreByDefault = true)
    @Mappings({
            @Mapping(source = "positionId.id", target = "id"),
            @Mapping(source = "positionName.name", target = "name"),
            @Mapping(source = "subordinateUnit.organizationId", target = "organizationId"),
            @Mapping(source = "subordinateUnit.name", target = "organizationName"),
            @Mapping(source = "failureTime.failureTime", target = "failureTime")
    })
    PositionPO domain2po(Position position);
//
//    @Mappings({
//            @Mapping(source = "positionId.id", target = "id"),
//            @Mapping(source = "positionName.name", target = "name"),
//            @Mapping(source = "subordinateUnit.organizationId", target = "organizationId"),
//            @Mapping(source = "subordinateUnit.name", target = "organizationName"),
//            @Mapping(source = "failureTime.failureTime", target = "failureTime")
//    })
//    List<PositionPO> domain2poList(List<Position> positions);

    @Mappings({
            //@Mapping(source = "id", target = "positionId.id"),
            @Mapping(target = "subordinateUnit", source = "."),
            @Mapping(target = "failureTime", source = "."),
            //@Mapping(target = "positionName", source = "."),
            //@Mapping(source = "name", target = "positionName.name"),
    })
    void po2domain(PositionPO positionPO, @MappingTarget Position position);

//    @InheritInverseConfiguration(name = "domain2poList")
//    List<Position> po2domainList(List<PositionPO> positionPOS);
}


