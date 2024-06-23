package top.hdy.weblog.module.common.domain.mapper;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import top.hdy.weblog.module.common.config.InsertBatchMapper;
import top.hdy.weblog.module.common.domain.dos.ArticleTagRelDO;

import java.util.List;

/**
 * @Author: Hao-ZY
 * @Date: 2024/6/14 22:29
 **/
public interface ArticleTagRelMapper extends InsertBatchMapper<ArticleTagRelDO> {


    /**
     * 根据文章ID删除关联记录
     *
     * @param articleId
     * @return
     */
    default int deleteByArticleId(Long articleId) {
        return delete(Wrappers.<ArticleTagRelDO>lambdaQuery()
                .eq(ArticleTagRelDO::getArticleId, articleId)
        );
    }


    /**
     * 根据文章 ID 查询
     *
     * @param articleId
     * @return
     */
    default List<ArticleTagRelDO> selectByArticleId(Long articleId) {
        return selectList(Wrappers.<ArticleTagRelDO>lambdaQuery()
                .eq(ArticleTagRelDO::getArticleId, articleId));
    }
}
