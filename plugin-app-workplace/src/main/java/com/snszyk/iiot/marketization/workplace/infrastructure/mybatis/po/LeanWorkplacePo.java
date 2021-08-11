package com.snszyk.iiot.marketization.workplace.infrastructure.mybatis.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.snszyk.iiot.marketization.workplace.domain.model.enums.WorkplaceType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.jeecg.common.system.base.entity.JeecgEntity;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;


/**
 * 产品库-通用库-工作地点-基本信息 po
 *
 * @author tttt-boot
 * @version 1.0.0
 * @since 2021-01-12 16:13
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("lc_workplace_info")
@NoArgsConstructor
public class LeanWorkplacePo extends JeecgEntity {
    /**
     * 工作地点
     */
    private String name;
    /**
     * 类型
     */
    @Enumerated(EnumType.STRING)
    private WorkplaceType type;
    /**
     * 编号
     */
    private String code;
}

