package top.hdy.weblog.module.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import top.hdy.weblog.module.admin.model.vo.category.AddCategoryReqVO;
import top.hdy.weblog.module.admin.model.vo.category.DeleteCategoryReqVO;
import top.hdy.weblog.module.admin.model.vo.category.FindCategoryPageListReqVO;
import top.hdy.weblog.module.admin.model.vo.category.FindCategoryPageListRspVO;
import top.hdy.weblog.module.admin.service.AdminCategoryService;
import top.hdy.weblog.module.common.domain.dos.CategoryDO;
import top.hdy.weblog.module.common.domain.mapper.CategoryMapper;
import top.hdy.weblog.module.common.enums.ResponseCodeEnum;
import top.hdy.weblog.module.common.exception.BizException;
import top.hdy.weblog.module.common.model.vo.SelectRspVO;
import top.hdy.weblog.module.common.utils.PageResponse;
import top.hdy.weblog.module.common.utils.Response;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @Author: Hao-ZY
 * @Date: 2024/6/3 22:32
 **/
@Service
@Slf4j
public class AdminCategoryServiceImpl implements AdminCategoryService {

    @Autowired
    private CategoryMapper categoryMapper;


    /**
     * 添加分类
     *
     * @param addCategoryReqVO
     * @return
     */
    @Override
    public Response addCategory(AddCategoryReqVO addCategoryReqVO) {
        String categoryName = addCategoryReqVO.getName();

        // 先判断该分类是否已经存在
        CategoryDO categoryDO = categoryMapper.selectByName(categoryName);
        if (Objects.nonNull(categoryDO)) {
            log.warn("分类名称： {}, 此分类已存在", categoryName);
            throw new BizException(ResponseCodeEnum.CATEGORY_NAME_IS_EXISTED);
        }

        CategoryDO insertCateGory = CategoryDO.builder().name(addCategoryReqVO.getName().trim()).build();
        //   CategoryDO insertCateGory = CategoryDO.builder().name(categoryName.trim()).build();

        categoryMapper.insert(insertCateGory);
        return Response.success();
    }

    @Override
    public PageResponse findCategoryList(FindCategoryPageListReqVO findCategoryPageListReqVO) {
        // 获取当前页、以及每页需要展示的数据数量
        Long current = findCategoryPageListReqVO.getCurrent();
        Long size = findCategoryPageListReqVO.getSize();

        // 分页对象(查询第几页、每页多少数据)
        Page<CategoryDO> page = new Page<>(current, size);

        // 构建查询条件
        LambdaQueryWrapper<CategoryDO> wrapper = new LambdaQueryWrapper<>();

        String name = findCategoryPageListReqVO.getName();
        LocalDate startDate = findCategoryPageListReqVO.getStartDate();
        LocalDate endDate = findCategoryPageListReqVO.getEndDate();

        wrapper
                .like(StringUtils.isNotBlank(name), CategoryDO::getName, name.trim()) // like 模块查询
                .ge(Objects.nonNull(startDate), CategoryDO::getCreateTime, startDate) // 大于等于 startDate
                .le(Objects.nonNull(endDate), CategoryDO::getCreateTime, endDate)  // 小于等于 endDate
                .orderByDesc(CategoryDO::getCreateTime); // 按创建时间倒叙

        Page<CategoryDO> categoryDOPage = categoryMapper.selectPage(page, wrapper);

        List<CategoryDO> categoryDOS = categoryDOPage.getRecords();

        // DO 转 VO
        List<FindCategoryPageListRspVO> vos = null;
        if (!CollectionUtils.isEmpty(categoryDOS)) {
            vos = categoryDOS.stream()
                    .map(categoryDO -> FindCategoryPageListRspVO.builder()
                            .id(categoryDO.getId())
                            .name(categoryDO.getName())
                            .createTime(categoryDO.getCreateTime())
                            .build())
                    .collect(Collectors.toList());
        }

        return PageResponse.success(categoryDOPage, vos);
    }

    @Override
    public Response deleteCategory(DeleteCategoryReqVO deleteCategoryReqVO) {
        // 分类 ID
        Long categoryId = deleteCategoryReqVO.getId();

        // 删除分类
        categoryMapper.deleteById(categoryId);

        return Response.success();
    }

    @Override
    public Response findCategorySelectList() {
        List<CategoryDO> categoryDOS = categoryMapper.selectList(null);

        List<SelectRspVO> selectRspVOS = null;

        if (!CollectionUtils.isEmpty(categoryDOS)) {
            selectRspVOS = categoryDOS.stream().map(categoryDO -> SelectRspVO.builder().label(categoryDO.getName()).value(categoryDO.getId()).build()).collect(Collectors.toList());
        }
        return Response.success(selectRspVOS);
    }
}

