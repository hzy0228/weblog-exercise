package top.hdy.weblog.module.admin.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import top.hdy.weblog.module.admin.model.vo.file.UploadFileRspVO;
import top.hdy.weblog.module.admin.service.AdminFileService;
import top.hdy.weblog.module.admin.utils.MinioUtil;
import top.hdy.weblog.module.common.enums.ResponseCodeEnum;
import top.hdy.weblog.module.common.exception.BizException;
import top.hdy.weblog.module.common.utils.Response;

/**
 * @Author: Hao-ZY
 * @Date: 2024/6/13 9:54
 **/
@Service
@Slf4j
public class AdminFileServiceImpl implements AdminFileService {


    @Autowired
    private MinioUtil minioUtil;

    /**
     * 上传文件
     *
     * @param file
     * @return
     */
    @Override
    public Response uploadFile(MultipartFile file) {

        String url = null;

        try {
            // 上传文件
            url = minioUtil.uploadFile(file);

            // 构建成功返参，将图片的访问链接返回
            return Response.success(UploadFileRspVO.builder().url(url).build());
        } catch (Exception e) {
            log.error("==> 上传文件至Minio 错误: ", e);

            throw new BizException(ResponseCodeEnum.FILE_UPLOAD_FAILED);
        }
    }
}
