package com.snszyk.iiot.marketization.demo.application.service.position;

import com.snszyk.iiot.marketization.demo.CommandExecutor;
import com.snszyk.iiot.marketization.demo.domain.position.command.PositionCreateCommand;
import com.snszyk.iiot.marketization.demo.domain.position.command.PositionCreateCommandLogic;
import com.snszyk.iiot.marketization.demo.domain.position.entity.Position;
import com.snszyk.iiot.marketization.demo.domain.position.repository.PositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

/**
 * 创建岗位应用服务
 *
 * @author tengwang
 * @version 1.0.0
 * @date 2021/7/12 9:45 上午
 */
@Service
public class PositionCreateService {

    /**
     * 模块内广播
     */
    @Autowired
    private ApplicationEventPublisher broadcast;

    @Autowired
    private PositionRepository positionRepository;

    public void execute(PositionCreateCommand command) {
        // 1.校验Command状态
        // TODO 校验状态
        // 2.填充command -- 资源库的查询(特定),集成接口调用,fromById以及Copy原始状态
        command.setTarget(new Position());
        positionRepository.clone(command);
//        Copy.INSTANCES.clone(command);
        // 3.调用Command里的转换方法,得到领域模型
        PositionCreateCommandLogic.INSTANCES.exec(command);
        positionRepository.save(command.getTarget());
        // 4.校验处理完成状态
        // TODO 校验状态
        // 5.发送事件
        broadcast.publishEvent(command.getEvent());
        //integrationService.send();
    }
}
