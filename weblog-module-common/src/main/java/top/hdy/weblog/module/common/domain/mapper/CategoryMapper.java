package top.hdy.weblog.module.common.domain.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import top.hdy.weblog.module.common.domain.dos.CategoryDO;

/**
 * @Author: Hao-ZY
 * @Date: 2024/6/3 22:15
 **/
public interface CategoryMapper extends BaseMapper<CategoryDO> {

    /**
     * 根据用户名查询
     *
     * @param categoryName
     * @return
     */
    default CategoryDO selectByName(String categoryName) {
        LambdaQueryWrapper<CategoryDO> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(CategoryDO::getName, categoryName);

        return selectOne(wrapper);
    }
}
