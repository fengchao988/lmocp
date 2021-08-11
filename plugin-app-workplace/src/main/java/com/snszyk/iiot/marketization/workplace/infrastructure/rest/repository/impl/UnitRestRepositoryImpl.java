package com.snszyk.iiot.marketization.workplace.infrastructure.rest.repository.impl;

import com.alibaba.fastjson.JSONObject;
import com.snszyk.iiot.marketization.workplace.domain.intergration.unit.UnitDto;
import com.snszyk.iiot.marketization.workplace.domain.intergration.unit.UnitRestRepository;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.jeecg.common.util.RestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Repository
public class UnitRestRepositoryImpl implements UnitRestRepository {
    @Autowired
    private HttpServletRequest request;

    @Override
    public UnitDto getById(String id) {
        RestUtil.setToken(request);
        JSONObject params = new JSONObject();
        params.put("id", id);
        JSONObject result = RestUtil.get(RestUtil.getBaseUrl() + "/llot-common/measure/unit/get_by_id", params);
        if (result.getInteger("code") == 0 && result.get("data") != null) {
            return result.getJSONObject("data").toJavaObject(UnitDto.class);
        }
        return null;
    }

    @Override
    public Map<String, UnitDto> getMapByIdSet(Set<String> idSet) {
        RestUtil.setToken(request);
        String path = RestUtil.getBaseUrl() + "/llot-common/measure/unit/get_by_ids";
        if (CollectionUtils.isNotEmpty(idSet)) {
            path += ("?ids=" + StringUtils.join(idSet, "&ids="));
        }
        JSONObject result = RestUtil.get(path);
        if (result.getInteger("code") == 0 && result.get("data") != null) {
            List<UnitDto> unitDtoList = result.getJSONArray("data").toJavaList(UnitDto.class);
            return unitDtoList.stream().collect(Collectors.toMap(UnitDto::getId, u -> u));
        }
        return Collections.emptyMap();
    }
}
