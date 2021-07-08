package com.zfile.code.controller.script;

import cn.dev33.satoken.annotation.SaCheckLogin;
import com.xiaoTools.core.result.Result;
import com.zfile.code.entity.category.dto.SaveCategory;
import com.zfile.code.entity.script.dto.RunsScript;
import com.zfile.code.entity.script.dto.SaveScript;
import com.zfile.code.stents.ScriptStents;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * [脚本API](ScriptAPI)
 * @description: zh - 脚本API
 * @description: en - ScriptAPI
 * @version: V1.0
 * @author XiaoXunYao
 * @since 2021/7/6 8:41 上午
 */
@CrossOrigin
@RestController
@RequestMapping("/script")
@Api(tags = {"脚本层"})
public class ScriptController {

    @Resource
    private ScriptStents scriptStents;

    @Resource
    private HttpServletRequest request;

    /**
     * [保存用户的脚本类别模块](Save user's script category module)
     * @description: zh - 保存用户的脚本类别模块
     * @description: en - Save user's script category module
     * @version: V1.0
     * @author XiaoXunYao
     * @since 2021/7/6 11:23 上午
     * @param saveCategory: 用户的脚本类别模块
     * @return com.xiaoTools.core.result.Result
    */
    @SaCheckLogin
    @Operation(summary = "保存用户的脚本类别模块")
    @PostMapping("/category")
    public Result category(@RequestBody @Valid SaveCategory saveCategory){
        return scriptStents.saveCategory(saveCategory,request.getRequestURI());
    }

    /**
     * [保存用户的脚本模块](Save user's script module)
     * @description: zh - 保存用户的脚本模块
     * @description: en - Save user's script module
     * @version: V1.0
     * @author XiaoXunYao
     * @since 2021/7/6 4:17 下午
     * @param saveScript: 用户的脚本模块
     * @return com.xiaoTools.core.result.Result
    */
    @SaCheckLogin
    @PostMapping("/save")
    @Operation(summary = "保存用户的脚本模块")
    public Result save(@RequestBody SaveScript saveScript){
        return scriptStents.save(saveScript,request.getRequestURI());
    }

    /**
     * [用户输入脚本，并且运行](The user enters the script and runs it)
     * @description: zh - 用户输入脚本，并且运行
     * @description: en - The user enters the script and runs it
     * @version: V1.0
     * @author XiaoXunYao
     * @since 2021/7/7 7:15 下午
     * @param shell: shell命令
     * @return com.xiaoTools.core.result.Result
    */
    @SaCheckLogin
    @GetMapping("/run")
    @Operation(summary = "用户输入脚本，并且运行")
    public Result run(@RequestParam String shell){
        return scriptStents.run(shell,request.getRequestURI());
    }

    /**
     * [执行保存好的脚本集合，安装软件，暂时不可以用](Execute the saved script set and install the software. It is temporarily unavailable)
     * @description: zh - 执行保存好的脚本集合，安装软件，暂时不可以用
     * @description: en - Execute the saved script set and install the software. It is temporarily unavailable
     * @version: V1.0
     * @author XiaoXunYao
     * @since 2021/7/8 1:03 下午
     * @param runsScript: 运行脚本集合的类别序号
     * @return com.xiaoTools.core.result.Result
    */
    @SaCheckLogin
    @PostMapping("/runs")
    @Operation(summary = "执行保存好的脚本集合，安装软件，暂时不可以用")
    public Result runs(@RequestBody RunsScript runsScript){
        return scriptStents.runs(runsScript,request.getRequestURI());
    }


}
