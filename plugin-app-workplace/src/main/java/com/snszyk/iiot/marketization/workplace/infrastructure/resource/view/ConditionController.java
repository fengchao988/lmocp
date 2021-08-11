package com.snszyk.iiot.marketization.workplace.infrastructure.resource.view;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.snszyk.iiot.marketization.workplace.application.dto.condition.ConditionMakeCommand;
import com.snszyk.iiot.marketization.workplace.application.dto.condition.ConditionModifyCommand;
import com.snszyk.iiot.marketization.workplace.application.dto.condition.ConditionSearchCommand;
import com.snszyk.iiot.marketization.workplace.application.service.ConditionService;
import com.snszyk.iiot.marketization.workplace.domain.condition.model.ConditionType;
import com.snszyk.iiot.marketization.workplace.domain.conditionView.ConditionPageView;
import com.snszyk.iiot.marketization.workplace.domain.conditionView.ConditionView;
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
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * 条件写Rest端口
 *
 * @author tengwang
 */
@Api(tags = "产品库-通用库-工作地点-条件库")
@Slf4j
@RestController
@RequestMapping("llot-common/workplace/condition")
public class ConditionController {

    @Autowired
    private ConditionService service;


    @ApiOperation("分页查询条件")
    @PostMapping("/page")
    // 这里有个swagger和groovy的严重bug 这里如果用groovy对象接,则必须使用RequestBody 否则会导致swagger对metaclass进行发现导致死循环
    public Result<?> searchPage(@Valid @RequestBody ConditionSearchCommand command, BindingResult bindingResult) {
        // 查询也有可能有必传的一些属性校验,所以应该放置一个Jsr303的检索方式
        if (bindingResult.hasErrors()) {
            return Result.error(Objects.requireNonNull(bindingResult.getFieldError()).getDefaultMessage());
        }
        try {
            IPage<ConditionPageView> page = service.getPage(command);
            return Result.OK(page);
        } catch (Exception e) {
            return Result.error(e.getMessage());
        }
    }

    @ApiOperation("分页查询条件")
    @GetMapping("/page")
    public Result<?> searchPageGet(
            @ApiParam(value = "每页显示条数", required = true) @RequestParam(required = true, defaultValue = "10") Integer pageSize,
            @ApiParam(value = "当前页", required = true) @RequestParam(required = true, defaultValue = "1") Integer pageNo,
            @ApiParam(value = "条件名称", required = false) @RequestParam(required = false) String name,
            @ApiParam(value = "条件编码", required = false) @RequestParam(required = false) String code,
            @ApiParam(value = "条件类型", required = false) @RequestParam(required = false) ConditionType conditionType
    ) {
        try {
            ConditionSearchCommand command = new ConditionSearchCommand(name, code, conditionType);
            command.setPageNo(pageNo);
            command.setPageSize(pageSize);
            IPage<ConditionPageView> page = service.getPage(command);
            return Result.OK(page);
        } catch (Exception e) {
            return Result.error(e.getMessage());
        }
    }

    @ApiOperation("列表查询条件")
    @PostMapping("/list")
    public Result<?> searchList(@Valid @RequestBody ConditionSearchCommand command, BindingResult bindingResult) {
        // 查询也有可能有必传的一些属性校验,所以应该放置一个Jsr303的检索方式
        if (bindingResult.hasErrors()) {
            return Result.error(Objects.requireNonNull(bindingResult.getFieldError()).getDefaultMessage());
        }
        try {
            List<?> page = service.getList(command);
            return Result.OK(page);
        } catch (Exception e) {
            return Result.error(e.getMessage());
        }
    }

    @ApiOperation("列表查询条件")
    @PostMapping("/list_by_ids")
    public Result<?> searchListByIds(@Valid @RequestBody Set<String> ids, BindingResult bindingResult) {
        // 查询也有可能有必传的一些属性校验,所以应该放置一个Jsr303的检索方式
        if (bindingResult.hasErrors()) {
            return Result.error(Objects.requireNonNull(bindingResult.getFieldError()).getDefaultMessage());
        }
        try {
            List<?> page = service.getConditionByIds(ids);
            return Result.OK(page);
        } catch (Exception e) {
            return Result.error(e.getMessage());
        }
    }

    @ApiOperation("查询所有条件类型")
    @GetMapping("/condition_types")
    public Result<?> conditionTypes() {
        try {
            Map<String, Object> contentTypes = service.getConditionTypeMap();
            return Result.OK(contentTypes);
        } catch (Exception e) {
            return Result.error(e.getMessage());
        }
    }

    @ApiOperation("根据Code获取条件")
    @GetMapping("/get_condition_by_code")
    public Result<?> getConditionByCode(
            @RequestParam(value = "code", required = true)
            @ApiParam(value = "条件编码", required = true) String code) {
        try {
            ConditionView condition = service.getConditionByCode(code);
            return Result.OK(condition);
        } catch (Exception e) {
            return Result.error(e.getMessage());
        }
    }

    @ApiOperation("根据Id获取条件")
    @GetMapping("/get_condition_by_id")
    public Result<?> getConditionById(
            @RequestParam(value = "id", required = true)
            @ApiParam(value = "条件Id", required = true)
                    String id) {
        try {
            ConditionView condition = service.getConditionById(id);
            return Result.OK(condition);
        } catch (Exception e) {
            return Result.error(e.getMessage());
        }
    }

    @ApiOperation("编制条件")
    @PostMapping("/make")
    public Result<?> makeCondition(@Valid @RequestBody ConditionMakeCommand conditionMakeCommand, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return Result.error(Objects.requireNonNull(bindingResult.getFieldError()).getDefaultMessage());
        }
        try {
            service.make(conditionMakeCommand);
            return Result.OK();
        } catch (Exception e) {
            return Result.error(e.getMessage());
        }
    }

    @ApiOperation("修改条件信息")
    @PutMapping("/modify_info/{id}")
    public Result<?> modifyConditionInfo(@Valid @RequestBody ConditionModifyCommand command, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return Result.error(Objects.requireNonNull(bindingResult.getFieldError()).getDefaultMessage());
        }
        try {
            service.modify(command);
            return Result.OK();
        } catch (Exception e) {
            return Result.error(e.getMessage());
        }
    }

    @ApiOperation("移除条件")
    @DeleteMapping("/delete/{id}")
    public Result<?> modifyConditionInfo(
            @ApiParam(value = "条件ID", required = true) @PathVariable(value = "id", required = true) String id
    ) {
        try {
            service.delete(id);
            return Result.OK();
        } catch (Exception e) {
            return Result.error(e.getMessage());
        }
    }
}
