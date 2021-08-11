package com.snszyk.iiot.marketization.measure.domain.unit;

import java.util.List;

public interface MeasureUnitRepository {

    void saveUnitCategory(MeasureUnitCategory measureUnitCategory);

    MeasureUnitCategory findMeasureUnitCategoryById(String id);

    void deleteMeasureUnitCategory(MeasureUnitCategory measureUnitCategory);

    void saveUnit(MeasureUnit measureUnit);

    MeasureUnit findMeasureUnitById(String id);

    void deleteMeasureUnit(MeasureUnit measureUnit);

    void editUnitCategory(MeasureUnitCategory measureUnitCategory);

    void editMeasureUnit(MeasureUnit measureUnit);

    List<MeasureUnit> list(MeasureUnit measureUnit);

    MeasureUnitCategory getMeasureUnitCategoryByName(String name);

    List<MeasureUnit> getMeasureUnitByMeasureUnitCategoryId(String id);
}
