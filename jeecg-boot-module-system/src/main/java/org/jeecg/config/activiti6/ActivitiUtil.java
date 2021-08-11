package org.jeecg.config.activiti6;

import org.activiti.bpmn.model.*;
import org.activiti.bpmn.model.Process;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.history.HistoricActivityInstance;
import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.history.HistoricTaskInstance;
import org.activiti.engine.history.HistoricVariableInstance;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @ProjectName: demo
 * @Package: com.example.demo.utils
 * @ClassName: ActivitiUtil
 * @Author: MC
 * @Description: ${description}
 * @Date: 2019/9/19 0019 18:17
 * @Version: 1.0
 */
@Service
public class ActivitiUtil {
    @Autowired
    private ProcessEngine processEngine;

    @Autowired
    private RuntimeService runtimeService ;

    @Autowired
    private TaskService taskService ;

    @Autowired
    private RepositoryService repositoryService;

    /**
     * @Method 部署流程
     * @Author MC

     * @Return
     * @Date 2019/9/19 0019 18:34
     */
    public void deploy(String filePath){
        if(!StringUtils.isEmpty(filePath)){
            repositoryService.createDeployment()
                    .addClasspathResource(filePath)
                    .deploy();
        }
    }

    /**
     * @Method 启动流程
     * @Author MC

     * @Return
     * @Date 2019/9/19 0019 18:35
     */
    public Map<String,Object> start(Map<String,Object> map ,String processId){
        ProcessInstance leave1 = runtimeService.startProcessInstanceByKey(processId, map);
        String processDefinitionId = leave1.getProcessDefinitionId();
        System.out.print("============processDefinitionId:" + processDefinitionId);//流程定义的ID
        System.out.print("============processInstanceId:" + leave1.getId());//流程实例的ID
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("result",leave1);
        resultMap.put("processDefinitionId",processDefinitionId);
        resultMap.put("processInstanceId",leave1.getId());
        return resultMap;
    }

    /**
     * @Method 根据流程实例ID和用户ID查询任务ID
     * @Author MC
    用户ID必须设置为Assignee
     * @Return
     * @Date 2019/9/19 0019 19:01
     */
    public String getTaskId( String processInstanceId, String userId){
        TaskService taskService = processEngine.getTaskService();//获取任务的Service，设置和获取流程变量
        //查询当前办理人的任务ID
        Task task = taskService.createTaskQuery()
                .processInstanceId(processInstanceId)//使用流程实例ID
                .taskAssignee(userId)//任务办理人
                .singleResult();

        return  task.getId();
    }

    /**
     * @Method 获取流程实例列表
     * @Author MC

     * @Return
     * @Date 2019/9/19 0019 18:32
     */
    public List<ProcessInstance> queryProcessInstanceAllList(String processDefinitionKey){
        return runtimeService
                .createProcessInstanceQuery().processDefinitionKey(processDefinitionKey)
                .list();
    }


    /**
     * @Method 根据assignee来查询用户
     * @Author MC

     * @Return
     * @Date 2019/9/19 0019 18:29
     */
    public Task queryTask(String assignee) {
        //startProcessInstance();
        // taskService.createTaskQuery().taskCandidateGroup("sales").singleResult();

        Task task= taskService.createTaskQuery().taskAssignee(assignee).singleResult();
        if(task == null){
            return null;
        }

        System.out.println("审批人为【"+assignee+"】的任务有：任务编号为【" + task.getId() + "】"+ task.getTaskDefinitionKey());
        return task;
    }

    /**
     *
     * @param queryType  查询类型1 根据 assignee 查询  2 根据candidateuser查询
     * @param str
     */
    public String getNextNodeId(int queryType,String str) {


        Task task = null;
        if(queryType==1) {
            task = taskService.createTaskQuery().taskAssignee(str).singleResult();
        }else if(queryType==2){
            task = taskService.createTaskQuery().taskCandidateUser(str).singleResult();

        }else if(queryType==3){
            task = taskService.createTaskQuery().taskCandidateGroup(str).singleResult();

        }

//        List<FlowElement> list = getNextNode(task.getId());


        if(task==null) {
            return null;
        }

//        for(FlowElement e :list) {
//            //((org.activiti.bpmn.model.UserTask) e)
//        }
        return task.getId();

    }


