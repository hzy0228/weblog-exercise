package top.hdy.weblog.module.common.domain.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import top.hdy.weblog.module.common.domain.dos.ArticleContentDO;

/**
 * @Author: Hao-ZY
 * @Date: 2024/6/14 22:27
 **/
public interface ArticleContentMapper extends BaseMapper<ArticleContentDO> {


    /**
     * 根据文章ID删除记录
     *
     * @param articleId
     * @return
     */
    default int deleteByArticleId(Long articleId) {
        return delete(Wrappers.<ArticleContentDO>lambdaQuery()
                .eq(ArticleContentDO::getArticleId, articleId)
        );
    }


    /**
     * 根据文章 ID 查询
     *
     * @param articleId
     * @return
     */
    default ArticleContentDO selectByArticleId(Long articleId) {
        return selectOne(Wrappers.<ArticleContentDO>lambdaQuery()
                .eq(ArticleContentDO::getArticleId, articleId));
    }


    default int updateByArticleId(ArticleContentDO articleContentDO) {
        return update(articleContentDO,
                Wrappers.<ArticleContentDO>lambdaUpdate()
                        .eq(ArticleContentDO::getArticleId, articleContentDO.getArticleId()));
    }
}
