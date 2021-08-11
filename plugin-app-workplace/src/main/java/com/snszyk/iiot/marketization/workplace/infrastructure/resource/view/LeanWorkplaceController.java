package com.snszyk.iiot.marketization.workplace.infrastructure.resource.view;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.snszyk.iiot.marketization.workplace.application.dto.LeanWorkplaceQueryDto;
import com.snszyk.iiot.marketization.workplace.application.service.impl.LeanWorkplaceServiceImpl;
import com.snszyk.iiot.marketization.workplace.domain.model.enums.WorkplaceType;
import com.snszyk.iiot.marketization.workplace.infrastructure.mybatis.po.LeanWorkplacePo;
import com.snszyk.iiot.marketization.workplace.infrastructure.resource.vo.LeanWorkplaceTypeVo;
import com.snszyk.iiot.marketization.workplace.infrastructure.resource.vo.LeanWorkplaceVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.ttyys.micrc.api.common.dto.Result;
import org.jeecg.common.aspect.annotation.AutoLog;
import org.jeecg.common.system.base.controller.JeecgController;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


/**
 * 工作地点 控制器
 *
 * @author tttt-boot
 * @version 1.0.0
 * @since 2021-01-12 16:13
 */
@Api(tags = "产品库-通用库-工作地点-基本信息")
@RestController
@RequestMapping("llot-common/workplace/info")
public class LeanWorkplaceController extends JeecgController<LeanWorkplacePo, LeanWorkplaceServiceImpl> {
    /**
     * 分页列表查询
     *
     * @param pageDto 分页参数
     * @return 分页数据
     */
    @GetMapping("/list")
    @ApiOperation("分页列表查询")
    public Result<IPage<LeanWorkplaceVo>> queryPageList(LeanWorkplaceQueryDto pageDto) {
        IPage<LeanWorkplaceVo> page = service.queryPage(pageDto);
        return Result.OK(page);
    }

    /**
     * 添加
     *
     * @param leanWorkplace 数据传输对象
     * @return 结果响应
     */
    @AutoLog("添加")
    @PostMapping("/add")
    @ApiOperation("添加")
    public Result<?> add(@RequestBody LeanWorkplaceQueryDto leanWorkplace) {
        service.savePo(leanWorkplace);
        return Result.OK("添加成功！");
    }

    /**
     * 编辑
     *
     * @param leanWorkplace form对象
     * @return 结果响应
     */
    @AutoLog("编辑")
    @PutMapping("/edit")
    @ApiOperation("编辑")
    public Result<?> edit(@RequestBody LeanWorkplaceQueryDto leanWorkplace) {
        service.updatePo(leanWorkplace);
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

    @AutoLog("添加/修改(带工作地点条件)")
    @PostMapping("/addBatch")
    @ApiOperation("添加/修改(带工作地点条件)")
    public Result<?> addBatch(@RequestBody LeanWorkplaceQueryDto dto) {
        service.batchCreate(dto);
        return Result.OK("添加成功！");
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
        LeanWorkplaceVo leanWorkplace = service.getVoById(id);
        return Result.OK(leanWorkplace);
    }

    @AutoLog("查询分类")
    @ApiOperation("查询分类")
    @GetMapping("type")
    public Result<?> getTypes() {
        List<LeanWorkplaceTypeVo> parameterVos = Stream.of(WorkplaceType.values())
                .map(LeanWorkplaceTypeVo::new).collect(Collectors.toList());
        return Result.OK(parameterVos);

    }

    @AutoLog("全部")
    @GetMapping("all")
    public Result<?> all() {
        List<LeanWorkplaceVo> leanWorkplaceVos = service.list().stream()
                .map(LeanWorkplaceVo::new).collect(Collectors.toList());
        return Result.OK(leanWorkplaceVos);
    }
}
