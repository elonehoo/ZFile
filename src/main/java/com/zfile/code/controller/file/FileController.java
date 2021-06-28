package com.zfile.code.controller.file;

import cn.dev33.satoken.annotation.SaCheckLogin;
import com.xiaoTools.core.result.Result;
import com.zfile.code.entity.file.dto.Mkdir;
import com.zfile.code.entity.file.dto.Remove;
import com.zfile.code.entity.file.dto.Touch;
import com.zfile.code.stents.FileStents;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * [文件模块](File module)
 * @description: zh - 文件模块
 * @description: en - File module
 * @version: V1.0
 * @author XiaoXunYao
 * @since 2021/6/28 8:53 上午
*/
@CrossOrigin
@RestController
@RequestMapping("/file")
@Api(tags = {"用户文件控制层"})
public class FileController {

    /**
     * 获取「path」路径的「request」
     */
    @Resource
    private HttpServletRequest request;

    /**
     * 核心理念处理模块
     */
    @Resource
    private FileStents fileStents;

    /**
     * [创建文件目录](Create file directory)
     * @description: zh - 创建文件目录
     * @description: en - Create file directory
     * @version: V1.3
     * @author XiaoXunYao
     * @since 2021/6/27 10:15 上午
     * @param mkdir: 创建文件地址
     * @return com.xiaoTools.core.result.Result
     */
    @SaCheckLogin
    @PostMapping("/mkdir")
    @Operation(summary = "创建文件目录")
    public Result postMkdir(@RequestBody Mkdir mkdir){
        return fileStents.mkdir(mkdir,request.getRequestURI());
    }

    /**
     * [创建文件](create a file)
     * @description: zh - 创建文件
     * @description: en - create a file
     * @version: V1.0
     * @author XiaoXunYao
     * @since 2021/6/27 12:20 下午
     * @param touch: 创建文件
     * @return com.xiaoTools.core.result.Result
     */
    @SaCheckLogin
    @PostMapping("/touch")
    @Operation(summary = "创建文件")
    public Result postTouch(@RequestBody Touch touch){
        return fileStents.touch(touch,request.getRequestURI());
    }

    /**
     * [删除文件或者文件夹](Delete a file or folder)
     * @description: zh - 删除文件或者文件夹
     * @description: en - Delete a file or folder
     * @version: V1.0
     * @author XiaoXunYao
     * @since 2021/6/28 9:07 上午
     * @param remove: 文件地址
     * @return com.xiaoTools.core.result.Result
    */
    @SaCheckLogin
    @DeleteMapping("/remove")
    @Operation(summary = "删除文件和文件夹")
    public Result remove(@RequestBody Remove remove){
        return fileStents.remove(remove,request.getRequestURI());
    }
}
