package com.snszyk.iiot.marketization.measure.domain.unitView;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

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
public class MeasureUnitCategoryPageView {

    private String id;

    private String name;

    private String description;

    private int sort;

    private String creatorName;

    public MeasureUnitCategoryPageView(String id, String name, String description, int sort) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.sort = sort;
    }
}
