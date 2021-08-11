package com.snszyk.iiot.marketization.demo.domain.position.integration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserQueryIntegrationService {

    //根据实例的情况，注入不同的查询对象，进行组装查询

    /*@Autowired
    private UserQueryRepository userQueryRepository;

    //todo 持久化包含一组API实现
    public List<UserModel> queryUserList() {
        // 1 查询
        List<UserModel> userModels = userQueryRepository.findAll();
        // 2 查询
        // 3 查询
        // 4 组装
        // 4 组装
        // 5 返回
        return userModels;
    }*/
}
