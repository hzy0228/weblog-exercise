package top.hdy.weblog.web.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import top.hdy.weblog.module.common.aspect.ApiOperationLog;
import top.hdy.weblog.module.common.utils.JsonUtil;
import top.hdy.weblog.module.common.utils.Response;
import top.hdy.weblog.web.model.User;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * @Author: Hao-ZY
 * @Date: 2024/4/30 17:46
 **/
@RestController
@Slf4j
@Api(tags = "首页模块")
public class TestController {
    @PostMapping("/test")
    @ApiOperationLog(description = "测试接口")
    @ApiOperation("测试接口")
    public Response test(@RequestBody @Validated User user) {
        // 打印入参
        log.info(JsonUtil.toJsonString(user));

        // 设置三种日期字段值
        user.setCreateTime(LocalDateTime.now());
        user.setUpdateDate(LocalDate.now());
        user.setTime(LocalTime.now());

        return Response.success(user);
    }

}