    /**
     * 获取流程的下一个节点 且要经过规则引擎判断后的节点
     * @param taskId
     * @return
     */
    private List<FlowElement> getNextNode(String taskId) {

        Task task = taskService.createTaskQuery().taskId(taskId).singleResult();
        if(task==null) {
            return null;
        }
        List<FlowElement> list = new ArrayList<FlowElement>();
        ProcessInstance processInstance = runtimeService.createProcessInstanceQuery().processInstanceId(task.getProcessInstanceId()).singleResult();

        //当前活动节点
        String activitiId = processInstance.getActivityId();

        System.out.println("当前节点是【"+activitiId+"】");

        //pmmnModel 遍历节点需要它
        BpmnModel bpmnModel =  repositoryService.getBpmnModel(task.getProcessDefinitionId());

        List<Process> processList = bpmnModel.getProcesses();

        //循环多个物理流程
        for(Process process:processList) {

            //返回该流程的所有任务，事件
            Collection<FlowElement> cColl = process.getFlowElements();
            //遍历节点
            for(FlowElement f :cColl) {


                //如果改节点是当前节点 者 输出该节点的下一个节点
                if(f.getId().equals(activitiId)) {

                    List<SequenceFlow>  sequenceFlowList = new ArrayList<SequenceFlow>();
                    //通过反射来判断是哪种类型
                    if(f instanceof org.activiti.bpmn.model.StartEvent) {
                        //开始事件的输出路由
                        sequenceFlowList   = ((org.activiti.bpmn.model.StartEvent) f).getOutgoingFlows();
                    }else if(f instanceof org.activiti.bpmn.model.UserTask) {

                        sequenceFlowList   = ((org.activiti.bpmn.model.UserTask) f).getOutgoingFlows();


                        for(SequenceFlow sf :sequenceFlowList)  {

                            String targetRef = sf.getTargetRef();
                            FlowElement ref = process.getFlowElement(targetRef);

                            // nextActivitiIdList.add(ref.getId());

                            list.add(ref);
                        }

                    }else if(f instanceof org.activiti.bpmn.model.SequenceFlow) {


                    }else if(f instanceof org.activiti.bpmn.model.EndEvent) {
                        sequenceFlowList   = ((org.activiti.bpmn.model.EndEvent) f).getOutgoingFlows();
                    }
                    break;
                }

            }

        }
        return list;
    }


    /**
     * @Method 流程流转到下一步
     * @Author MC
    根据 assignee 查询出任务，如果存在则设置当前任务的 assignee 为 nextUser
     * @Return 不存在下一个节点返回false;
     * @Date 2019/9/19 0019 18:23
     */
    public boolean completeByAssignee(String assignee,String nextUser) throws Exception {

        HashMap<String,Object> map = new HashMap<String,Object>();

        map.put("nextUser", nextUser);
        Task task = taskService.createTaskQuery().taskAssignee(assignee).singleResult();
        if(task == null){
            System.out.println("下一节点不存在");
            return false;
        }
        taskService.complete(task.getId(),map);
        System.out.println("完成任务 编号为【" + task.getId() + "】,名称为【"+task.getName()+"】的任务");
        return true;
    }

    /**
     * 设置某个节点的审批人员
     * @param taskId
     * @param user
     */
    public void setApproveUser(String taskId,String user) {
        Task task = taskService.createTaskQuery().taskId(taskId).singleResult();
        task.setAssignee(user);
        taskService.saveTask(task);
    }


    /**
     * 取下一个节点的审批人
     * @param taskId
     * @return
     */
    public List<String> getNextTaskUserByTaskId(String taskId) {
        List<String> list = new ArrayList<String>();
        List<FlowElement> fList = getNextNode(taskId);
        for(FlowElement u:fList){
            String str =  ((org.activiti.bpmn.model.UserTask) u).getAssignee();
            list.add(str);
        }
        return list ;
    }


    /**
     * 找当前节点的候选审批人  供流程实例start后调用
     * @param taskId
     * @return
     */
    public List<String> getThisTaskUser(String taskId) {
        List<String> list = new ArrayList<String>();
        Task task = taskService.createTaskQuery().taskId(taskId).singleResult();
        String taskUser = task.getAssignee();

        //*****************************根据taskUser的配置到自己的表里面去找数据

        list.add(taskUser);
        return list ;
    }

    /**
     * @Method 任务是否完结
     * @Author MC

     * @Return
     * @Date 2019/9/20 0020 11:20
     */
    public boolean isOverTask(String processInstanceId){
        ProcessInstance pi= runtimeService.createProcessInstanceQuery() // 创建流程实例查询
                .processInstanceId(processInstanceId) // 用流程实例id查询
                .singleResult();
        if(pi!=null){
            System.out.println("流程正在执行！");
            return false;
        }else{
            System.out.println("流程已经执行结束！");
        }
        return true;
    }


