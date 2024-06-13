package top.hdy.weblog.module.admin.convert;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import top.hdy.weblog.module.admin.model.vo.blogsettings.FindBlogSettingsRspVO;
import top.hdy.weblog.module.admin.model.vo.blogsettings.UpdateBlogSettingsReqVO;
import top.hdy.weblog.module.common.domain.dos.BlogSettingsDO;

/**
 * @Author: Hao-ZY
 * @Date: 2024/6/13 11:51
 **/
@Mapper
public interface BlogSettingsConvert {

    /**
     * 初始化 convert 实例
     */
    BlogSettingsConvert INSTANCE = Mappers.getMapper(BlogSettingsConvert.class);

    /**
     * 将 VO 转化为 DO
     *
     * @param bean
     * @return
     */
    BlogSettingsDO convertVO2DO(UpdateBlogSettingsReqVO bean);


    /**
     * 将 DO 转化为 VO
     *
     * @param bean
     * @return
     */
    FindBlogSettingsRspVO convertDO2VO(BlogSettingsDO bean);
}
