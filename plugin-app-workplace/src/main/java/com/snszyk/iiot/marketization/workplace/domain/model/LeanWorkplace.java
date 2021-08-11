package com.snszyk.iiot.marketization.workplace.domain.model;

import com.snszyk.iiot.marketization.workplace.domain.model.enums.WorkplaceType;
import com.snszyk.iiot.marketization.workplace.domain.repository.LeanWorkplaceRepository;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;
import org.jeecg.common.exception.JeecgBootException;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 工作地点 领域对象domain
 *
 * @author tttt-boot
 * @version 1.0.0
 * @since 2021-01-12 16:13
 */
@Getter
@NoArgsConstructor
public class LeanWorkplace {
    /**
     * 主键
     */
    @Setter
    @Getter
    private String id;
    /**
     * 工作地点
     */
    private String name;
    /**
     * 类型
     */
    private WorkplaceType type;
    /**
     * 批量删除用
     */
    private List<String> ids;

    private List<LeanWorkplaceOption> options;

    public LeanWorkplace(String id, String name, WorkplaceType type) {
        this.id = id;
        this.name = name;
        this.type = type;
    }

    public LeanWorkplace(String id, String name, WorkplaceType type, List<LeanWorkplaceOption> leanWorkplaceOptions) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.options = leanWorkplaceOptions;
    }

    /**
     * 删除用
     *
     * @param id id
     */
    public LeanWorkplace(String id) {
        this.id = id;
    }

    /**
     * 批量删除用
     *
     * @param ids ids
     */
    public LeanWorkplace(List<String> ids) {
        this.ids = ids;
    }

    public void save(LeanWorkplaceRepository repository) {
        checkName(repository);
        repository.save(this);
    }

    public void update(LeanWorkplaceRepository repository) {
        checkName(repository);
        repository.update(this);
    }


    public void batchCreate(LeanWorkplaceRepository repository) {
        checkName(repository);
        if (StringUtils.isNotEmpty(this.id)) {
            repository.update(this);
        } else {
            repository.create(this);
        }
        if (null != this.options) {
            List<LeanWorkplaceOption> batchUpdate = this.options.stream()
                    .filter(leanWorkplaceOption -> StringUtils.isNotEmpty(leanWorkplaceOption.getId()))
                    .collect(Collectors.toList());

            List<LeanWorkplaceOption> batchAdd = this.options.stream()
                    .filter(leanWorkplaceOption -> StringUtils.isEmpty(leanWorkplaceOption.getId()))
                    .peek(leanWorkplaceOption -> leanWorkplaceOption.setWorkplaceId(this.id))
                    .collect(Collectors.toList());

            repository.batchCreateOptions(batchAdd);
            repository.batchModifyOptions(batchUpdate);
        }
    }

    public void delete(LeanWorkplaceRepository repository) {
        repository.delete(id);
    }

    public void deleteByIds(LeanWorkplaceRepository repository) {
        repository.deleteByIds(ids);
    }

    /**
     * 校验名称是否正确
     */
    private void checkName(LeanWorkplaceRepository repository) {
        if (StringUtils.isEmpty(name)) {
            throw new JeecgBootException("工作地点名称不能为空.");
        }
        if (repository.existsName(this)) {
            throw new JeecgBootException(String.format("工作地点名称【%s】不能重复.", name));
        }
    }

}
