package com.snszyk.iiot.marketization.workplace.infrastructure.resource.view;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.snszyk.iiot.marketization.workplace.application.dto.LeanWorkplaceOptionQueryDto;
import com.snszyk.iiot.marketization.workplace.application.service.impl.LeanWorkplaceOptionServiceImpl;
import com.snszyk.iiot.marketization.workplace.infrastructure.mybatis.po.LeanWorkplaceOptionPo;
import com.snszyk.iiot.marketization.workplace.infrastructure.resource.vo.LeanWorkplaceOptionVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.ttyys.micrc.api.common.dto.Result;
import org.jeecg.common.aspect.annotation.AutoLog;
import org.jeecg.common.system.base.controller.JeecgController;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * 工作地点作业参数 控制器 --
 * 工作地点条件因没有设计管理页面，故作业条件数据维护在字典表中。
 * 计量数据仍维护在lc_workplace_condition_value表中，根据作业条件的key值关联计量数据
 *
 * @author tttt-boot
 * @version 1.0.0
 * @since 2021-01-12 16:14
 */
@Api(tags = "产品库-通用库-工作地点-地点条件")
@RestController
@RequestMapping("llot-common/workplace/option")
public class LeanWorkplaceOptionController extends JeecgController<LeanWorkplaceOptionPo, LeanWorkplaceOptionServiceImpl> {
    /**
     * 分页列表查询
     *
     * @param pageDto 分页参数
     * @return 分页数据
     */
    @GetMapping("/list")
    @ApiOperation("分页列表查询")
    public Result<?> queryPageList(LeanWorkplaceOptionQueryDto pageDto) {
        IPage<LeanWorkplaceOptionVo> page = service.queryPage(pageDto);
        return Result.OK(page);
    }

    /**
     * 添加
     *
     * @param leanWorkplaceOption 数据传输对象
     * @return 结果响应
     */
    @AutoLog("添加")
    @PostMapping("/add")
    @ApiOperation("添加")
    public Result<?> add(@RequestBody LeanWorkplaceOptionQueryDto leanWorkplaceOption) {
        service.savePo(leanWorkplaceOption);
        return Result.OK("添加成功！");
    }

    /**
     * 编辑
     *
     * @param leanWorkplaceOption form对象
     * @return 结果响应
     */
    @AutoLog("编辑")
    @PutMapping("/edit")
    @ApiOperation("编辑")
    public Result<?> edit(@RequestBody LeanWorkplaceOptionQueryDto leanWorkplaceOption) {
        service.updatePo(leanWorkplaceOption);
        return Result.OK("修改成功!");

    }

    /**
     * 通过id删除
     *
     * @param id id
     * @return 结果响应
     */
    @AutoLog("通过id删除")
    @DeleteMapping("/delete")
    @ApiOperation("通过id删除")
    public Result<?> delete(@RequestParam("id") String id) {
        service.removePo(id);
        return Result.OK("删除成功!");
    }

    /**
     * 批量删除
     *
     * @param ids ids
     * @return 结果响应
     */
    @AutoLog("批量删除")
    @DeleteMapping("/deleteBatch")
    @ApiOperation("批量删除")
    public Result<?> deleteBatch(@RequestParam("ids") List<String> ids) {
        service.removePoByIds(ids);
        return Result.OK("删除成功!");
    }

    /**
     * 通过id查询
     *
     * @param id id
     * @return 结果响应
     */
    @AutoLog("通过id查询")
    @GetMapping("/queryById")
    @ApiOperation("通过id查询")
    public Result<?> queryById(@RequestParam("id") String id) {
        LeanWorkplaceOptionVo leanWorkplaceOption = service.getVoById(id);
        return Result.OK(leanWorkplaceOption);
    }

    @AutoLog("通过工作地点id查询项")
    @GetMapping("/queryByWorkplaceId")
    public Result<?> queryByWorkplaceId(@RequestParam("id") String id) {
        List<LeanWorkplaceOptionVo> vos = service.getOptionsByWorkplaceId(id);
        return Result.OK(vos);
    }
}
