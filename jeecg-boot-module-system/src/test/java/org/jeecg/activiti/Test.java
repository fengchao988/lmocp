package org.jeecg.activiti;

import org.activiti.engine.*;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.jeecg.JeecgSystemApplication;
import org.jeecg.config.activiti6.ActivitiUtil;
import org.jeecg.config.activiti6.Leave;
import org.jeecg.config.activiti6.LeaveController;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = JeecgSystemApplication.class)
public class Test {

    public static final Logger log = LoggerFactory.getLogger(LeaveController.class);
    @Autowired
    private ProcessEngine processEngine;

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private TaskService taskService;

    @Autowired
    private RepositoryService repositoryService;

    @Autowired
    private ActivitiUtil activitiUtil;

    @Autowired
    private IdentityService identityService;


    @org.junit.Test
    public void deploy() {
        repositoryService.createDeployment()
                .addClasspathResource("processes/aa.bpmn")
                .deploy();
        List<ProcessDefinition> list = repositoryService.createProcessDefinitionQuery().list();
        for (int i = 0; i < list.size(); i++) {
            ProcessDefinition p = list.get(i);
            System.out.print("日报流程部署======key:" + p.getKey());
        }
        Map<String, Object> map = new HashMap<>();
        map.put("list", list);
    }

    @org.junit.Test
    public void start() {
        ProcessInstance leave1 = runtimeService.startProcessInstanceByKey("MaterialDaily", "wd001");
        String processDefinitionId = leave1.getProcessDefinitionId();
        System.out.print("============processDefinitionId:" + processDefinitionId);//流程定义的ID
        System.out.print("============processInstanceId:" + leave1.getId());//流程实例的ID
    }

    @org.junit.Test
    public void start1() {
        Task task = taskService.createTaskQuery().processInstanceId("2501").singleResult();
        System.out.println(task.getAssignee());
/*
        task.setDescription("今日产煤80吨，消耗材料100个");
*/
        taskService.complete(task.getId());
        task = taskService.createTaskQuery().processInstanceId("2501").singleResult();
        System.out.println(task);
    }


    @org.junit.Test
    public void selectUser() throws Exception {
        String taskId = activitiUtil.getTaskId("5007", "feng");
        List<String> userList = activitiUtil.getNextTaskUserByTaskId(taskId);
        //设置审批人
        activitiUtil.setApproveUser(taskId, "12321");
        taskId = activitiUtil.getNextNodeId(1, "feng");
        //第一个审批人提交流程  feng 为当前节点审批人，xiaozhang 为设置的下一节点审批人
        boolean b = activitiUtil.completeByAssignee("feng", "xiaozhang");
    }

    @org.junit.Test
    public void addUser() throws Exception {
    }


}