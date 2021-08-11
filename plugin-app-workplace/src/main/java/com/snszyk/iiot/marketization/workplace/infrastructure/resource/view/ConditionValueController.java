package com.snszyk.iiot.marketization.workplace.infrastructure.resource.view;


import com.snszyk.iiot.marketization.workplace.application.dto.conditionValue.MakeCommand;
import com.snszyk.iiot.marketization.workplace.application.dto.conditionValue.ModifyCommand;
import com.snszyk.iiot.marketization.workplace.application.service.ConditionValueService;
import com.snszyk.iiot.marketization.workplace.domain.conditionView.ConditionValueView;
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

/**
 * 条件值Rest端口
 *
 * @author tengwang
 */
@Api(tags = "产品库-通用库-工作地点-条件值")
@Slf4j
@RestController
@RequestMapping("llot-common/workplace/condition_value")
public class ConditionValueController {

    @Autowired
    private ConditionValueService service;

    @ApiOperation("得到一个条件下的所有条件参数")
    @GetMapping("/condition_value_list")
    public Result<?> searchPage(
            @RequestParam(value = "conditionId", required = true)
            @ApiParam(value = "条件Code", required = true) String conditionId) {
        try {
            List<ConditionValueView> conditions = service.getConditionValueList(conditionId);
            return Result.OK(conditions);
        } catch (Exception e) {
            return Result.error(e.getMessage());
        }
    }

    @ApiOperation("编制条件值")
    @PostMapping("/make")
    public Result<?> makeConditionValue(@Valid @RequestBody MakeCommand command, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return Result.error(Objects.requireNonNull(bindingResult.getFieldError()).getDefaultMessage());
        }
        try {
            service.make(command);
            return Result.OK();
        } catch (Exception e) {
            return Result.error(e.getMessage());
        }
    }

    @ApiOperation("修改条件值信息")
    @PutMapping("/modify_info/{id}")
    public Result<?> modifyConditionValueInfo(@Valid @RequestBody ModifyCommand command,
                                              @ApiParam(value = "条件值ID", required = true) @PathVariable(value = "id", required = true) String id,
                                              BindingResult bindingResult) {
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

    @ApiOperation("移除条件值")
    @DeleteMapping("/delete/{id}")
    public Result<?> deleteConditionValue(String conditionId,
                                          @ApiParam(value = "条件值ID", required = true) @PathVariable(value = "id", required = true) String id
    ) {
        try {
            service.delete(id, conditionId);
            return Result.OK();
        } catch (Exception e) {
            return Result.error(e.getMessage());
        }
    }
}
