package com.snszyk.iiot.marketization.transaction.presentation.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@ApiModel("物资日报查询列表展示")
@Entity
@Table(name = "TMP_SUPPLIES_DAILY_QUERY")
public class SuppliesDailyQueryModel implements Serializable {
    @Id
    @ApiModelProperty("主键id")
    private String id;
    @ApiModelProperty("结算单id")
    private String settlementId;
    @ApiModelProperty("结算单号")
    private String settlementNo;
    @ApiModelProperty("业务期间")
    private Date businessDate;
    @ApiModelProperty("总金额")
    private BigDecimal total;
    @ApiModelProperty("提报时间")
    private Date reportingTime;
    @ApiModelProperty("状态")
    private String status;

}
