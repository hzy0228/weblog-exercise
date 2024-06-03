package top.hdy.weblog.module.admin.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.hdy.weblog.module.admin.model.vo.category.AddCategoryReqVO;
import top.hdy.weblog.module.admin.model.vo.category.DeleteCategoryReqVO;
import top.hdy.weblog.module.admin.model.vo.category.FindCategoryPageListReqVO;
import top.hdy.weblog.module.admin.service.AdminCategoryService;
import top.hdy.weblog.module.common.aspect.ApiOperationLog;
import top.hdy.weblog.module.common.utils.PageResponse;
import top.hdy.weblog.module.common.utils.Response;

/**
 * @Author: Hao-ZY
 * @Date: 2024/6/3 22:49
 **/
@RestController
@RequestMapping("/admin")
@Api(tags = "Admin 分类模块")
public class AdminCategoryController {

    @Autowired
    private AdminCategoryService adminCategoryService;

    @PostMapping("/category/add")
    @ApiOperation(value = "添加分类")
    @ApiOperationLog(description = "添加分类")
    public Response addCategory(@RequestBody @Validated AddCategoryReqVO addCategoryReqVO) {
        return adminCategoryService.addCategory(addCategoryReqVO);
    }


    @PostMapping("/category/list")
    @ApiOperation(value = "分类分页数据获取")
    @ApiOperationLog(description = "分类分页数据获取")
    public PageResponse findCategoryList(@RequestBody @Validated FindCategoryPageListReqVO findCategoryPageListReqVO) {
        return adminCategoryService.findCategoryList(findCategoryPageListReqVO);
    }

    @PostMapping("/category/delete")
    @ApiOperation(value = "删除分类")
    @ApiOperationLog(description = "删除分类")
    public Response deleteCategory(@RequestBody @Validated DeleteCategoryReqVO deleteCategoryReqVO) {
        return adminCategoryService.deleteCategory(deleteCategoryReqVO);
    }

}
