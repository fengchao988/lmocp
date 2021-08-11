package com.snszyk.iiot.marketization.workplace.domain.conditionView;

import com.snszyk.iiot.marketization.workplace.domain.condition.model.ConditionType;
import com.snszyk.iiot.marketization.workplace.domain.conditionView.repository.ConditionViewRepository;
import com.snszyk.iiot.marketization.workplace.domain.intergration.unit.UnitDto;
import com.snszyk.iiot.marketization.workplace.domain.intergration.unit.UnitRestRepository;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.List;

/**
 * 条件-单查领域模型
 *
 * @author tengwang
 * @version 1.0.0
 * @date 2021/1/27 11:18 上午
 */
@Data
@Slf4j
@NoArgsConstructor
public class ConditionView {

    /**
     * 唯一标识
     */
    private String id;

    /**
     * 定额条件名称
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
     * 定额条件类型
     */
    @Enumerated(EnumType.STRING)
    private ConditionType conditionType;

    /**
     * 该条件的所有可选值
     */
    private List<ConditionValueView> conditionValues;

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

    public ConditionView(String id, String name, String measuringUnitId, String code, ConditionType conditionType, String remark, ConditionViewRepository conditionViewRepository) {
        this.id = id;
        this.name = name;
        this.measuringUnitId = measuringUnitId;
        this.code = code;
        this.conditionType = conditionType;
        this.remark = remark;
        this.getConditionValues(conditionViewRepository);
        // 处理字段翻译
        this.conditionTypeName = this.conditionType.getDesc();
    }

    public List<ConditionValueView> getConditionValues(ConditionViewRepository conditionViewRepository) {
        if (null == this.conditionValues) {
            this.conditionValues = conditionViewRepository.getConditionValueViewsByConditionId(this.id);
        }
        return this.conditionValues;
    }

    /**
     * 处理计量单位
     * @param unitRestRepository 计量单位查询接口
     */
    public void resolveMeasureUnit(UnitRestRepository unitRestRepository) {
        if(StringUtils.isNotBlank(this.measuringUnitId)){
            UnitDto unitDto = unitRestRepository.getById(this.measuringUnitId);
            if(null != unitDto){
                this.measuringUnitName = unitDto.getName();
                this.measuringUnitCode = unitDto.getCode();
                this.measuringUnitSymbol = unitDto.getSymbol();
            }
        }

    }
}
