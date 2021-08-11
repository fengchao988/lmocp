package com.snszyk.iiot.marketization.workplace.infrastructure.resource.vo;

import com.snszyk.iiot.marketization.workplace.domain.conditionView.ConditionValueView;
import com.snszyk.iiot.marketization.workplace.domain.conditionView.ConditionView;
import com.snszyk.iiot.marketization.workplace.infrastructure.mybatis.po.LeanWorkplaceOptionPo;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 工作地点作业参数 界面呈现视图对象vo
 *
 * @author tttt-boot
 * @version 1.0.0
 * @since 2021-01-12 16:14
 */
@Data
@NoArgsConstructor
public class LeanWorkplaceOptionVo {
    /**
     * 主键
     */
    @ApiModelProperty(value = "主键")
    private String id;
    /**
     * 参数
     */
    @ApiModelProperty(value = "参数")
    private String parameter;
    /**
     * 数值
     */
    @ApiModelProperty(value = "数值")
    private String value;

    private String workplaceId;

    private String parameterName;
    private String conditionType;

    private List<ConditionValueView> conditionValues = new ArrayList<>();


    public LeanWorkplaceOptionVo(LeanWorkplaceOptionPo po) {
        BeanUtils.copyProperties(po, this);
    }

    public LeanWorkplaceOptionVo(LeanWorkplaceOptionPo leanWorkplaceOptionPo, ConditionView conditionViewDto) {
        this(leanWorkplaceOptionPo);
        if (null != conditionViewDto) {
            if (null != this.parameter) {
                if (StringUtils.isNotBlank(conditionViewDto.getMeasuringUnitSymbol())) {
                    this.parameterName = String.format("%s(%s)", conditionViewDto.getName(), conditionViewDto.getMeasuringUnitSymbol());
                } else {
                    this.parameterName = conditionViewDto.getName();
                }
            }

            if (null != conditionViewDto.getConditionType()) {
                conditionType = conditionViewDto.getConditionType().getName();
            }
            conditionValues = conditionViewDto.getConditionValues();
        }
    }
}
