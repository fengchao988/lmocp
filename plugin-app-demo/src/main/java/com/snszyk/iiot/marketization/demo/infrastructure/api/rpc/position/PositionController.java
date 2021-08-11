package com.snszyk.iiot.marketization.demo.infrastructure.api.rpc.position;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.ttyys.micrc.annotations.runtime.ApiLogic;
import io.ttyys.micrc.api.common.dto.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 岗位
 *
 * @author tengwang
 * @version 1.0.0
 * @date 2021/7/12 10:10 上午
 */
@Api(tags = "岗位")
@RestController
@RequestMapping("/base_lib")
@Slf4j
public class PositionController {

    /**
     * 添加岗位 内部模拟路由逻辑
     *
     * @param positionCreateDto
     * @return
     */
    @ApiOperation("岗位新增")
    @PostMapping("position")
    @ApiLogic(serviceName = "positionCreateService", mappingBean = "positionCreateTargetMappingImpl")
    public Result<?> createPosition(PositionCreateDto positionCreateDto) {
        return null;
    }
}
