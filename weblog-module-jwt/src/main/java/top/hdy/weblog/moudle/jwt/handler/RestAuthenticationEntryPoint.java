package top.hdy.weblog.moudle.jwt.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;
import top.hdy.weblog.module.common.enums.ResponseCodeEnum;
import top.hdy.weblog.module.common.utils.Response;
import top.hdy.weblog.moudle.jwt.utils.ResultUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: Hao-ZY
 * @Date: 2024/5/14 23:26
 **/
@Slf4j
@Component
public class RestAuthenticationEntryPoint implements AuthenticationEntryPoint {


    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        log.warn("用户未登录访问受保护的资源: ", authException);
        if (authException instanceof InsufficientAuthenticationException) {
            ResultUtil.fail(response, HttpStatus.UNAUTHORIZED.value(), Response.fail(ResponseCodeEnum.UNAUTHORIZED));
        }
        ResultUtil.fail(response, HttpStatus.UNAUTHORIZED.value(), Response.fail(authException.getMessage()));

    }
}
