package top.hdy.weblog.module.common.exception;

import lombok.Getter;
import lombok.Setter;

/**
 * @Author: Hao-ZY
 * @Date: 2024/5/8 17:13
 **/
@Getter
@Setter
public class BizException extends RuntimeException {

    // 异常码
    private String errorCode;
    // 错误信息
    private String errorMessage;

    public BizException(BaseExceptionInterface baseExceptionInterface) {
        this.errorCode = baseExceptionInterface.getErrorCode();
        this.errorMessage = baseExceptionInterface.getErrorMessage();
    }
}
