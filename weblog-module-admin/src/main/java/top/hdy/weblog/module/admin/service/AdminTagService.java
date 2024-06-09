package top.hdy.weblog.module.admin.service;

import top.hdy.weblog.module.admin.model.vo.tag.AddTagReqVO;
import top.hdy.weblog.module.admin.model.vo.tag.DeleteTagReqVO;
import top.hdy.weblog.module.admin.model.vo.tag.FindTagPageListReqVO;
import top.hdy.weblog.module.admin.model.vo.tag.SearchTagReqVO;
import top.hdy.weblog.module.common.utils.PageResponse;
import top.hdy.weblog.module.common.utils.Response;

/**
 * @Author: Hao-ZY
 * @Date: 2024/6/8 18:29
 **/
public interface AdminTagService {

    /**
     * 添加标签集合
     *
     * @param addTagReqVO
     * @return
     */
    Response addTags(AddTagReqVO addTagReqVO);

    /**
     * 查询标签分页
     *
     * @param findTagPageListReqVO
     * @return
     */
    PageResponse findTagPageList(FindTagPageListReqVO findTagPageListReqVO);


    /**
     * 删除标签
     *
     * @param deleteTagReqVO
     * @return
     */
    Response deleteTag(DeleteTagReqVO deleteTagReqVO);


    /**
     * 标签模糊查询
     *
     * @param searchTagReqVO
     * @return
     */
    Response searchTag(SearchTagReqVO searchTagReqVO);
}
