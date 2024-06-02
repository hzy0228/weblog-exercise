package top.hdy.weblog.module.admin.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import top.hdy.weblog.module.admin.model.vo.user.FindUserInfoRspVO;
import top.hdy.weblog.module.admin.model.vo.user.UpdateAdminUserPasswordReqVO;
import top.hdy.weblog.module.admin.service.AdminUserService;
import top.hdy.weblog.module.common.domain.mapper.UserMapper;
import top.hdy.weblog.module.common.enums.ResponseCodeEnum;
import top.hdy.weblog.module.common.utils.Response;

/**
 * @Author: Hao-ZY
 * @Date: 2024/6/2 13:03
 **/
@Service
@Slf4j
public class AdminUserServiceImpl implements AdminUserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     * 修改密码
     *
     * @param updateAdminUserPasswordReqVO
     * @return
     */
    @Override
    public Response updatePassword(UpdateAdminUserPasswordReqVO updateAdminUserPasswordReqVO) {
        String username = updateAdminUserPasswordReqVO.getUsername();
        String password = updateAdminUserPasswordReqVO.getPassword();

        String encodePassword = passwordEncoder.encode(password);

        int count = userMapper.updatePasswordByUsername(username, encodePassword);

        return count == 1 ? Response.success() : Response.fail(ResponseCodeEnum.USERNAME_NOT_FOUND);
    }

    /**
     * 获取当前登录用户信息
     *
     * @return
     */
    @Override
    public Response findUserInfo() {

        // 获取存储在 ThreadLocal 中的用户信息
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        // 拿到用户名
        String username = authentication.getName();
//        FindUserInfoRspVO findUserInfoRspVO = new FindUserInfoRspVO();
//        findUserInfoRspVO.setUsername(username);
//        return Response.success(findUserInfoRspVO);
        return Response.success(FindUserInfoRspVO.builder().username(username).build());
    }
}
