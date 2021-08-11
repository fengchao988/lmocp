package com.snszyk.iiot.marketization.workplace.domain.model;

import com.snszyk.iiot.marketization.workplace.domain.repository.LeanWorkplaceOptionRepository;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * 工作地点作业参数 领域对象domain
 * @author tttt-boot
 * @version 1.0.0
 * @since 2021-01-12 16:14
 */
@Getter
@NoArgsConstructor
public class LeanWorkplaceOption {
    /**主键*/
    private String id;
    /**参数*/
    private String parameter;
    /**数值*/
    private String value;
    @Setter
    @Getter
    private String workplaceId;

    /** 批量删除用 */
    private List<String> ids;

    /**
     * 新增时用
     * @param parameter 编码
     * @param value 名称
     */
    public LeanWorkplaceOption(String parameter, String value, String workplaceId) {
        this.parameter = parameter;
        this.value = value;
        this.workplaceId = workplaceId;
    }

    /**
     * 修改时用
     * @param id id
     * @param parameter 编码
     * @param value 名称
     */
    public LeanWorkplaceOption(String id, String parameter, String value, String workplaceId) {
        this(parameter, value, workplaceId);
        this.id = id;
    }

    /**
     * 删除用
     * @param id id
     */
    public LeanWorkplaceOption(String id) {
        this.id = id;
    }

    /**
     * 批量删除用
     * @param ids ids
     */
    public LeanWorkplaceOption(List<String> ids) {
        this.ids = ids;
    }

    public void save(LeanWorkplaceOptionRepository repository) {
        repository.save(this);
    }

    public void update(LeanWorkplaceOptionRepository repository) {
        repository.update(this);
    }

    public void delete(LeanWorkplaceOptionRepository repository) {
        repository.delete(id);
    }

    public void deleteByIds(LeanWorkplaceOptionRepository repository) {
        repository.deleteByIds(ids);
    }


}
