package com.snszyk.iiot.marketization.workplace.infrastructure.resource.rest;


import cn.hutool.json.JSONArray;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.snszyk.iiot.marketization.workplace.application.dto.LeanWorkplaceQueryDto;
import com.snszyk.iiot.marketization.workplace.application.service.impl.LeanWorkplaceServiceImpl;
import com.snszyk.iiot.marketization.workplace.infrastructure.mybatis.po.LeanWorkplacePo;
import com.snszyk.iiot.marketization.workplace.infrastructure.resource.vo.LeanWorkplaceVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.ttyys.micrc.api.common.dto.Result;
import org.jeecg.common.system.base.controller.JeecgController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 工作地点 接口提供
 *
 * @author zhaowang
 * @version 1.0.0
 * @since 2021-01-26 10:13
 */
@Api(tags = "基础库-工作地点 接口提供")
@RestController
@RequestMapping("/api/rest/base/workplace")
public class WorkspaceRestController extends JeecgController<LeanWorkplacePo, LeanWorkplaceServiceImpl> {
    /**
     * 分页列表查询
     *
     * @param page 分页参数
     * @return 分页数据
     */
    @GetMapping("queryPage")
    @ApiOperation("分页列表查询")
    public Result<IPage<LeanWorkplaceVo>> queryPage(LeanWorkplaceQueryDto page) {
        IPage<LeanWorkplaceVo> pageList = service.queryPage(page);
        return Result.OK(pageList);
    }

    /**
     * 按id list查列表
     *
     * @param idList idList
     * @return 数据集合
     */
    @GetMapping("queryListByIds")
    @ApiOperation("按id list查列表")
    public Result<?> queryListByIds(String idList) {
        List<LeanWorkplaceVo> list = service.queryListByIds(new JSONArray(idList).toList(String.class));
        return Result.OK(list);
    }

    /**
     * 通过id查询
     *
     * @param id id
     * @return 结果响应
     */
    @GetMapping("queryById")
    @ApiOperation("通过id查询")
    public Result<?> queryById(String id) {
        LeanWorkplaceVo leanWorkplace = service.getVoById(id);
        return Result.OK(leanWorkplace);
    }
}
