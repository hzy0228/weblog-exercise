package top.hdy.weblog.module.admin.service;

import org.springframework.web.multipart.MultipartFile;
import top.hdy.weblog.module.common.utils.Response;

/**
 * @Author: Hao-ZY
 * @Date: 2024/6/13 9:51
 **/
public interface AdminFileService {

    /**
     * 上传文件
     *
     * @param file
     * @return
     */
    Response uploadFile(MultipartFile file);
}
