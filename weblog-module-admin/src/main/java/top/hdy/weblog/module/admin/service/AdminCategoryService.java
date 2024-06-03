package top.hdy.weblog.module.admin.service;

import top.hdy.weblog.module.admin.model.vo.category.AddCategoryReqVO;
import top.hdy.weblog.module.admin.model.vo.category.DeleteCategoryReqVO;
import top.hdy.weblog.module.admin.model.vo.category.FindCategoryPageListReqVO;
import top.hdy.weblog.module.common.utils.PageResponse;
import top.hdy.weblog.module.common.utils.Response;

/**
 * @Author: Hao-ZY
 * @Date: 2024/6/3 22:31
 **/
public interface AdminCategoryService {

    /**
     * 添加分类
     *
     * @param addCategoryReqVO
     * @return
     */
    Response addCategory(AddCategoryReqVO addCategoryReqVO);

    /**
     * 分类分页数据查询
     *
     * @param findCategoryPageListReqVO
     * @return
     */
    PageResponse findCategoryList(FindCategoryPageListReqVO findCategoryPageListReqVO);

    /**
     * 删除分类
     * @param deleteCategoryReqVO
     * @return
     */
    Response deleteCategory(DeleteCategoryReqVO deleteCategoryReqVO);
}
