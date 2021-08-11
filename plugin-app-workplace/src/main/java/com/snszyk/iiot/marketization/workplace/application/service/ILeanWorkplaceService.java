package com.snszyk.iiot.marketization.workplace.application.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.snszyk.iiot.marketization.workplace.application.dto.LeanWorkplaceQueryDto;
import com.snszyk.iiot.marketization.workplace.infrastructure.mybatis.po.LeanWorkplacePo;
import com.snszyk.iiot.marketization.workplace.infrastructure.resource.vo.LeanWorkplaceVo;
import org.jeecg.common.system.base.service.JeecgService;

import java.util.List;


/**
 * 工作地点
 *
 * @author tttt-boot
 * @version 1.0.0
 * @since 2021-01-12 16:13
 */
public interface ILeanWorkplaceService  extends JeecgService<LeanWorkplacePo> {
    /**
     * 查询分页数据
     * @param page 分页参数
     * @return 分页数据
     */
    IPage<LeanWorkplaceVo> queryPage(LeanWorkplaceQueryDto page);

    /**
     * 保存工作地点
     * @param dto dto参数
     */
    void savePo(LeanWorkplaceQueryDto dto);

    /**
     * 修改工作地点
     * @param dto dto参数
     */
    void updatePo(LeanWorkplaceQueryDto dto);

    /**
     * 按id删除工作地点
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
    LeanWorkplaceVo getVoById(String id);

    /**
     * 批量添加
     *
     * @param dto
     */
    void batchCreate(LeanWorkplaceQueryDto dto);

    /**
     * 按id集合查工作地点集合
     *
     * @param idList id list
     * @return 工作地点集合
     */
    List<LeanWorkplaceVo> queryListByIds(List<String> idList);

    /**
     * 根据工作地点名称查询
     * @param name 地点名称
     * @return
     */
    LeanWorkplaceVo queryByName(String name);
}
