package top.hdy.weblog.moudle.jwt.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import top.hdy.weblog.module.common.domain.dos.UserDO;
import top.hdy.weblog.module.common.domain.dos.UserRoleDO;
import top.hdy.weblog.module.common.domain.mapper.UserMapper;
import top.hdy.weblog.module.common.domain.mapper.UserRoleMapper;
import top.hdy.weblog.moudle.jwt.exception.UsernameOrPasswordNullException;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @Author: Hao-ZY
 * @Date: 2024/5/14 22:11
 **/
@Service
@Slf4j
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserRoleMapper userRoleMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 从数据库中查询
        UserDO userDO = userMapper.findByUsername(username);

        if (Objects.isNull(userDO)) {
            throw new UsernameOrPasswordNullException("该用户不存在");
        }
        // 用户角色
        List<UserRoleDO> roleDOS = userRoleMapper.selectByUsername(username);

        String[] roleArr = null;
        //转数组
        if (!CollectionUtils.isEmpty(roleDOS)) {
            List<String> roles = roleDOS.stream().map(p -> p.getRole()).collect(Collectors.toList());
            roleArr = roles.toArray(new String[roles.size()]);
        }

        // authorities 用于指定角色
        return User.withUsername(userDO.getUsername())
                .password(userDO.getPassword())
                .authorities(roleArr)
                .build();
    }
}
