package com.zfile.code.controller.file;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.hutool.core.io.FileTypeUtil;
import com.xiaoTools.core.result.Result;
import com.zfile.code.entity.file.dto.Folder;
import com.zfile.code.entity.file.dto.Mkdir;
import com.zfile.code.entity.file.dto.Touch;
import com.zfile.code.entity.file.dto.Write;
import com.zfile.code.stents.FileStents;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.v3.oas.annotations.Operation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

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
    public Result mkdir(@RequestBody Mkdir mkdir){
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
    public Result touch(@RequestBody Touch touch){
        return fileStents.touch(touch,request.getRequestURI());
    }

    /**
     * [删除文件或者文件夹](Delete a file or folder)
     * @description: zh - 删除文件或者文件夹
     * @description: en - Delete a file or folder
     * @version: V1.0
     * @author XiaoXunYao
     * @since 2021/6/28 9:07 上午
     * @param removePath: 文件地址
     * @return com.xiaoTools.core.result.Result
    */
    @SaCheckLogin
    @DeleteMapping("/remove")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "removePath",value = "删除文件的目录",dataTypeClass = String.class,dataType = "String",paramType = "query"),
            @ApiImplicitParam(name = "removeName",value = "删除的文件的名字",dataTypeClass = String[].class,dataType = "String[]",paramType = "query"),
    })
    @Operation(summary = "删除文件和文件夹")
    public Result remove(@RequestParam String removePath,
                         @RequestParam String[] removeName){
        return fileStents.remove(removePath,removeName,request.getRequestURI());
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
    @SaCheckLogin
    @PostMapping("/upload")
    @Operation(summary = "上传文件")
    public Result upload(@RequestPart List<MultipartFile> files, Folder folder){
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
    @SaCheckLogin
    @GetMapping("/upload")
    @Operation(summary = "展示文件上传的百分比")
    public Result showUpload(HttpServletRequest request) {
        HttpSession session = request.getSession();
        double percent = session.getAttribute("upload_percent") == null ? 0.00 : (double) session.getAttribute("upload_percent");
        log.info("上传进度 --> {}",percent);
        return new Result().result200(percent,request.getRequestURI());
    }

    /**
     * [删除上传的文件进度](Progress of deleting uploaded files)
     * @description: zh - 删除上传的文件进度
     * @description: en - Progress of deleting uploaded files
     * @version: V1.0
     * @author XiaoXunYao
     * @since 2021/7/2 1:52 下午
     * @param request: 上传进度
     * @return com.xiaoTools.core.result.Result
    */
    @SaCheckLogin
    @DeleteMapping("/upload")
    @Operation(summary = "删除上传的文件进度")
    public Result delete(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.setAttribute("upload_percent",0.00);
        return new Result().result200("重制上传进度",request.getRequestURI());
    }

    /**
     * [下载文件](Download files)
     * @description: zh - 下载文件
     * @description: en - Download files
     * @version: V1.0
     * @author XiaoXunYao
     * @since 2021/7/3 8:58 上午
     * @param downPath: 下载文件的路径
     * @param response: 返回模块
    */
    @SaCheckLogin
    @GetMapping("/download")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "downPath",value = "下载文件的路径",dataTypeClass = String.class,dataType = "String",paramType = "query"),
    })
    @Operation(summary = "下载文件")
    public void download(@RequestParam String downPath, HttpServletResponse response){
        try {
            //需要下载的file路径
            File file = new File(downPath);
            String fileName = file.getName();
            InputStream inputStream = new FileInputStream(file);
            response.setContentType("application/force-download");
            //新建字节输出流
            OutputStream out = response.getOutputStream();
            //使用URLEncoder来防止文件名乱码或者读取错误
            response.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(fileName, StandardCharsets.UTF_8));
            int b = 0;
            byte[] buffer = new byte[1000000];
            //读写
            while (b != -1) {
                //读取文件信息
                b = inputStream.read(buffer);
                if (b != -1) {
                    //写入文件信息,当 b=-1 时，读写结束
                    out.write(buffer, 0, b);
                }
            }
            //清楚缓冲区并关闭流对象
            inputStream.close();
            out.close();
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * [打开文件](Open file)
     * @description: zh - 打开文件
     * @description: en - Open file
     * @version: V1.0
     * @author XiaoXunYao
     * @since 2021/7/7 7:53 下午
     * @param filePath: 打开文件的路径
     * @return com.xiaoTools.core.result.Result
    */
    @SaCheckLogin
    @GetMapping("/read")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "filePath",value = "打开文件的路径",dataTypeClass = String.class,dataType = "String",paramType = "query"),
    })
    @Operation(summary = "打开文件")
    public Result read(@RequestParam String filePath){
        return fileStents.read(filePath, request.getRequestURI());
    }

    /**
     * [打开图片](Open picture)
     * @description: zh - 打开图片
     * @description: en - Open picture
     * @version: V1.0
     * @author XiaoXunYao
     * @since 2021/7/14 2:58 下午
     * @param filePath: 文件地址
     * @param response: 返回设置
    */
    @SaCheckLogin
    @GetMapping("/readImage")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "filePath",value = "打开文件的路径",dataTypeClass = String.class,dataType = "String",paramType = "query"),
    })
    @Operation(summary = "打开图片")
    public void readImage(@RequestParam String filePath,
                          HttpServletResponse response){
        //判断类型
        //设置图片的后缀模式
        String type = FileTypeUtil.getType(cn.hutool.core.io.FileUtil.file(filePath));
        if ( ( "jpg".equals(type) ) || ( "gif".equals(type) ) || ( "png".equals(type) ) || ( "bmp".equals(type) ) ) {
            ServletOutputStream out = null;
            FileInputStream ips = null;
            try {
                //获取图片存放路径
                ips = new FileInputStream(filePath);
                response.setContentType("multipart/form-data");
                out = response.getOutputStream();
                //读取文件流
                int len;
                byte[] buffer = new byte[1024 * 10];
                while ((len = ips.read(buffer)) != -1){
                    out.write(buffer,0,len);
                }
                out.flush();
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                try {
                    assert out != null;
                    out.close();
                    ips.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * [将内容写入文本](Write content to text)
     * @description: zh - 将内容写入文本
     * @description: en - Write content to text
     * @version: V1.0
     * @author XiaoXunYao
     * @since 2021/7/14 3:34 下午
     * @param write: 写入文本的实体
     * @return com.xiaoTools.core.result.Result
    */
    @SaCheckLogin
    @PostMapping("/write")
    @Operation(summary = "将内容写入文本")
    public Result write(@RequestBody Write write){
        return fileStents.write(write,request.getRequestURI());
    }

}
