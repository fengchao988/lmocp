package com.snszyk.iiot.marketization.workplace.domain.conditionView;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.snszyk.iiot.marketization.workplace.domain.condition.model.ConditionType;
import com.snszyk.iiot.marketization.workplace.domain.intergration.unit.UnitDto;
import com.snszyk.iiot.marketization.workplace.domain.intergration.unit.UnitRestRepository;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Date;

/**
 * 条件
 *
 * @author tengwang
 * @version 1.0.0
 * @date 2021/1/27 11:18 上午
 */
@Data
@Slf4j
@NoArgsConstructor
public class ConditionPageView {

    String createBy;
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    Date createTime;
    String updateBy;
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    Date updateTime;
    /**
     * 唯一标识
     */
    private String id;
    /**
     * 条件名称
     */
    private String name;
    /**
     * 计量单位ID
     */
    private String measuringUnitId;
    /**
     * 条件编码
     */
    private String code;
    /**
     * 条件类型
     */
    @Enumerated(EnumType.STRING)
    private ConditionType conditionType;
    /**
     * 定额条件备注
     */
    private String remark;

    // 需要翻译的字段

    /**
     * 条件类型名称
     */
    private String conditionTypeName;

    /**
     * 计量单位名称
     */
    private String measuringUnitName;

    /**
     * 计量单位编码
     */
    private String measuringUnitCode;

    /**
     * 计量单位符号
     */
    private String measuringUnitSymbol;

    public ConditionPageView(String id, String name, String measuringUnitId, String code, ConditionType conditionType, String remark, String createBy, Date createTime, String updateBy, Date updateTime) {
        this.id = id;
        this.name = name;
        this.measuringUnitId = measuringUnitId;
        this.code = code;
        this.conditionType = conditionType;
        this.remark = remark;
        this.createBy = createBy;
        this.createTime = createTime;
        this.updateBy = updateBy;
        this.updateTime = updateTime;
        // 处理字段翻译
        this.conditionTypeName = this.conditionType.getDesc();
    }

    /**
     * 处理计量单位
     *
     * @param unitRestRepository
     */
    public void resolveMeasureUnit(UnitRestRepository unitRestRepository) {
        if (StringUtils.isNotBlank(this.measuringUnitId)) {
            UnitDto unitDto = unitRestRepository.getById(this.measuringUnitId);
            if (null != unitDto) {
                this.measuringUnitName = unitDto.getName();
                this.measuringUnitCode = unitDto.getCode();
                this.measuringUnitSymbol = unitDto.getSymbol();
            }
        }

    }
}
