package top.hdy.weblog.module.admin.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.hdy.weblog.module.admin.model.vo.tag.AddTagReqVO;
import top.hdy.weblog.module.admin.model.vo.tag.DeleteTagReqVO;
import top.hdy.weblog.module.admin.model.vo.tag.FindTagPageListReqVO;
import top.hdy.weblog.module.admin.model.vo.tag.SearchTagReqVO;
import top.hdy.weblog.module.admin.service.AdminTagService;
import top.hdy.weblog.module.common.aspect.ApiOperationLog;
import top.hdy.weblog.module.common.utils.PageResponse;
import top.hdy.weblog.module.common.utils.Response;

/**
 * @Author: Hao-ZY
 * @Date: 2024/6/8 18:27
 **/
@RestController
@RequestMapping("/admin")
@Api(tags = "Admin 标签模块")
public class AdminTagController {

    @Autowired
    private AdminTagService adminTagService;

    @PostMapping("/tag/add")
    @ApiOperation(value = "添加标签")
    @ApiOperationLog(description = "添加标签")
    public Response addTag(@RequestBody @Validated AddTagReqVO addTagReqVO) {
        return adminTagService.addTags(addTagReqVO);
    }

    @PostMapping("/tag/list")
    @ApiOperation(value = "标签分页数据获取")
    @ApiOperationLog(description = "标签分页数据获取")
    public PageResponse findTagPageList(@RequestBody @Validated FindTagPageListReqVO findTagPageListReqVO) {
        return adminTagService.findTagPageList(findTagPageListReqVO);
    }

    @PostMapping("/tag/delete")
    @ApiOperation(value = "删除标签")
    @ApiOperationLog(description = "删除标签")
    public Response deleteTag(@RequestBody @Validated DeleteTagReqVO deleteTagReqVO) {
        return adminTagService.deleteTag(deleteTagReqVO);
    }


    @PostMapping("/tag/search")
    @ApiOperation(value = "标签模糊查询")
    @ApiOperationLog(description = "标签模糊查询")
    public Response searchTag(@RequestBody @Validated SearchTagReqVO searchTagReqVO) {
        return adminTagService.searchTag(searchTagReqVO);
    }
}
