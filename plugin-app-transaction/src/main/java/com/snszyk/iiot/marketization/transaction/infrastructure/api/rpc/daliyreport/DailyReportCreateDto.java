package com.snszyk.iiot.marketization.transaction.infrastructure.api.rpc.daliyreport;

import com.snszyk.iiot.marketization.transaction.domain.orderticket.command.OrderTicketCreateCommand;
import com.snszyk.iiot.marketization.transaction.domain.orderticket.valobj.DistributionMode;
import com.snszyk.iiot.marketization.transaction.domain.orderticket.valobj.WorkingShift;
import lombok.Data;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

/**
 * 班组日报数据传输对象
 *
 * @author tengwang
 * @version 1.0.0
 * @date 2021/7/12 10:21 上午
 */
@Data
public class DailyReportCreateDto {

    /**
     * 创建人Id
     */
    private String creatorId;

    /**
     * 业务期间
     */
    private Long businessTime;

    /**
     * 工作地点
     */
    private String workplaceId;

    /**
     * 劳动班次
     */
    private WorkingShift workingShift;

    /**
     * 跟班队长ID
     */
    private String accompanyMonitor;

    /**
     * 分配方式
     */
    private DistributionMode distributionMode;


}

@Mapper(componentModel = "spring")
abstract class DailyReportCreateTargetMapping {
    public static final DailyReportCreateTargetMapping INSTANCES = Mappers.getMapper(DailyReportCreateTargetMapping.class);

    @Mappings({
            @Mapping(source = "name", target = "positionInfo.name"),
            @Mapping(source = "positionType", target = "positionInfo.positionType"),
            @Mapping(source = "organizationId", target = "positionInfo.organizationId"),
    })
    abstract OrderTicketCreateCommand dtoToCommand(DailyReportCreateDto dto);

}
