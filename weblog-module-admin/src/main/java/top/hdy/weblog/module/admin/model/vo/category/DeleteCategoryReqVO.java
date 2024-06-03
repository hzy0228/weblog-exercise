package top.hdy.weblog.module.admin.model.vo.category;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/**
 * @Author: Hao-ZY
 * @Date: 2024/6/4 0:17
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel(value = "删除分类 VO")
public class DeleteCategoryReqVO {

    @NotNull(message = "分类 ID 不能为空")
    private Long id;
}
