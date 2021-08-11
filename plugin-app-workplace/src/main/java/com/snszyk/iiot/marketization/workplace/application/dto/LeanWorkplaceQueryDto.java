package com.snszyk.iiot.marketization.workplace.application.dto;

import com.snszyk.iiot.marketization.workplace.domain.model.enums.WorkplaceType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.jeecg.common.system.base.dto.RequestPage;

import java.util.List;

/**
 * 工作地点 查询数据传输对象
 *
 * @author tttt-boot
 * @version 1.0.0
 * @since 2021-01-12 16:13
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel("工作地点查询数据传输对象dto")
public class LeanWorkplaceQueryDto extends RequestPage {
    private String id;
    @ApiModelProperty("名称")
    private String name;

    @ApiModelProperty("地点类型")
    private WorkplaceType type;

    @ApiModelProperty("工作面条件")
    private List<LeanWorkplaceOptionQueryDto> options;
}
