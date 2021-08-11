package com.snszyk.iiot.marketization.workplace.infrastructure.mybatis.po;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.jeecg.common.system.base.entity.JeecgEntity;


/**
 * 产品库-通用库-工作地点-地点条件 po
 *
 * @author tttt-boot
 * @version 1.0.0
 * @since 2021-01-12 16:14
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("lc_workplace_option")
@NoArgsConstructor
public class LeanWorkplaceOptionPo extends JeecgEntity {
    /**
     * 参数
     */
    private String parameter;
    /**
     * 数值
     */
    private String value;

    private String workplaceId;
}
