package top.hdy.weblog.module.common.domain.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import top.hdy.weblog.module.common.domain.dos.UserRoleDO;

import java.util.List;

/**
 * @Author: Hao-ZY
 * @Date: 2024/5/26 14:47
 **/

public interface UserRoleMapper extends BaseMapper<UserRoleDO> {

    /**
     * 根据用户名查询
     * @param username
     * @Auther: Hao-ZY
     * @Date: 2024/5/26 14:51
     * @Description: TODO
     */
    default List<UserRoleDO> selectByUsername(String username) {
        LambdaQueryWrapper<UserRoleDO> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(UserRoleDO::getUsername, username);
        return selectList(wrapper);
    }
}
