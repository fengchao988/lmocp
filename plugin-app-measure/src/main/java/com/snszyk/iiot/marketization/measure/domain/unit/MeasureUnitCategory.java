package com.snszyk.iiot.marketization.measure.domain.unit;

import lombok.Getter;
import me.zhyd.oauth.utils.UuidUtils;
import org.jeecg.common.exception.JeecgBootException;

import java.io.Serializable;
import java.util.List;

@Getter
public class MeasureUnitCategory implements Serializable {
    private String id;
    private String name;
    private String description;
    private int sort;

    public MeasureUnitCategory(String name, int sort, String description) {
        this.name = name;
        this.sort = sort;
        this.description = description;
    }

    public MeasureUnitCategory(String id, String name, int sort, String description) {
        this(name, sort, description);
        this.id = id;
    }


    /**
     * 创建分类
     *
     * @param measureUnitRepository
     */
    public void create(MeasureUnitRepository measureUnitRepository) {
        this.id = UuidUtils.getUUID();

        this.checkCanBeCreate(measureUnitRepository);
        measureUnitRepository.saveUnitCategory(this);
    }

    public void edit(MeasureUnitRepository measureUnitRepository) throws Exception {
        this.checkCanBeEdit(measureUnitRepository);
        measureUnitRepository.editUnitCategory(this);
    }

    private void checkCanBeEdit(MeasureUnitRepository measureUnitRepository) throws Exception {
        MeasureUnitCategory category = measureUnitRepository.findMeasureUnitCategoryById(this.id);
        if (category == null) {
            throw new JeecgBootException("未查询到分类信息");
        }
    }

    /**
     * 校验能否创建
     *
     * @param measureUnitRepository
     */
    private void checkCanBeCreate(MeasureUnitRepository measureUnitRepository) {
        // 校验不可重复创建
        MeasureUnitCategory measureUnitCategory = measureUnitRepository.getMeasureUnitCategoryByName(this.name);
        if (null != measureUnitCategory) {
            throw new JeecgBootException("该分类已存在,请检查");
        }
    }

    /**
     * 移除分类
     *
     * @param measureUnitRepository
     */
    public void delete(MeasureUnitRepository measureUnitRepository) {
        this.checkCanBeDelete(measureUnitRepository);
        measureUnitRepository.deleteMeasureUnitCategory(this);
    }

    private void checkCanBeDelete(MeasureUnitRepository measureUnitRepository) {
        // 删除时下级不可有分类及计量单位
        List<MeasureUnit> measureUnits = measureUnitRepository.getMeasureUnitByMeasureUnitCategoryId(this.id);
        if (measureUnits.size() > 0) {
            throw new JeecgBootException("该分类下存在计量单位,不可删除");
        }
    }
}
