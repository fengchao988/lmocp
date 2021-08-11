package com.snszyk.iiot.marketization.measure.infrastructure.message.workplace;

import com.snszyk.iiot.marketization.measure.domain.unitView.MeasureUnitView;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 计量单位
 *
 * @author csyang
 * @since 2021-01-08
 */
@Data
@ApiModel("计量单位")
public class UnitDto {
    /**
     * 主键id
     */
    @ApiModelProperty("主键id")
    private String id;
    /**
     * code
     */
    @ApiModelProperty("code")
    private String code;
    /**
     * 展示名称
     */
    @ApiModelProperty("展示名称")
    private String name;
    /**
     * 展示符号
     */
    @ApiModelProperty("展示符号")
    private String symbol;

    public UnitDto(MeasureUnitView unitView) {
        this.id = unitView.getId();
        this.name = unitView.getName();
        this.code = unitView.getCode();
        this.symbol = unitView.getSymbol();
    }
}
