package com.zfile.code.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zfile.code.entity.category.po.Category;
import com.zfile.code.mapper.CategoryMapper;
import com.zfile.code.service.CategoryService;
import org.springframework.stereotype.Service;

/**
 * [脚本类别服务层](Script category service layer)
 * @description: zh - 脚本类别服务层
 * @description: en - Script category service layer
 * @version: V1.0
 * @author XiaoXunYao
 * @since 2021/7/5 8:06 下午
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {

}
