package com.snszyk.iiot.marketization.workplace.application.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.jeecg.common.system.base.dto.RequestPage;

/**
 * 工作地点作业参数 查询数据传输对象
 *
 * @author tttt-boot
 * @version 1.0.0
 * @since 2021-01-12 16:14
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel("工作地点作业参数查询数据传输对象dto")
public class LeanWorkplaceOptionQueryDto extends RequestPage {
    private String id;
    @ApiModelProperty("名称(参数)")
    private String parameter;
    @ApiModelProperty("数值")
    private String value;

    private String workplaceId;
}