    /**
     * @Method 历史流程实例查询
     * @Author MC

     * @Return
     * @Date 2019/9/20 0020 11:22
     */
    public  List<HistoricProcessInstance>  queryHisProInstance(String processDefinitionKey){
        List<HistoricProcessInstance> historicProcessInstanceList = processEngine.getHistoryService().createHistoricProcessInstanceQuery()
                .processDefinitionKey(processDefinitionKey)
                .orderByProcessInstanceEndTime()
                .desc()
                .list();
        /*for(HistoricProcessInstance historicProcessInstance:historicProcessInstanceList){
            System.out.println("历史流程实例id: "+historicProcessInstance.getId());
            System.out.println("历史流程实例的完成时间: "+historicProcessInstance.getEndTime());
        }*/
        return historicProcessInstanceList;
    }


    /**
     * 查询历史流程变量
     */
    public List<HistoricVariableInstance> queryHisProVariable(String processInstanceId){
        List<HistoricVariableInstance> historicVariableInstanceList = processEngine.getHistoryService()
                .createHistoricVariableInstanceQuery()
                .processInstanceId(processInstanceId).list();
        /*for(HistoricVariableInstance historicVariableInstance: historicVariableInstanceList){
            System.out.println("历史流程变量id: "+historicVariableInstance.getId());
            System.out.println("历史流程变量名称: "+historicVariableInstance.getVariableName());
            System.out.println("历史流程变量值: "+historicVariableInstance.getValue());
            System.out.println("==================================================");
        }*/
        return historicVariableInstanceList;
    }


    /**
     * 根据办理人查询历史任务实例
     */
    public List<HistoricTaskInstance> queryHisTaskInstanceByAssignee(String processDefinitionKey,String taskAssignee){
        List<HistoricTaskInstance> historicTaskInstanceList = processEngine.getHistoryService().createHistoricTaskInstanceQuery()
                .processDefinitionKey(processDefinitionKey)
                .taskAssignee(taskAssignee).list();
        /*for(HistoricTaskInstance historicTaskInstance:historicTaskInstanceList){
            System.out.println("历史任务id: "+historicTaskInstance.getId());
            System.out.println("历史任务名称: "+historicTaskInstance.getName());
            System.out.println("历史任务结束时间: "+historicTaskInstance.getEndTime());
            System.out.println("办理人: "+historicTaskInstance.getAssignee());
            System.out.println("==================================================");
        }*/
        return historicTaskInstanceList;
    }



    /**
     * 历史任务查询
     * type: 0:未完成 1:已完成  "":all
     */
    public List<HistoricTaskInstance> historyTaskList(String processInstanceId,String type){
        List<HistoricTaskInstance> list=null;

        if(StringUtils.isEmpty(type)){
            list =  processEngine.getHistoryService() // 历史相关Service
                    .createHistoricTaskInstanceQuery() // 创建历史任务实例查询
                    .processInstanceId(processInstanceId) // 用流程实例id查询
                    .list();
        }else if("0".equals(type)){
            list =  processEngine.getHistoryService() // 历史相关Service
                    .createHistoricTaskInstanceQuery() // 创建历史任务实例查询
                    .processInstanceId(processInstanceId) // 用流程实例id查询
                    .unfinished()
                    .list();
        }else if("1".equals(type)){
            processEngine.getHistoryService() // 历史相关Service
                    .createHistoricTaskInstanceQuery() // 创建历史任务实例查询
                    .processInstanceId(processInstanceId) // 用流程实例id查询
                    .finished() // 查询已经完成的任务
                    .list();
        }
       /* for(HistoricTaskInstance hti:list){
            System.out.println("任务ID:"+hti.getId());
            System.out.println("流程实例ID:"+hti.getProcessInstanceId());
            System.out.println("任务名称："+hti.getName());
            System.out.println("办理人："+hti.getAssignee());
            System.out.println("开始时间："+hti.getStartTime());
            System.out.println("结束时间："+hti.getEndTime());
            System.out.println("=================================");
        }*/

        return list;
    }

    /**
     * 已完成的历史活动查询
     */
    public List<HistoricActivityInstance> historyActInstanceList(String processInstanceId){
        List<HistoricActivityInstance>  list=processEngine.getHistoryService() // 历史相关Service
                .createHistoricActivityInstanceQuery() // 创建历史活动实例查询
                .processInstanceId(processInstanceId) // 执行流程实例id
                .finished()
                .list();
       /* for(HistoricActivityInstance hai:list){
            System.out.println("活动ID:"+hai.getId());
            System.out.println("流程实例ID:"+hai.getProcessInstanceId());
            System.out.println("活动名称："+hai.getActivityName());
            System.out.println("办理人："+hai.getAssignee());
            System.out.println("开始时间："+hai.getStartTime());
            System.out.println("结束时间："+hai.getEndTime());
            System.out.println("=================================");
        }*/
        return list;
    }

}
