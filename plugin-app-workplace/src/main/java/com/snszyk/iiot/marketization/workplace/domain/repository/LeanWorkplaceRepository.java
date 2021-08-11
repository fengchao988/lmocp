package com.snszyk.iiot.marketization.workplace.domain.repository;

import com.snszyk.iiot.marketization.workplace.domain.model.LeanWorkplace;
import com.snszyk.iiot.marketization.workplace.domain.model.LeanWorkplaceOption;

import java.util.List;

/**
 * 工作地点 数据仓库接口
 * @author tttt-boot
 * @version 1.0.0
 * @since 2021-01-12 16:13
 */
public interface LeanWorkplaceRepository {
    /**
     * 保存 工作地点对象
     * @param domain 工作地点domain对象
     * @return 是否成功
     */
    String save(LeanWorkplace domain);
    /**
     * 更新 工作地点对象
     * @param domain 工作地点domain对象
     * @return 是否成功
     */
    Boolean update(LeanWorkplace domain);
    /**
     * 删除 工作地点对象
     * @param id id
     * @return 是否成功
     */
    Boolean delete(String id);
    /**
     * 批量删除 工作地点对象
     * @param ids ids
     * @return 是否成功
     */
    Boolean deleteByIds(List<String> ids);

    void create(LeanWorkplace leanWorkplace);

    void batchCreateOptions(List<LeanWorkplaceOption> options);

    void batchModifyOptions(List<LeanWorkplaceOption> options);

    boolean existsName(LeanWorkplace leanWorkplace);
}

