package top.hdy.weblog.module.common.domain.dos;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: Hao-ZY
 * @Date: 2024/6/14 22:28
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@TableName("t_article_category_rel")
public class ArticleCategoryRelDO {
    @TableId(type = IdType.AUTO)
    private Long id;

    private Long articleId;

    private Long categoryId;
}
