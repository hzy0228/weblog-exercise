package top.hdy.weblog.moudle.jwt.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: Hao-ZY
 * @Date: 2024/5/14 22:19
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoginRspVO {
    /**
     * Token 值
     */
    private String token;

}
