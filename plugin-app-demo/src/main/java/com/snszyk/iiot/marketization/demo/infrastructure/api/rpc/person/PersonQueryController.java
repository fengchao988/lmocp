package com.snszyk.iiot.marketization.demo.infrastructure.api.rpc.person;

import com.snszyk.iiot.marketization.demo.presentation.person.model.*;
import com.snszyk.iiot.marketization.demo.presentation.position.model.PositionQueryMapping;
import com.snszyk.iiot.marketization.demo.presentation.position.model.PositionQueryModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.ttyys.micrc.annotations.runtime.ApiQuery;
import io.ttyys.micrc.api.common.dto.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

/**
 * 岗位Rest
 *
 * @author tengwang
 * @version 1.0.0
 * @date 2021/7/12 10:10 上午
 */
@Api(tags = "人员")
@RestController
@RequestMapping("/person")
@Slf4j
public class PersonQueryController {
    /**
     * 模块内广播
     */
    @Autowired
    private ApplicationEventPublisher broadcast;

    @ApiOperation("列表")
    @GetMapping("queryList")
    @ApiQuery(serviceName = "personQueryService", methodName = "queryList", mappingBean = "personQueryMappingImpl")
    public Result<List<PersonQueryModel>> list(PersonQueryModel person) {
        return null;
    }

    @ApiOperation("按名称查询")
    @GetMapping("queryName")
    @ApiQuery(serviceName = "personQueryService", methodName = "queryByName", mappingBean = "personQueryMappingImpl")
    public Result<PersonQueryModel> findByName(PersonQueryModel person) {
        return null;
    }


    @ApiOperation("模拟用户事件")
    @PostMapping("testUserEvent")
    public Result<?> testUserEvent(@RequestBody UserModel user) {
        Object source;
        if (new Random().nextInt() % 2 == 0) {
            source = "";
        } else {
            // source = PersonMapping.INSTANCES.user2User(user);
            //UserModel old = (UserModel) source;
            //old.setName("");
            //old.setPositionId("");
        }
        //UserEvent event = new UserEvent(source, user);
        //broadcast.publishEvent(event);
        return Result.OK();
    }

    @ApiOperation("模拟岗位事件")
    @PostMapping("testPositionEvent")
    public Result<?> testPositionEvent(@RequestBody PositionQueryModel position) {
        PositionQueryModel source = PositionQueryMapping.INSTANCES.toData(position);
        source.setName("");
        PositionEvent event = new PositionEvent(source, position);
        broadcast.publishEvent(event);
        return Result.OK();
    }
}
