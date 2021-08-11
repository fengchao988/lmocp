package com.snszyk.iiot.marketization.workplace.domain.conditionView.repository;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.snszyk.iiot.marketization.workplace.domain.condition.model.ConditionType;
import com.snszyk.iiot.marketization.workplace.domain.conditionView.ConditionPageView;
import com.snszyk.iiot.marketization.workplace.domain.conditionView.ConditionValueView;
import com.snszyk.iiot.marketization.workplace.domain.conditionView.ConditionView;

import java.util.Collection;
import java.util.List;

/**
 * 条件读仓库
 *
 * @author tengwang
 * @version 1.0.0
 * @date 2021/1/27 11:51 上午
 */
public interface ConditionViewRepository {

    /**
     * 分页查询条件
     *
     * @return
     */
    IPage<ConditionPageView> pageConditionPageView(String code, String name, ConditionType conditionType, Integer pageNo, Integer pageSize);

    /**
     * 通过条件ID获取条件可选值
     *
     * @param conditionId
     * @return
     */
    List<ConditionValueView> listConditionValues(String conditionId);

    /**
     * 通过编码查询条件
     *
     * @param code
     * @return
     */
    ConditionView getConditionByCode(String code);

    /**
     * 通过条件ID获取所有条件值
     *
     * @param id
     * @return
     */
    List<ConditionValueView> getConditionValueViewsByConditionId(String id);

    /**
     * 通过ID查询条件
     *
     * @param id
     * @return
     */
    ConditionView getConditionById(String id);

    /**
     * 列表查询所有条件
     *
     * @return
     */
    List<ConditionView> listConditionView(String code, String name, ConditionType conditionType);

    /**
     * 通过IDs查询条件
     *
     * @param ids
     * @return
     */
    List<ConditionView> getConditionByIds(Collection<String> ids);

}
