package com.snszyk.iiot.marketization.base.infrastructure.api.rpc;

import com.snszyk.iiot.marketization.base.presentation.model.TreeNodeDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.ttyys.micrc.annotations.runtime.ApiQuery;
import io.ttyys.micrc.api.common.dto.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "组织结构")
@RestController
@RequestMapping("base/organization")
public class OrganizationController {

    @ApiOperation("查询组织树")
    @GetMapping("queryTree")
    @ApiQuery(serviceName = "organizationService", methodName = "queryOrganizationTree", mappingBean = "treeNodeDtoMappingImpl")
    public Result<List<TreeNodeDto>> queryTree(String id) {
        return null;
    }
}
