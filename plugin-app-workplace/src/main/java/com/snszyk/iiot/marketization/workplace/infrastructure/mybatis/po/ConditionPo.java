package com.snszyk.iiot.marketization.workplace.infrastructure.mybatis.po;

import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.snszyk.iiot.marketization.workplace.domain.condition.Condition;
import com.snszyk.iiot.marketization.workplace.domain.condition.model.ConditionType;
import com.snszyk.iiot.marketization.workplace.domain.conditionView.ConditionPageView;
import com.snszyk.iiot.marketization.workplace.domain.conditionView.ConditionView;
import com.snszyk.iiot.marketization.workplace.domain.intergration.unit.UnitRestRepository;
import com.snszyk.iiot.marketization.workplace.infrastructure.mybatis.repository.conditionView.ConditionViewRepositoryImpl;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import java.util.Date;

/**
 * 产品库-通用库-工作地点-条件库 po
 */
@Data
@NoArgsConstructor
@TableName("lc_workplace_condition")
public class ConditionPo {

    /**
     * ID
     */
    @Id
    String id;

    /**
     * 条件名
     */
    String name;

    /**
     * 条件编码
     */
    String code;

    /**
     * 计量单位ID
     */
    String measuringUnitId;

    /**
     * 定额条件类型
     */
    @Enumerated(EnumType.STRING)
    ConditionType conditionType;

    /**
     * 备注
     */
    String remark;

    String createBy;

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    Date createTime;

    String updateBy;

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    Date updateTime;

    @TableLogic
    Boolean delFlag;

    public ConditionPo(Condition condition) {
        this.id = condition.getId();
        this.conditionType = condition.getConditionType();
        this.measuringUnitId = condition.getMeasuringUnitId();
        this.name = condition.getName();
        this.code = condition.getCode();
    }

    /**
     * 转换为写模型
     *
     * @return
     */
    public Condition convertToDomain() {
        return new Condition(this.id, this.name,
                 this.code, this.measuringUnitId,this.conditionType, this.remark);
    }

    /**
     * 转换为分页读模型
     *
     * @param unitRestRepository
     * @return
     */
    public ConditionPageView convertToConditionPageView(UnitRestRepository unitRestRepository) {
        ConditionPageView conditionPageView = new ConditionPageView(
                this.id, this.name, this.measuringUnitId, this.code,
                this.conditionType, this.remark, this.createBy, this.createTime, this.updateBy, this.updateTime);
        conditionPageView.resolveMeasureUnit(unitRestRepository);
        return conditionPageView;
    }

    /**
     * 转换为单一读模型
     *
     * @param unitRestRepository
     * @return
     */
    public ConditionView convertToConditionView(ConditionViewRepositoryImpl conditionViewRepository, UnitRestRepository unitRestRepository) {
        ConditionView conditionView = new ConditionView(this.id, this.name, this.measuringUnitId, this.code, this.conditionType, this.remark, conditionViewRepository);
        conditionView.resolveMeasureUnit(unitRestRepository);
        return conditionView;
    }
}
