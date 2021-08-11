package org.jeecg.config.activiti6;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @ProjectName: demo
 * @Package: com.example.demo.service.model
 * @ClassName: Leave
 * @Author: MC
 * @Description: ${description}
 * @Date: 2019/9/19 0019 13:14
 * @Version: 1.0
 */
@Data
public class Leave implements Serializable {
    private static final long serialVersionUID = 2248469053125414262L;

    private String userId;

    private Boolean submit;

    private Date startDate;

    private Date endDate;

    private float totalDay;

    private String desc;

    private String taskId;

    private String taskName;

    private String approver1;

    private Boolean agree1;

    private String approveDesc1;

    private String approver2;

    private Boolean agree2;

    private String approveDesc2;

}