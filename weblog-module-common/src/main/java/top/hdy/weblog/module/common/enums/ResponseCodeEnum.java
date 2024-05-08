package top.hdy.weblog.module.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import top.hdy.weblog.module.common.exception.BaseExceptionInterface;

/**
 * @Author: Hao-ZY
 * @Date: 2024/5/8 17:10
 **/
@Getter
@AllArgsConstructor
public enum ResponseCodeEnum implements BaseExceptionInterface {

    // ----------- 通用异常状态码 -----------
    SYSTEM_ERROR("10000", "出错啦，后台小哥正在努力修复中..."),

    // ----------- 业务异常状态码 -----------
    PRODUCT_NOT_FOUND("20000", "该产品不存在（测试使用）"),
    ;

    // 异常码
    private String errorCode;
    // 错误信息
    private String errorMessage;
}
