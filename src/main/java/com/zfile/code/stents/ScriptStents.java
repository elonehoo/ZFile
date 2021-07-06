package com.zfile.code.stents;

import com.xiaoTools.core.result.Result;
import com.zfile.code.entity.category.dto.SaveCategory;
import com.zfile.code.entity.script.dto.SaveScript;

/**
 * [脚本中间层](Script middle layer)
 * @description: zh - 脚本中间层
 * @description: en - Script middle layer
 * @version: V1.0
 * @author XiaoXunYao
 * @since 2021/7/6 8:41 上午
*/
public interface ScriptStents {

    /**
     * [保存的类别名称](Saved category name)
     * @description: zh - 保存的类别名称
     * @description: en - Saved category name
     * @version: V1.0
     * @author XiaoXunYao
     * @since 2021/7/6 8:55 上午
     * @param saveCategory: 保存的类别名称
     * @param path: URL路径
     * @return com.xiaoTools.core.result.Result
    */
    Result saveCategory(SaveCategory saveCategory, String path);

    /**
     * [保存具体类别的脚本](Save scripts for specific categories)
     * @description: zh - 保存具体类别的脚本
     * @description: en - Save scripts for specific categories
     * @version: V1.0
     * @author XiaoXunYao
     * @since 2021/7/6 4:18 下午
     * @param saveScript: 保存的脚本
     * @param path: URL路径
     * @return com.xiaoTools.core.result.Result
    */
    Result save(SaveScript saveScript, String path);
}
