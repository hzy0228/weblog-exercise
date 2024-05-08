package top.hdy.weblog.web.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import top.hdy.weblog.module.common.aspect.ApiOperationLog;
import top.hdy.weblog.module.common.enums.ResponseCodeEnum;
import top.hdy.weblog.module.common.exception.BizException;
import top.hdy.weblog.module.common.utils.Response;
import top.hdy.weblog.web.model.User;

import java.util.stream.Collectors;

/**
 * @Author: Hao-ZY
 * @Date: 2024/4/30 17:46
 **/
@RestController
@Slf4j
public class TestController {
    @PostMapping("/test")
    @ApiOperationLog(description = "测试接口")
    public Response test(@RequestBody @Validated User user, BindingResult bindingResult) {
//        // 是否存在校验错误
//        if (bindingResult.hasErrors()) {
//            // 获取校验不通过字段的提示信息
//            String errorsMsg = bindingResult.getFieldErrors().stream().map(FieldError::getDefaultMessage).collect(Collectors.joining(","));
//            return Response.fail(errorsMsg);
//        }
//        return Response.success("参数没有问题");

//        // 手动抛异常，入参是前面定义好的异常码枚举，返参统一交给全局异常处理器搞定
//        throw new BizException(ResponseCodeEnum.PRODUCT_NOT_FOUND);

        // 主动定义一个运行时异常，分母不能为零
        int i = 1 / 0;
        return Response.success();
    }

}
