package top.hdy.weblog.module.admin.service;

import top.hdy.weblog.module.admin.model.vo.blogsettings.UpdateBlogSettingsReqVO;
import top.hdy.weblog.module.common.utils.Response;

/**
 * @Author: Hao-ZY
 * @Date: 2024/6/13 10:39
 **/
public interface AdminBlogSettingsService {

    /**
     * 更新博客设置信息
     *
     * @param updateBlogSettingsReqVO
     * @return
     */
    Response updateBlogSettings(UpdateBlogSettingsReqVO updateBlogSettingsReqVO);
}
