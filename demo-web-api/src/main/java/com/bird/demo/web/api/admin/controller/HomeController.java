package com.bird.demo.web.api.admin.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.bird.core.OperationResult;
import com.bird.demo.service.zero.user.UserService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liuxx
 * @date 2018/6/21
 */
@RestController
@RequestMapping("/home")
@Api(description = "首页接口")
public class HomeController {

    @Reference
    private UserService userService;

    @GetMapping("/test")
    public OperationResult<String> test(){
        String result = userService.test();

        return OperationResult.Success("获取成功",result);
    }
}
