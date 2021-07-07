package com.zfile.code.stents.impl;

import cn.hutool.core.collection.ListUtil;
import cn.hutool.core.util.RuntimeUtil;
import com.xiaoTools.core.result.Result;
import com.zfile.code.entity.category.dto.SaveCategory;
import com.zfile.code.entity.category.po.Category;
import com.zfile.code.entity.script.dto.SaveScript;
import com.zfile.code.entity.script.dto.ScriptValue;
import com.zfile.code.entity.script.po.Script;
import com.zfile.code.service.CategoryService;
import com.zfile.code.service.ScriptService;
import com.zfile.code.stents.ScriptStents;
import com.zfile.code.util.BeanUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * [脚本中间层](Script middle layer)
 * @description: zh - 脚本中间层
 * @description: en - Script middle layer
 * @version: V1.0
 * @author XiaoXunYao
 * @since 2021/7/6 8:41 上午
 */
@Service
public class ScriptStentsImpl implements ScriptStents {

    private final Logger log = LoggerFactory.getLogger(ScriptStentsImpl.class);

    @Resource
    private CategoryService categoryService;

    @Resource
    private ScriptService scriptService;

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
    @Override
    public Result saveCategory(SaveCategory saveCategory, String path) {
        //进行实体类拷贝
        Category category = BeanUtil.copy(saveCategory, Category.class);
        //进行存储
        return categoryService.save(category) ?
                new Result().result200(category.getCategoryName() + ",保存成功",path) :
                new Result().result500(category.getCategoryName() + ",保存失败",path);
    }

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
    @Override
    public Result save(SaveScript saveScript, String path) {
        //判断脚本序号是否正确
        if (categoryService.getById(saveScript.getCategoryId()) == null) {
            return new Result().result404("脚本的序号选择错误了!",path);
        }
        //删除该脚本序号的脚本内容
        if (!scriptService.removeByCategoryId(saveScript.getCategoryId())) {
            return new Result().result404("删除之前的脚本错误了",path);
        }
        //判断位数是否正确
        List<ScriptValue> scriptValues = saveScript.getScriptValues();
        //通过digit的属性值排序
        scriptValues = ListUtil.sortByProperty(scriptValues, "digit");
        //判断排序是否正确
        if (scriptValues.get(scriptValues.size() - 1).getDigit() != scriptValues.size()) {
            return new Result().result415("脚本的序号不正确，请重新排序",path);
        }
        List<Script> scripts = BeanUtil.batchCopy(scriptValues, Script.class);
        for (Script script : scripts) {
            script.setCategoryId(saveScript.getCategoryId());
        }
        return scriptService.saveBatch(scripts) ?
                new Result().result200("保存脚本成功",path) :
                new Result().result500("保存脚本失败",path);
    }

    /**
     * [用户输入脚本，进行运行。](The user enters the script and runs it.)
     * @description: zh - 用户输入脚本，进行运行。
     * @description: en - The user enters the script and runs it.
     * @version: V1.0
     * @author XiaoXunYao
     * @since 2021/7/7 7:11 下午
     * @param shell: shell语句，如下简称脚本
     * @param path: URL路径
     * @return com.xiaoTools.core.result.Result
     */
    @Override
    public Result run(String shell, String path) {
        //不判断脚本是否正确，直接运行脚本，「有问题，系统会判断」
        return new Result().result200(RuntimeUtil.execForStr(shell),path);
    }


}
