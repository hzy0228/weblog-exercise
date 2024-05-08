package top.hdy.weblog.module.common.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import top.hdy.weblog.module.common.enums.ResponseCodeEnum;
import top.hdy.weblog.module.common.utils.Response;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: Hao-ZY
 * @Date: 2024/5/8 17:48
 **/
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    /**
     * 捕获自定义业务异常
     *
     * @return
     */
    @ExceptionHandler({BizException.class})
    @ResponseBody
    public Response<Object> handleBizException(HttpServletRequest request, BizException e) {
        log.warn("{} request fail, errorCode: {}, errorMessage: {}", request.getRequestURI(), e.getErrorCode(), e.getErrorMessage());
        return Response.fail(e);
    }

    /**
     * 其他类型异常
     * @param request
     * @param e
     * @return
     */
    @ExceptionHandler({ Exception.class })
    @ResponseBody
    public Response<Object> handleOtherException(HttpServletRequest request, Exception e) {
        log.error("{} request error, ", request.getRequestURI(), e);
        return Response.fail(String.valueOf(ResponseCodeEnum.SYSTEM_ERROR));
    }
}
