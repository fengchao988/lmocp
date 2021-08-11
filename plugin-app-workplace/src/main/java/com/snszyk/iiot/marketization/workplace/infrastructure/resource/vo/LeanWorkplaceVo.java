package com.snszyk.iiot.marketization.workplace.infrastructure.resource.vo;

import com.snszyk.iiot.marketization.workplace.domain.model.enums.WorkplaceType;
import com.snszyk.iiot.marketization.workplace.infrastructure.mybatis.po.LeanWorkplacePo;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.util.List;

/**
 * 工作地点 界面呈现视图对象vo
 *
 * @author tttt-boot
 * @version 1.0.0
 * @since 2021-01-12 16:13
 */
@Data
@NoArgsConstructor
public class LeanWorkplaceVo {
    /**
     * 主键
     */
    @ApiModelProperty("主键")
    private String id;
    /**
     * 编号
     */
    @ApiModelProperty("编号")
    private String code;
    /**
     * 工作地点
     */
    @ApiModelProperty("工作地点")
    private String name;
    /**
     * 类型
     */
    @ApiModelProperty("类型")
    private WorkplaceType type;

    private List<LeanWorkplaceOptionVo> options;

    private String typeName;

    @ApiModelProperty("操作人")
    private String creatorName;

    public LeanWorkplaceVo(LeanWorkplacePo po) {
        BeanUtils.copyProperties(po, this);
        if (null != type) {
            this.typeName = type.getLabel();
        }
    }
}
