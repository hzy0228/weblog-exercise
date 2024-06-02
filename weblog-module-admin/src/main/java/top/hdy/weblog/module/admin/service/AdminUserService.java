package top.hdy.weblog.module.admin.service;

import top.hdy.weblog.module.admin.model.vo.user.UpdateAdminUserPasswordReqVO;
import top.hdy.weblog.module.common.utils.Response;

/**
 * @Author: Hao-ZY
 * @Date: 2024/6/2 13:03
 **/
public interface AdminUserService {

    /**
     * 修改密码
     *
     * @param updateAdminUserPasswordReqVO
     * @return
     */
    Response updatePassword(UpdateAdminUserPasswordReqVO updateAdminUserPasswordReqVO);

    /**
     * 获取当前登录用户信息
     *
     * @return
     */
    Response findUserInfo();
}
