package com.zfile.code.controller.base;

import com.xiaoTools.core.result.Result;

import com.zfile.code.stents.BaseStents;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.v3.oas.annotations.Operation;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 基础Controller
 * @author HCY
 * @since 2021/4/28 4:31 下午
*/
@CrossOrigin
@RestController
@RequestMapping("/base")
@Api(tags = {"基础Controller"})
public class BaseController {

    /**
     * 基础支架的接口
    */
    @Resource
    private BaseStents baseStents;

    @Resource
    private HttpServletRequest request;

    /**
     * 判断是否已经完善了初始化
     * @author HCY
     * @since 2021/4/28 8:18 下午
     * @return com.xiaoTools.core.result.Result
    */
    @Operation(summary = "判断是否已经完善了初始化")
    @GetMapping(value = "/initialization",produces = MediaType.APPLICATION_JSON_VALUE)
    public Result initialization(){
        return baseStents.getInitialization(request.getRequestURI());
    }

    /**
     * 获取路径中的[文件](文件夹)
     * @author HCY
     * @since 2021/5/13 9:03 上午
     * @param path: 查看的路径
     * @return com.xiaoTools.core.result.Result
    */
    @Operation(summary = "获取路径中的[文件](文件夹)")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "path",value = "查看的路径",dataTypeClass = String.class,dataType = "String",paramType = "query",defaultValue = "/"),
    })
    @GetMapping(value = "/see",produces = MediaType.APPLICATION_JSON_VALUE)
    public Result see(@RequestParam(value = "path",defaultValue = "/") String path){
        return baseStents.getSeeContent(path,request.getRequestURI());
    }

    /**
     * [获取系统的性能信息](Get the performance information of the system)
     * @description: zh - 获取系统的性能信息
     * @description: en - Get the performance information of the system
     * @version: V1.0
     * @author XiaoXunYao
     * @since 2021/5/31 5:49 下午
     * @return com.xiaoTools.core.result.Result
    */
    @Operation(summary = "获取系统的性能信息")
    @GetMapping(value = "/system",produces = MediaType.APPLICATION_JSON_VALUE)
    public Result system(){
        return baseStents.getSystemInfo(request.getRequestURI());
    }

    @Operation(summary = "跳转到index页面")
    @RequestMapping("/zfile/**")
    public ModelAndView getNeMoInTree() {

        System.out.println("=========跳转到index页面===================");
        return new ModelAndView("index");
    }
}
