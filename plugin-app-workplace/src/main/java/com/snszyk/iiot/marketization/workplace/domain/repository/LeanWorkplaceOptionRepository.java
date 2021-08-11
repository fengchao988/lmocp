package com.snszyk.iiot.marketization.workplace.domain.repository;

import com.snszyk.iiot.marketization.workplace.domain.model.LeanWorkplaceOption;

import java.util.List;

/**
 * 工作地点作业参数 数据仓库接口
 * @author tttt-boot
 * @version 1.0.0
 * @since 2021-01-12 16:14
 */
public interface LeanWorkplaceOptionRepository {
    /**
     * 保存 工作地点作业参数对象
     * @param domain 工作地点作业参数domain对象
     * @return 是否成功
     */
    String save(LeanWorkplaceOption domain);
    /**
     * 更新 工作地点作业参数对象
     * @param domain 工作地点作业参数domain对象
     * @return 是否成功
     */
    Boolean update(LeanWorkplaceOption domain);
    /**
     * 删除 工作地点作业参数对象
     * @param id id
     * @return 是否成功
     */
    Boolean delete(String id);
    /**
     * 批量删除 工作地点作业参数对象
     * @param ids ids
     * @return 是否成功
     */
    Boolean deleteByIds(List<String> ids);
}

