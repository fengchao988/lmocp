package com.snszyk.iiot.marketization.measure.infrastructure.resource.rest;

import com.snszyk.iiot.marketization.measure.application.unit.MeasureUnitService;
import com.snszyk.iiot.marketization.measure.domain.unitView.MeasureUnitView;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.ttyys.micrc.api.common.dto.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

/**
 * @author windy
 */
@Api(tags = "产品库-通用库-计量服务-计量单位-后端调用接口")
@Slf4j
@RestController("MeasureUnitApiRestController")
@RequestMapping("api/rest/measure/unit")
class MeasureUnitController {

    @Autowired
    MeasureUnitService service;

    @ApiOperation("根据Id获取计量单位")
    @GetMapping("/get_by_id")
    public Result<?> getById(@RequestParam(value = "id")
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
            @RequestParam(value = "ids") @ApiParam(value = "计量单位Ids", required = true) Set<String> ids
    ) {
        try {
            List<MeasureUnitView> viewList = service.getMeasureUnitByIds(ids);
            return Result.OK(viewList);
        } catch (Exception e) {
            return Result.error(e.getMessage());
        }
    }
}
