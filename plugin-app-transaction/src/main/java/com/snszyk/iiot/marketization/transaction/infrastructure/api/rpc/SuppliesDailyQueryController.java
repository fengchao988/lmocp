package com.snszyk.iiot.marketization.transaction.infrastructure.api.rpc;

import com.snszyk.iiot.marketization.transaction.presentation.model.SuppliesDailyQueryModel;
import com.snszyk.iiot.marketization.transaction.presentation.model.SuppliesDailyQueryParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.ttyys.micrc.annotations.runtime.ApiQuery;
import io.ttyys.micrc.api.common.dto.Result;
import lombok.extern.slf4j.Slf4j;
import org.jeecg.common.system.base.dto.ResponsePage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 岗位Rest
 *
 * @author tengwang
 * @version 1.0.0
 * @date 2021/7/12 10:10 上午
 */
@Api(tags = "物资日报")
@RestController
@RequestMapping("/transaction/supplies")
@Slf4j
public class SuppliesDailyQueryController {

    @ApiOperation("分页列表")
    @GetMapping("queryPage")
    @ApiQuery(serviceName = "suppliesDailyQueryService", methodName = "queryPage", mappingBean = "suppliesDailyQueryModelMappingImpl")
    public Result<ResponsePage<SuppliesDailyQueryModel>> queryPage(SuppliesDailyQueryParam param) {
        return null;
    }

}
