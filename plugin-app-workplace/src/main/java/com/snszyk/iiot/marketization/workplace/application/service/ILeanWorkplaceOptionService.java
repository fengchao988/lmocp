package com.snszyk.iiot.marketization.workplace.application.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.snszyk.iiot.marketization.workplace.application.dto.LeanWorkplaceOptionQueryDto;
import com.snszyk.iiot.marketization.workplace.infrastructure.mybatis.po.LeanWorkplaceOptionPo;
import com.snszyk.iiot.marketization.workplace.infrastructure.resource.vo.LeanWorkplaceOptionVo;
import org.jeecg.common.system.base.service.JeecgService;

import java.util.List;


/**
 * 工作地点作业参数
 *
 * @author tttt-boot
 * @version 1.0.0
 * @since 2021-01-12 16:14
 */
public interface ILeanWorkplaceOptionService extends JeecgService<LeanWorkplaceOptionPo> {
    /**
     * 查询分页数据
     * @param page 分页参数
     * @return 分页数据
     */
    IPage<LeanWorkplaceOptionVo> queryPage(LeanWorkplaceOptionQueryDto page);

    /**
     * 保存工作地点作业参数
     * @param dto dto参数
     */
    void savePo(LeanWorkplaceOptionQueryDto dto);

    /**
     * 修改工作地点作业参数
     * @param dto dto参数
     */
    void updatePo(LeanWorkplaceOptionQueryDto dto);

    /**
     * 按id删除工作地点作业参数
     * @param id id
     */
    void removePo(String id);

    /**
     * 批量删除
     * @param ids ids
     */
    void removePoByIds(List<String> ids);

    /**
     * 根据id查找对应视图对象
     * @param id id
     * @return 视图对象
     */
    LeanWorkplaceOptionVo getVoById(String id);

    List<LeanWorkplaceOptionVo> getOptionsByWorkplaceId(String id);
}
