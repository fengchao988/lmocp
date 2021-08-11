package com.snszyk.iiot.marketization.measure.infrastructure.mybatis.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.snszyk.iiot.marketization.measure.domain.unit.MeasureUnitCategory;
import com.snszyk.iiot.marketization.measure.domain.unitView.MeasureUnitCategoryPageView;
import com.snszyk.iiot.marketization.measure.domain.unitView.MeasureUnitCategoryView;
import com.snszyk.iiot.marketization.measure.domain.unitView.MeasureUnitViewRepository;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.jeecg.common.system.base.entity.JeecgEntity;
import org.springframework.beans.BeanUtils;

/**
 * 产品库-通用库-计量服务-计量单位分类
 */
@Data
@TableName("lc_measure_unit_category")
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class MeasureUnitCategoryPo extends JeecgEntity {
    private String name;
    private String description;
    private int sort;

    public MeasureUnitCategoryPo(MeasureUnitCategory category) {
        BeanUtils.copyProperties(category, this);
    }

    public void covertByDomain(Object obj) {
        BeanUtils.copyProperties(obj, this);
    }

    public MeasureUnitCategory transferToDomain() {
        return new MeasureUnitCategory(getId(), name, sort, description);
    }

    public MeasureUnitCategoryPageView convertToMeasureUnitCategoryPageView() {
        return new MeasureUnitCategoryPageView(this.getId(), this.getName(), this.getDescription(), this.sort);
    }

    public MeasureUnitCategoryView convertToMeasureUnitCategoryView(MeasureUnitViewRepository measureUnitViewRepository) {
        MeasureUnitCategoryView measureUnitCategoryView = new MeasureUnitCategoryView(this.getId(), this.getName(), this.getDescription(), this.sort);
        measureUnitCategoryView.resolveMeasureUnit(measureUnitViewRepository);
        return measureUnitCategoryView;
    }

    public void setEditAttr(MeasureUnitCategory measureUnitCategory) {
        BeanUtils.copyProperties(measureUnitCategory, this);
    }
}
