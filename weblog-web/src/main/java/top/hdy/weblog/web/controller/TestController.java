package top.hdy.weblog.web.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import top.hdy.weblog.module.common.aspect.ApiOperationLog;
import top.hdy.weblog.web.model.User;

/**
 * @Author: Hao-ZY
 * @Date: 2024/4/30 17:46
 **/
@RestController
@Slf4j
public class TestController {
    @PostMapping("/test")
    @ApiOperationLog(description = "测试接口")
    public User test(@RequestBody User user) {
        // 返参
        return user;
    }
}
