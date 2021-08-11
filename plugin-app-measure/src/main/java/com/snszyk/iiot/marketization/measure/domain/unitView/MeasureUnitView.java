package com.snszyk.iiot.marketization.measure.domain.unitView;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * 计量单位
 *
 * @author don
 */
@Data
@ToString
@NoArgsConstructor
public class MeasureUnitView implements Serializable {

    private String id;

    private String code;

    private String name;

    private String symbol;

    private String description;

    private String categoryId;

    private int sort;

    private String creatorName;

    public MeasureUnitView(String id, String code, String name, String symbol, String description, String categoryId, int sort) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.symbol = symbol;
        this.description = description;
        this.categoryId = categoryId;
        this.sort = sort;
    }
}
