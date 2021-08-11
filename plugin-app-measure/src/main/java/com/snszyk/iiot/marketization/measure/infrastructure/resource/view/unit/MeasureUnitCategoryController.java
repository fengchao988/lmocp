package com.snszyk.iiot.marketization.measure.infrastructure.resource.view.unit;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.snszyk.iiot.marketization.measure.application.unit.MeasureUnitCategoryService;
import com.snszyk.iiot.marketization.measure.application.unit.dto.MeasureUnitCategoryCreateCommand;
import com.snszyk.iiot.marketization.measure.application.unit.dto.MeasureUnitCategoryEditCommand;
import com.snszyk.iiot.marketization.measure.application.unit.dto.MeasureUnitCategoryPageSearchCommand;
import com.snszyk.iiot.marketization.measure.domain.unitView.MeasureUnitCategoryPageView;
import com.snszyk.iiot.marketization.measure.domain.unitView.MeasureUnitCategoryView;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.ttyys.micrc.api.common.dto.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Objects;

@Api(tags = "产品库-通用库-计量服务-计量单位分类")
@Slf4j
@RestController
@RequestMapping("llot-common/measure/unit_category")
class MeasureUnitCategoryController {

    @Autowired
    private MeasureUnitCategoryService service;


    @ApiOperation("列表查询计量单位分类")
    @GetMapping("/list")
    public Result<?> searchList(
            @ApiParam(value = "单位分类名称", required = false) @RequestParam(required = false) String name
    ) {
        try {
            List<?> page = service.getMeasureUnitCategoryViews(name);
            return Result.OK(page);
        } catch (Exception e) {
            return Result.error(e.getMessage());
        }
    }

    @ApiOperation("分页查询计量单位分类")
    @GetMapping("/page")
    public Result<?> searchPage(
            MeasureUnitCategoryPageSearchCommand command
    ) {
        try {
            IPage<MeasureUnitCategoryPageView> page = service.pageMeasureUnitCategoryView(command);
            return Result.OK(page);
        } catch (Exception e) {
            return Result.error(e.getMessage());
        }
    }

    @ApiOperation("根据Id获取计量单位分类")
    @GetMapping("/get_by_id")
    public Result<?> getById(
            @RequestParam(value = "id", required = true)
            @ApiParam(value = "计量单位分类Id", required = true)
                    String id) {
        try {
            MeasureUnitCategoryView view = service.getMeasureUnitCategoryById(id);
            return Result.OK(view);
        } catch (Exception e) {
            return Result.error(e.getMessage());
        }
    }

    @ApiOperation("创建计量单位分类信息")
    @PostMapping("create")
    public Result<?> save(@Valid @RequestBody MeasureUnitCategoryCreateCommand command, BindingResult bindingResult) {
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

    @ApiOperation("修改计量单位分类信息")
    @PutMapping
    public Result<?> edit(@Valid @RequestBody MeasureUnitCategoryEditCommand command, BindingResult bindingResult) {
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

    @ApiOperation("删除已有的计量单位分类")
    @DeleteMapping("{id}")
    public Result<?> delete(@ApiParam(value = "计量单位分类ID", required = true) @PathVariable(value = "id", required = true) String id) {
        try {
            service.delete(id);
            return Result.OK();
        } catch (Exception e) {
            return Result.error(e.getMessage());
        }
    }
}
