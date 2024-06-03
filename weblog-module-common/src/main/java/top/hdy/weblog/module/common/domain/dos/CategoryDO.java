package top.hdy.weblog.module.common.domain.dos;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @Author: Hao-ZY
 * @Date: 2024/6/3 22:14
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@TableName("t_category")
public class CategoryDO {

    @TableId(type = IdType.AUTO)
    private Long id;

    private String name;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    private Boolean isDeleted;
}
