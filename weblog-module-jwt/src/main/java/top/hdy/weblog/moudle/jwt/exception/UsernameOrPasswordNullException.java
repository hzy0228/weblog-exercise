package top.hdy.weblog.moudle.jwt.exception;

import org.springframework.security.core.AuthenticationException;

/**
 * @Author: Hao-ZY
 * @Date: 2024/5/14 22:14
 * @description: 用户名或者密码为空异常
 **/
public class UsernameOrPasswordNullException extends AuthenticationException {

    public UsernameOrPasswordNullException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public UsernameOrPasswordNullException(String msg) {
        super(msg);
    }

}
