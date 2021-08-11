package com.snszyk.iiot.marketization.workplace.domain.intergration.unit;


import io.ttyys.micrc.annotations.technology.LocalTransferProducer;

import java.util.Map;
import java.util.Set;

/**
 * 基础库调用工业互联接口-计量单位
 */
@LocalTransferProducer("unit")
public interface UnitRestRepository {
    /**
     * 按id查找计量单位
     *
     * @param id id
     * @return 计量单位
     */
    UnitDto getById(String id);

    /**
     * 按id查找计量单位
     *
     * @param idSet id集合
     * @return 计量单位
     */
    Map<String, UnitDto> getMapByIdSet(Set<String> idSet);
}
