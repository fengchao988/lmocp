package org.jeecg.config.activiti6;


import org.activiti.engine.*;
import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.history.HistoricVariableInstance;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ProjectName: demo
 * @Package: com.example.demo.web
 * @ClassName: LeaveController
 * @Author: MC
 * @Description: ${description}
 * @Date: 2019/9/19 0019 13:08
 * @Version: 1.0
 */
@RestController
@RequestMapping("/level/v1")
public class LeaveController {
    public static final Logger log = LoggerFactory.getLogger(LeaveController.class);
    @Autowired
    private ProcessEngine processEngine;

    @Autowired
    private RuntimeService runtimeService ;

    @Autowired
    private TaskService taskService ;

    @Autowired
    private RepositoryService repositoryService;

    @Autowired
    private  ActivitiUtil activitiUtil;

    /**
     * @Method 部署流程
     * @Author MC

     * @Return
     * @Date 2019/9/19 0019 17:07
     */
    @RequestMapping(value = "/deploy",method = RequestMethod.GET)
    public Map<String,Object> deploy(){
        repositoryService.createDeployment()
                .addClasspathResource("processes/leave1.bpmn")
                .deploy();
        List<ProcessDefinition> list = repositoryService.createProcessDefinitionQuery().list();
        for (int i = 0; i < list.size(); i++) {
            ProcessDefinition p = list.get(i);
            System.out.print("日报流程部署->KEY:"+p.getKey());
        }
        Map<String,Object> map = new HashMap<>();
        map.put("list",list);
        return map;
    }

    /**
     * @Method 根据userId启动流程
     * @Author MC

     * @Return
     * @Date 2019/9/19 0019 13:23
     */
    @RequestMapping(value = "/start",method = RequestMethod.GET)
    public Map<String,Object> start(@RequestParam String userId){
        Map<String,Object> map = new HashMap<>();
        Leave leave = new Leave();
        leave.setUserId(userId);
        map.put("leave",leave);
        ProcessInstance leave1 = runtimeService.startProcessInstanceByKey("leave1", map);
        String processDefinitionId = leave1.getProcessDefinitionId();
        System.out.print("============processDefinitionId:" + processDefinitionId);//流程定义的ID
        System.out.print("============processInstanceId:" + leave1.getId());//流程实例的ID
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("result",leave1);
        resultMap.put("processDefinitionId",processDefinitionId);
        resultMap.put("processInstanceId",leave1.getId());
        return resultMap;
    }

    @RequestMapping(value = "/selectUser",method = RequestMethod.GET)
    public String selectUser() throws Exception {
        String taskId = activitiUtil.getTaskId("5005", "feng");
        List<String> userList= activitiUtil.getNextTaskUserByTaskId(taskId);
        //设置审批人
        activitiUtil.setApproveUser(taskId, "12321");
        taskId = activitiUtil.getNextNodeId(1,"feng");
        //第一个审批人提交流程  feng 为当前节点审批人，xiaozhang 为设置的下一节点审批人
        boolean b = activitiUtil.completeByAssignee("feng","xiaozhang");
        //************第一个人审批成功
        if(b){
            //TODO
        }
//        taskId = activitiUtil.getNextNodeId(1,"xiaozhang");
//        //选人
//        userList= activitiUtil.getNextTaskUserByTaskId(taskId);
//        //第一个审批人提交流程
//        activitiUtil.completeByAssignee("xiaozhang","xiaoming");
//
//        activitiUtil.getNextNodeId(1,"xiaoming");
//
//        //第二个审批人提交流程
//        activitiUtil.completeByAssignee("xiaoming","xiangwang");
        //************第二个人审批成功

        return "";

    }



    /**
     * @Method 根据流程实例ID和任务办理人其实就是Assignee获取任务task实例
     * @Author MC

     * @Return
     * @Date 2019/9/19 0019 13:45
     */
    @RequestMapping(value = "/task",method = RequestMethod.GET)
    public String task(@RequestParam String processInstanceId,@RequestParam String userId){
        //查询当前办理人的任务ID
        Task task = taskService.createTaskQuery()
                .processInstanceId(processInstanceId)//使用流程实例ID
                .taskAssignee(userId)//任务办理人
                .singleResult();

        return  task.getId();
    }


