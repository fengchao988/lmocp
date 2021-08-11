package com.snszyk.iiot.marketization.measure.domain.unitView;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.snszyk.iiot.marketization.measure.infrastructure.mybatis.po.MeasureUnitCategoryPo;
import com.snszyk.iiot.marketization.measure.infrastructure.mybatis.po.MeasureUnitPo;

import java.util.Collection;
import java.util.List;

/**
 * 计量单位读仓库
 *
 * @author tengwang
 * @version 1.0.0
 * @date 2021/2/1 3:34 下午
 */
public interface MeasureUnitViewRepository {

    IPage<MeasureUnitCategoryPageView> pageMeasureUnitCategoryView(String name, IPage<MeasureUnitCategoryPo> pageParam);

    MeasureUnitCategoryView getMeasureUnitCategoryById(String id);

    List<MeasureUnitView> getMeasureUnitsByCategoryId(String id);

    MeasureUnitView getMeasureUnitById(String s);

    List<MeasureUnitView> getMeasureUnitByIds(Collection<String> ids);

    IPage<MeasureUnitView> getMeasureUnitPages(String categoryId, String name, IPage<MeasureUnitPo> page);

    List<MeasureUnitCategoryView> getMeasureUnitCategoryViews(String name);

    List<MeasureUnitView> findByIds(List<String> idList);
}
