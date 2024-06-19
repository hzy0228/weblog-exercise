package top.hdy.weblog.module.admin.service;

import top.hdy.weblog.module.admin.model.vo.article.DeleteArticleReqVO;
import top.hdy.weblog.module.admin.model.vo.article.FindArticlePageListReqVO;
import top.hdy.weblog.module.admin.model.vo.article.PublishArticleReqVO;
import top.hdy.weblog.module.common.utils.Response;

/**
 * @Author: Hao-ZY
 * @Date: 2024/6/14 22:35
 **/
public interface AdminArticleService {

    /**
     * 发布文章
     *
     * @param publishArticleReqVO
     * @return
     */
    Response publishArticle(PublishArticleReqVO publishArticleReqVO);


    /**
     * 删除文章
     *
     * @param deleteArticleReqVO
     * @return
     */
    Response deleteArticle(DeleteArticleReqVO deleteArticleReqVO);


    /**
     * 查询文章分页数据
     * @param findArticlePageListReqVO
     * @return
     */
    Response findArticlePageList(FindArticlePageListReqVO findArticlePageListReqVO);
}
