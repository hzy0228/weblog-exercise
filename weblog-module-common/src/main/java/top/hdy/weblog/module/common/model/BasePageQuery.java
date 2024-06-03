package top.hdy.weblog.module.common.model;

import lombok.Data;

/**
 * @Author: Hao-ZY
 * @Date: 2024/6/3 23:28
 **/
@Data
public class BasePageQuery {

    /**
     * 当前页码, 默认第一页
     */
    private Long current = 1L;
    /**
     * 每页展示的数据数量，默认每页展示 10 条数据
     */
    private Long size = 10L;
}
