package com.snszyk.iiot.marketization.transaction.infrastructure.api.rpc.daliyreport;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.ttyys.micrc.annotations.runtime.ApiLogic;
import io.ttyys.micrc.api.common.dto.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 班组日报
 *
 * @author tengwang
 * @version 1.0.0
 * @date 2021/7/12 10:10 上午
 */
@Api(tags = "班组日报")
@RestController
@RequestMapping("/trans")
@Slf4j
public class DailyReportController {

    /**
     * 添加班组日报
     *
     * @param dailyReportCreateDto
     * @return
     */
    @ApiOperation("班组日报创建")
    @PostMapping("create")
    @ApiLogic(serviceName = "dailyReportCreateService", mappingBean = "dailyReportCreateTargetMapping")
    public Result<?> createDailyReport(DailyReportCreateDto dailyReportCreateDto) {
        return null;
    }
}
