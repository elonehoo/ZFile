package com.zfile.code.controller.file;

import cn.dev33.satoken.annotation.SaCheckLogin;
import com.xiaoTools.core.result.Result;
import com.zfile.code.entity.file.dto.Folder;
import com.zfile.code.entity.file.dto.Mkdir;
import com.zfile.code.entity.file.dto.Remove;
import com.zfile.code.entity.file.dto.Touch;
import com.zfile.code.entity.progress.vo.ProgressEntity;
import com.zfile.code.resolver.CustomMultipartResolver;
import com.zfile.code.stents.FileStents;
import com.zfile.code.stents.impl.BaseStentsImpl;
import com.zfile.code.util.FileUtil;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUpload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

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
     * 通用session模块
     */
    @Resource
    private HttpSession session;

    /**
     * 日志
     */
    private final Logger log = LoggerFactory.getLogger(FileController.class);

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

    /**
     * [上传文件](Upload file)
     * @description: zh - 上传文件
     * @description: en - Upload file
     * @version: V1.0
     * @author XiaoXunYao
     * @since 2021/6/29 9:37 下午
     * @param folder: 文件
     * @return com.xiaoTools.core.result.Result
    */
    @PostMapping("/upload")
    @Operation(summary = "上传文件")
    public Result upload(@RequestPart MultipartFile[] files, Folder folder){
        log.info("上传文件-->{}","开始");
        log.debug("上传的root路径-->{}",folder.getRootPath());
        for (MultipartFile file : files) {
            log.debug("上传的文件名字-->{}",file.getOriginalFilename());
        }
        log.info("上传文件夹-->{}","结束");
        return fileStents.upload(files,folder,request.getRequestURI());
    }

    /**
     * [查看上传的数据](View uploaded data)
     * @description: zh - 查看上传的数据
     * @description: en - View uploaded data
     * @version: V1.0
     * @author XiaoXunYao
     * @since 2021/6/29 9:39 下午
     * @return com.xiaoTools.core.result.Result
    */
    @GetMapping("/showUpload")
    @Operation(summary = "展示文件上传的百分比")
    public Result showUpload() {
        //获取状态
        ProgressEntity status = (ProgressEntity) session.getAttribute("status");
        Map<String, Object> result = new HashMap<>(2);
        result.put("schedule",status.getPContentLength());
        result.put("items",status.getPItems());
        return new Result().result200(result,request.getRequestURI());
    }

}