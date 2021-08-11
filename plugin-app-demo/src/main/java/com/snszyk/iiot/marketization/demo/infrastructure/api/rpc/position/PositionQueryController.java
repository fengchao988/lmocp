package com.snszyk.iiot.marketization.demo.infrastructure.api.rpc.position;

import com.snszyk.iiot.marketization.demo.domain.position.entity.Position;
import com.snszyk.iiot.marketization.demo.presentation.position.model.PositionQueryModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.ttyys.micrc.annotations.runtime.ApiQuery;
import io.ttyys.micrc.api.common.dto.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 岗位Rest
 *
 * @author tengwang
 * @version 1.0.0
 * @date 2021/7/12 10:10 上午
 */
@Api(tags = "岗位")
@RestController
@RequestMapping("/position")
@Slf4j
public class PositionQueryController {
    @ApiOperation("列表")
    @GetMapping("queryList")
    @ApiQuery(serviceName = "positionQueryService", methodName = "queryList", mappingBean = "positionQueryMappingImpl")
    public Result<List<Position>> list(PositionQueryModel position) {
        return null;
    }

    @ApiOperation("按名称查询")
    @GetMapping("queryName")
    @ApiQuery(serviceName = "positionQueryService", methodName = "queryByName", mappingBean = "positionQueryMappingImpl")
    public Result<Position> findByName(Position position) {
        return null;
    }
}
