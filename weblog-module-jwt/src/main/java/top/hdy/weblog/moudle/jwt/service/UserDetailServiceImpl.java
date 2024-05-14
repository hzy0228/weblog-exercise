package top.hdy.weblog.moudle.jwt.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import top.hdy.weblog.module.common.domain.dos.UserDO;
import top.hdy.weblog.module.common.domain.mapper.UserMapper;
import top.hdy.weblog.moudle.jwt.exception.UsernameOrPasswordNullException;

import java.util.Objects;

/**
 * @Author: Hao-ZY
 * @Date: 2024/5/14 22:11
 **/
@Service
@Slf4j
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 从数据库中查询
        UserDO userDO = userMapper.findByUsername(username);

        if (Objects.isNull(userDO)) {
            throw new UsernameOrPasswordNullException("该用户不存在");
        }

        // 暂时先写死，密码为 quanxiaoha, 这里填写的密文，数据库中也是存储此种格式
        // authorities 用于指定角色，这里写死为 ADMIN 管理员
        return User.withUsername(userDO.getUsername())
                .password(userDO.getPassword())
                .authorities("ADMIN")
                .build();
    }
}
