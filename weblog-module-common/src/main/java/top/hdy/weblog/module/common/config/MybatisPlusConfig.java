package top.hdy.weblog.module.common.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: Hao-ZY
 * @Date: 2024/5/11 15:57
 **/
@Configuration
@MapperScan("top.hdy.weblog.module.common.domain.mapper")
public class MybatisPlusConfig {
}
