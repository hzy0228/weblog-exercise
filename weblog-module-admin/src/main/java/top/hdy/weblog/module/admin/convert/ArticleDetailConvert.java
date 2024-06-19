package top.hdy.weblog.module.admin.convert;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import top.hdy.weblog.module.admin.model.vo.article.FindArticleDetailRspVO;
import top.hdy.weblog.module.common.domain.dos.ArticleDO;

/**
 * @Author: Hao-ZY
 * @Date: 2024/6/19 23:48
 **/
@Mapper
public interface ArticleDetailConvert {

    /**
     * 初始化 convert 实例
     */
    ArticleDetailConvert INSTANCE = Mappers.getMapper(ArticleDetailConvert.class);

    /**
     * 将 DO 转化为 VO
     * @param bean
     * @return
     */
    FindArticleDetailRspVO convertDO2VO(ArticleDO bean);
}
