package com.snszyk.iiot.marketization.measure.infrastructure.resource.view.unit;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.snszyk.iiot.marketization.measure.application.unit.MeasureUnitService;
import com.snszyk.iiot.marketization.measure.application.unit.dto.MeasureUnitCreateCommand;
import com.snszyk.iiot.marketization.measure.application.unit.dto.MeasureUnitEditCommand;
import com.snszyk.iiot.marketization.measure.application.unit.dto.MeasureUnitPageSearchCommand;
import com.snszyk.iiot.marketization.measure.domain.unitView.MeasureUnitView;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import io.ttyys.micrc.api.common.dto.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 * @author windy
 */
@Api(tags = "产品库-通用库-计量服务-计量单位")
@Slf4j
@RestController
@RequestMapping("llot-common/measure/unit")
class MeasureUnitController {

    @Autowired
    MeasureUnitService service;


    @ApiOperation("通过计量单位分类Id查询计量单位-GET")
    @GetMapping("/list")
    public Result<?> searchPageGet(
            @ApiParam(value = "计量单位分类Id", required = true) @RequestParam(required = true) String categoryId
    ) {
        try {
            List<MeasureUnitView> list = service.getMeasureUnitsByCategoryId(categoryId);
            return Result.OK(list);
        } catch (Exception e) {
            return Result.error(e.getMessage());
        }
    }

    @ApiOperation("分页查询计量单位")
    @GetMapping("/page")
    public Result<?> searchPageGet(MeasureUnitPageSearchCommand command) {
        try {
            IPage<MeasureUnitView> page = service.getMeasureUnitPages(command);
            return Result.OK(page);
        } catch (Exception e) {
            return Result.error(e.getMessage());
        }
    }

    @ApiOperation("根据Id获取计量单位")
    @GetMapping("/get_by_id")
    public Result<?> getById(@RequestParam(value = "id", required = true)
                             @ApiParam(value = "计量单位Id", required = true) String id) {
        try {
            MeasureUnitView view = service.getMeasureUnitById(id);
            return Result.OK(view);
        } catch (Exception e) {
            return Result.error(e.getMessage());
        }
    }

    @ApiOperation("根据Ids获取计量单位")
    @GetMapping("/get_by_ids")
    public Result<?> getByIds(
            @RequestParam(value = "ids", required = true) @ApiParam(value = "计量单位Ids", required = true) Set<String> ids
    ) {
        try {
            List<MeasureUnitView> viewList = service.getMeasureUnitByIds(ids);
            return Result.OK(viewList);
        } catch (Exception e) {
            return Result.error(e.getMessage());
        }
    }

    @ApiOperation("创建计量单位信息")
    @PostMapping
    public Result<?> save(@Valid @RequestBody MeasureUnitCreateCommand command, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return Result.error(Objects.requireNonNull(bindingResult.getFieldError()).getDefaultMessage());
        }
        try {
            service.create(command);
            return Result.OK();
        } catch (Exception e) {
            return Result.error(e.getMessage());
        }
    }

    @ApiOperation("修改计量单位信息")
    @PutMapping
    public Result<?> edit(@Valid @RequestBody MeasureUnitEditCommand command, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return Result.error(Objects.requireNonNull(bindingResult.getFieldError()).getDefaultMessage());
        }
        try {
            service.edit(command);
            return Result.OK();
        } catch (Exception e) {
            return Result.error(e.getMessage());
        }
    }

    @ApiOperation("删除已有的计量单位信息")
    @DeleteMapping("{id}")
    public Result<?> delete(
            @ApiParam(value = "计量单位ID", required = true) @PathVariable(value = "id", required = true) String id) {
        try {
            service.delete(id);
            return Result.OK();
        } catch (Exception e) {
            return Result.error(e.getMessage());
        }
    }

}
