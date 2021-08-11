package com.snszyk.iiot.marketization.base.presentation.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@ApiModel("界面树结构对象")
@NoArgsConstructor
public class TreeNodeDto {
    @ApiModelProperty("主键标识")
    private String key;
    @ApiModelProperty("名称")
    private String title;
    @ApiModelProperty("子级列表")
    private List<TreeNodeDto> children;

    public TreeNodeDto(Organization organization, List<TreeNodeDto> children) {
        key = organization.getId();
        title = organization.getName();
        this.children = children;
    }
}
