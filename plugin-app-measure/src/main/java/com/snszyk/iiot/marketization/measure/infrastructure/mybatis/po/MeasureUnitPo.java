package com.snszyk.iiot.marketization.measure.infrastructure.mybatis.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.snszyk.iiot.marketization.measure.domain.unit.MeasureUnit;
import com.snszyk.iiot.marketization.measure.domain.unitView.MeasureUnitView;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.jeecg.common.system.base.entity.JeecgEntity;
import org.springframework.beans.BeanUtils;

/**
 * 产品库-通用库-计量服务-计量单位
 *
 * @author windy
 * @date 2021-01-27 08:44:23
 */
@Data
@TableName("lc_measure_unit")
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class MeasureUnitPo extends JeecgEntity {
    private String code;
    private String name;
    private String symbol;
    private String description;
    private String categoryId;
    private int sort;

    public MeasureUnitPo(MeasureUnit unit) {
        BeanUtils.copyProperties(unit, this);
    }

    public void covertByDomain(Object obj) {
        BeanUtils.copyProperties(obj, this);
    }

    public MeasureUnit transferToDomain() {
        return new MeasureUnit(getId(), name, symbol, categoryId, sort, description);
    }

    public MeasureUnitView convertToMeasureUnitView() {
        return new MeasureUnitView(this.getId(), this.getCode(), this.getName(), this.getSymbol(), this.description,
                this.categoryId, this.sort);
    }

    public void setEditAttr(MeasureUnit unit) {
        this.name = unit.getName();
        this.symbol = unit.getSymbol();
        this.description = unit.getDescription();
        this.categoryId = unit.getCategoryId();
        this.sort = unit.getSort();

    }
}
