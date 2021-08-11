package com.snszyk.iiot.marketization.demo.infrastructure.persistence.aggr;

import com.snszyk.iiot.marketization.demo.domain.position.command.PositionCreateCommand;
import com.snszyk.iiot.marketization.demo.domain.position.entity.Position;
import com.snszyk.iiot.marketization.demo.domain.position.repository.PositionRepository;
import com.snszyk.iiot.marketization.demo.domain.position.valobj.PositionId;
import com.snszyk.iiot.marketization.demo.infrastructure.persistence.aggr.jpa.PositionRepo;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 *
 * @author tengwang
 * @version 1.0.0
 * @date 2021/7/12 4:38 下午
 */
@Component
//@InvokeLogic(xxxxxxx,xxxxx)
public class PositionInfRepository implements PositionRepository {

    @Autowired
    private PositionRepo positionRepo;


    @Override
    public void clone(PositionCreateCommand command) {
        command.setOriginal(Clone.INSTANCES.clone(command));

    }

    @Override
    public Position fromId(PositionId positionId) {
        PositionPO positionPO = positionRepo.findById(positionId.getId()).orElse(null);
        //Position position = PositionPO2DomainMapper.INSTANCE.po2domain(positionPO);
        return null;
    }

    @Override
    public void remove(Position position) {
        positionRepo.deleteById(position.getPositionId().getId());
    }

    @Override
    public void save(Position position) {
//        PositionPO positionPO = PositionPO2DomainMapper.INSTANCE.domain2po(position);
//        positionRepo.save(positionPO);
    }

    @Override
    public void saveAll(List<Position> list) {
//        List<PositionPO> positionPOS =  PositionPO2DomainMapper.INSTANCE.domain2poList(list);
//        positionRepo.saveAll(positionPOS);
    }

    @Override
    public Page<Position> findAll(Pageable pageable) {
        Page<PositionPO> page = positionRepo.findAll(pageable);
        //return page.map(data->PositionPO2DomainMapper.INSTANCE.po2domain(data));
        return null;
    }



    @Override
    public Page<Position> findAll(Specification specification, Pageable pageable) {
        Page<PositionPO> positionPOSs = positionRepo.findAll(specification, pageable);
        //return positionPOSs.map(data->PositionPO2DomainMapper.INSTANCE.po2domain(data));
        return null;
    }

}

@Mapper(componentModel = "spring")
interface Clone {

    Clone INSTANCES = Mappers.getMapper(Clone.class);

    /**
     * 拷贝原始状态
     * 不是写错了 是因为拷贝到target可以使用hibernate一级缓存
     *
     * @param originalCommand
     */
    @Mappings({
            @Mapping(source = "target", target = "."),
    })
    Position clone(PositionCreateCommand originalCommand);
}
