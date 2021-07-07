package com.zfile.code.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zfile.code.entity.script.po.Script;
import com.zfile.code.entity.script.vo.RunScript;

import java.util.List;

/**
 * [脚本](Script)
 * @description: zh - 脚本
 * @description: en - Script
 * @version: V1.0
 * @author XiaoXunYao
 * @since 2021/7/5 8:05 下午
*/
public interface ScriptMapper extends BaseMapper<Script> {

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
    int removeByCategoryId(String categoryId);

    /**
     * [通过脚本的类别查找类别](Find categories through categories of scripts)
     * @description: zh - 通过脚本的类别查找类别
     * @description: en - Find categories through categories of scripts
     * @version: V1.0
     * @author XiaoXunYao
     * @since 2021/7/7 10:54 上午
     * @param categoryId: 脚本类别的序号
     * @return java.util.List<com.zfile.code.entity.script.vo.RunScript>
     */
    List<RunScript> getByCategoryId(String categoryId);
}
