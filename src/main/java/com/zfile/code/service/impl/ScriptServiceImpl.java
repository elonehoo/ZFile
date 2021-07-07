package com.zfile.code.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zfile.code.entity.script.po.Script;
import com.zfile.code.entity.script.vo.RunScript;
import com.zfile.code.mapper.ScriptMapper;
import com.zfile.code.service.ScriptService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * [脚本信息](Script information)
 * @description: zh - 脚本信息
 * @description: en - Script information
 * @version: V1.0
 * @author XiaoXunYao
 * @since 2021/7/5 8:16 下午
*/
@Service
public class ScriptServiceImpl extends ServiceImpl<ScriptMapper, Script> implements ScriptService {

    @Resource
    private ScriptMapper scriptMapper;

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
    @Override
    public boolean removeByCategoryId(String categoryId) {
        return scriptMapper.removeByCategoryId(categoryId) >= 0;
    }

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
    @Override
    public List<RunScript> getByCategoryId(String categoryId) {
        return scriptMapper.getByCategoryId(categoryId);
    }
}