    /**
     * @Method 填写请假表单
     * @Author MC

     * @Return
     * @Date 2019/9/19 0019 13:45
     */
    @RequestMapping(value = "/apply",method = RequestMethod.POST)
    public Map<String,Object> apply(@RequestBody Leave leave){
        String taskId = leave.getTaskId();
        Task task = taskService.createTaskQuery().taskId(taskId).singleResult();
        Map<String,Object> map = new HashMap<>();
        // 获取流程参数  对应启动流程时，入参的参数leave
        Leave variable = (Leave)taskService.getVariable(taskId, "leave");
        // 从入参的表单对象中取值，设置流程参数对象的值
        variable.setDesc(leave.getDesc());
        variable.setStartDate(leave.getStartDate());
        variable.setTotalDay(leave.getTotalDay());
        variable.setApprover1(leave.getApprover1());
        variable.setSubmit(leave.getSubmit());
        map.put("leave",variable);
        taskService.complete(taskId,map);
//        Map<String, Object> resultMap = ResultMapHelper.getSuccessMap();
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("leave",leave);
        return resultMap;
    }


    /**
     * @Method 根据用户ID查询流程集合
     * @Author MC

     * @Return
     * @Date 2019/9/19 0019 13:52
     */
    @RequestMapping(value = "/find",method = RequestMethod.GET)
    public Map<String,Object> find(@RequestParam("userId") String userId){
        List<Task> list = taskService.createTaskQuery().taskAssignee(userId).list();
        List<Leave> resultList = new ArrayList<>();
        if(!CollectionUtils.isEmpty(list)){
            for (Task t : list) {
                Leave leave = (Leave)taskService.getVariable(t.getId(),"leave");
                leave.setTaskId(t.getId());
                leave.setTaskName(t.getName());
                resultList.add(leave);
            }
        }

        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("resultList",resultList);
        return resultMap;
    }


    /**
     * 直接主管审批
     * @param leave
     * @return
     */
    @RequestMapping(value = "/approve1", method = RequestMethod.POST)
    public Map<String, Object> approve1(@RequestBody Leave leave){
        Task task = taskService.createTaskQuery().taskId(leave.getTaskId()).singleResult();
        Map<String, Object> vars = new HashMap<>();
        Leave origin = (Leave) taskService.getVariable(leave.getTaskId(), "leave");
        origin.setApproveDesc1(leave.getApproveDesc1());
        origin.setAgree1(leave.getAgree1());
        origin.setApprover2(leave.getApprover2());
        vars.put("leave", origin);
        taskService.complete(leave.getTaskId(),vars);//设置完以后会发现run_task表中的Assignee字段为空。。。。
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("leave", origin);
        return resultMap;
    }

    /**
     * 部门主管审批
     * @param leave
     * @return
     */
    @RequestMapping(value = "/approve2", method = RequestMethod.POST)
    public Map<String, Object> approve2(@RequestBody Leave leave){
        Task task = taskService.createTaskQuery().taskId(leave.getTaskId()).singleResult();
        Map<String, Object> vars = new HashMap<>();
        Leave origin = (Leave) taskService.getVariable(leave.getTaskId(), "leave");
        origin.setApproveDesc2(leave.getApproveDesc2());
        origin.setAgree2(leave.getAgree2());
        vars.put("leave", origin);
        taskService.complete(leave.getTaskId(),vars);

        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("leave", origin);
        return resultMap;
    }


    /**
     * 查看历史记录
     * @param userId
     * @return
     */
    @RequestMapping(value="/findClosed", method = RequestMethod.GET)
    public Map<String, Object> findClosed(@RequestParam String userId){
//        HistoryService historyService = processEngine.getHistoryService();
        List<Leave> leaves = new ArrayList<>();
        List<HistoricProcessInstance> historicProcessInstanceList = activitiUtil.queryHisProInstance("leave1");
        for(HistoricProcessInstance historicProcessInstance:historicProcessInstanceList){
            System.out.println("历史流程实例id: "+historicProcessInstance.getId());
            System.out.println("历史流程实例的完成时间: "+historicProcessInstance.getEndTime());
            leaves.add((Leave) historicProcessInstance.getProcessVariables().get("leave"));
        }
        // 注意：这一段为什么获取不到数据？哪位能帮忙解决下？
        List<HistoricProcessInstance> list = processEngine.getHistoryService().createHistoricProcessInstanceQuery().
                processDefinitionKey("leave1")
                .variableValueEquals("leave.userId",userId).list();


        List<HistoricVariableInstance> historicVariableInstanceList = activitiUtil.queryHisProVariable("5005");
        for(HistoricVariableInstance historicVariableInstance: historicVariableInstanceList){
            System.out.println("历史流程变量id: "+historicVariableInstance.getId());
            System.out.println("历史流程变量名称: "+historicVariableInstance.getVariableName());
            System.out.println("历史流程变量值: "+historicVariableInstance.getValue());
            System.out.println("==================================================");
        }

        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("datas", leaves);
        return resultMap;
    }


}
