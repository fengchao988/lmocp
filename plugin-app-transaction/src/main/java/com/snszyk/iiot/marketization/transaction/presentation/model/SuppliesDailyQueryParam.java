package com.snszyk.iiot.marketization.transaction.presentation.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.commons.lang3.StringUtils;
import org.jeecg.common.system.base.dto.RequestPage;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel("物资日报查询参数")
public class SuppliesDailyQueryParam extends RequestPage {
    @ApiModelProperty("开始业务时间")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date start;
    @ApiModelProperty("终止业务时间")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date end;
    @ApiModelProperty("状态")
    private String status;

    /**
     * 生成查询条件
     *
     * @return 查询条件
     */
    public Specification<SuppliesDailyQueryModel> generateSpecification() {
        return (Root<SuppliesDailyQueryModel> root, CriteriaQuery<?> query, CriteriaBuilder builder) -> {
            Predicate predicate = null;
            if (start != null && end != null) {
                predicate = builder.between(root.get("businessDate"), start, end);
            } else if (start != null) {
                predicate = builder.greaterThanOrEqualTo(root.get("businessDate"), start);
            } else if (end != null) {
                predicate = builder.lessThanOrEqualTo(root.get("businessDate"), end);
            }
            if (StringUtils.isNotBlank(status)) {
                Predicate temp = builder.equal(root.get("status"), status);
                if (predicate == null) {
                    predicate = temp;
                } else {
                    predicate = builder.and(predicate, temp);
                }
            }
            return predicate;
        };
    }
}
