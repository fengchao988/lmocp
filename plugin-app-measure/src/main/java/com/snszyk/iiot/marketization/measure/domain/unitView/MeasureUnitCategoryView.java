package com.snszyk.iiot.marketization.measure.domain.unitView;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * 计量单位分类树结构读模型
 *
 * @author tengwang
 * @version 1.0.0
 * @date 2021/2/1 2:25 下午
 */
@Data
@Slf4j
@NoArgsConstructor
public class MeasureUnitCategoryView {

    private String id;

    private String name;

    private String description;

    private int sort;

    private List<MeasureUnitView> measureUnits = new ArrayList<>();

    public MeasureUnitCategoryView(String id, String name, String description, int sort) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.sort = sort;
    }

    public void resolveMeasureUnit(MeasureUnitViewRepository measureUnitViewRepository) {
        this.measureUnits = measureUnitViewRepository.getMeasureUnitsByCategoryId(this.id);
    }
}
