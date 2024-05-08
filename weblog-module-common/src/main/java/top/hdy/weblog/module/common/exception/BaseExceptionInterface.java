package top.hdy.weblog.module.common.exception;

/**
 * @Author: Hao-ZY
 * @Date: 2024/5/8 16:49
 * @description: 通用异常接口
 **/
public interface BaseExceptionInterface {
    String getErrorCode();

    String getErrorMessage();
}
