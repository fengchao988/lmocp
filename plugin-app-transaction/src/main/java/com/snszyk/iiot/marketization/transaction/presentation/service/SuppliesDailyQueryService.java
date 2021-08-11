package com.snszyk.iiot.marketization.transaction.presentation.service;

import com.snszyk.iiot.marketization.transaction.presentation.model.SuppliesDailyQuery;
import com.snszyk.iiot.marketization.transaction.presentation.model.SuppliesDailyQueryModel;
import com.snszyk.iiot.marketization.transaction.presentation.model.SuppliesDailyQueryParam;
import org.jeecg.common.system.base.dto.ResponsePage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class SuppliesDailyQueryService {

    @Autowired
    private SuppliesDailyQuery suppliesDailyQuery;

    public ResponsePage<SuppliesDailyQueryModel> queryPage(SuppliesDailyQueryParam param) {
        Page<SuppliesDailyQueryModel> page = suppliesDailyQuery.findAll(param.generateSpecification(), param.initPageable());
        return new ResponsePage<SuppliesDailyQueryModel>(page);
    }
}
