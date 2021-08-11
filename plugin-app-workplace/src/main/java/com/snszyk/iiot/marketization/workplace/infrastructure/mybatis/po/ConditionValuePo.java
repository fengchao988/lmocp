package com.snszyk.iiot.marketization.workplace.infrastructure.mybatis.po;

import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.snszyk.iiot.marketization.workplace.domain.condition.model.ConditionValue;
import com.snszyk.iiot.marketization.workplace.domain.conditionView.ConditionValueView;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Id;
import java.util.Date;

/**
 * 产品库-通用库-工作地点-条件值
 *
 * @author tengwang
 */
@Data
@NoArgsConstructor
@TableName("lc_workplace_condition_value")
public class ConditionValuePo {

    /**
     * 唯一编码
     */
    @Id
    private String id;

    /**
     * 条件值
     */
    private String value;

    /**
     * 条件值编码
     */
    private String code;

    /**
     * 条件ID
     */
    private String conditionId;

    private String createBy;

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    private String updateBy;

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    @TableLogic
    private Boolean delFlag;

    public ConditionValuePo(ConditionValue conditionValue, String conditionId) {
        this.id = conditionValue.getId();
        this.value = conditionValue.getValue();
        this.code = conditionValue.getCode();
        this.conditionId = conditionId;
    }

    public ConditionValue convertToDomain() {
        ConditionValue conditionValue = new ConditionValue();
        BeanUtils.copyProperties(this, conditionValue);
        return conditionValue;
    }

    public ConditionValueView convertToConditionValueViewDomain(String conditionId) {
        return new ConditionValueView(this.id, this.value, this.code, conditionId);
    }
}
