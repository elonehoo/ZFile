package com.zfile.code.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zfile.code.entity.category.po.Category;
import com.zfile.code.entity.script.po.Script;

/**
 * [脚本类别服务层](Script category service layer)
 * @description: zh - 脚本类别服务层
 * @description: en - Script category service layer
 * @version: V1.0
 * @author XiaoXunYao
 * @since 2021/7/5 8:06 下午
*/
public interface ScriptService extends IService<Script> {

    /**
     * [根据脚本类别的序号删除类别](Delete the category according to the sequence number of the script category)
     * @description: zh - 根据脚本类别的序号删除类别
     * @description: en - Delete the category according to the sequence number of the script category
     * @version: V1.0
     * @author XiaoXunYao
     * @since 2021/7/6 5:35 下午
     * @param categoryId: 脚本类别的序号
     * @return boolean
    */
    boolean removeByCategoryId(String categoryId);
}
