package top.hdy.weblog.moudle.jwt.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;
import top.hdy.weblog.module.common.enums.ResponseCodeEnum;
import top.hdy.weblog.module.common.utils.Response;
import top.hdy.weblog.moudle.jwt.exception.UsernameOrPasswordNullException;
import top.hdy.weblog.moudle.jwt.utils.ResultUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: Hao-ZY
 * @Date: 2024/5/14 22:21
 **/
@Component
@Slf4j
public class RestAuthenticationFailureHandler implements AuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException, IOException {
        log.warn("AuthenticationException: ", exception);
        if (exception instanceof UsernameOrPasswordNullException) {
            // 用户名或密码为空
            ResultUtil.fail(response, Response.fail(exception.getMessage()));
        } else if (exception instanceof BadCredentialsException) {
            // 用户名或密码错误
            ResultUtil.fail(response, Response.fail(ResponseCodeEnum.USERNAME_OR_PWD_ERROR));
        }

        // 登录失败
        ResultUtil.fail(response, Response.fail(ResponseCodeEnum.LOGIN_FAIL));
    }
}
