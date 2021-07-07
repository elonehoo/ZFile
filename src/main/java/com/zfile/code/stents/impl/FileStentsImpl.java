package com.zfile.code.stents.impl;

import cn.hutool.core.io.file.FileNameUtil;
import cn.hutool.core.io.file.FileReader;
import com.xiaoTools.core.fileUtil.fileUtil.FileUtil;
import com.xiaoTools.core.result.Result;
import com.xiaoTools.core.strUtil.StrUtil;
import com.zfile.code.entity.file.dto.Folder;
import com.zfile.code.entity.file.dto.Mkdir;
import com.zfile.code.entity.file.dto.Touch;
import com.zfile.code.service.LogService;
import com.zfile.code.stents.FileStents;
import com.zfile.code.util.FileTemporaryUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.util.Arrays;
import java.util.List;

/**
 * [文件接口的中间层](The middle layer of file interface)
 * @description: zh - 文件接口的中间层
 * @description: en - The middle layer of file interface
 * @version: V1.0
 * @author XiaoXunYao
 * @since 2021/6/28 8:58 上午
*/
@Service
public class FileStentsImpl implements FileStents {

    private final Logger log = LoggerFactory.getLogger(FileStentsImpl.class);

    @Resource
    private LogService logService;

    /**
     * [创建文件目录](Create file directory)
     * @description: zh - 创建文件目录
     * @description: en - Create file directory
     * @version: V1.3
     * @author XiaoXunYao
     * @since 2021/6/26 5:11 下午
     * @param mkdir: 文件目录的地址和名字
     * @param path: URL 路径
     * @return com.xiaoTools.core.result.Result
     */
    @Override
    public Result mkdir(Mkdir mkdir, String path) {
        //判断地址是否不会产生错误
        //0. 查看mkdir的地址最后是不是「/」结尾
        String address = "/".equals(StrUtil.sub(mkdir.getAddress(),mkdir.getAddress().length() - 1 ,mkdir.getAddress().length() + 1)) ? mkdir.getAddress() : mkdir.getAddress() + "/";
        //1. 查看mkdir的目录开头是不是「/」开始
        String fileName = "/".equals(StrUtil.sub(mkdir.getFileName(),0,1)) ? StrUtil.sub(mkdir.getFileName(),1,mkdir.getFileName().length()) : mkdir.getFileName();
        //进行目录地址拼接
        String filePath = address + fileName;
        if ( FileUtil.mkdir(new File(filePath)) ){
            logService.log("在「" + address + "」目录下创建了「" + fileName + "」文件夹");
            return  new Result().result200("创建目录成功",path);
        }else {
            logService.log("未在「" + address + "」目录下创建了「" + fileName + "」文件夹");
            return new Result().result409("创建目录失败",path);
        }

    }

    /**
     * [创建文件](create a file)
     * @description: zh - 创建文件
     * @description: en - create a file
     * @version: V1.0
     * @author XiaoXunYao
     * @since 2021/6/27 12:16 下午
     * @param touch: 创建文件的地址和名字
     * @param path: URL路径
     * @return com.xiaoTools.core.result.Result
     */
    @Override
    public Result touch(Touch touch, String path) {
        //判断地址是否不会产生错误
        //0. 查看mkdir的地址最后是不是「/」结尾
        String address = "/".equals(StrUtil.sub(touch.getAddress(),touch.getAddress().length() - 1 ,touch.getAddress().length() + 1)) ? touch.getAddress() : touch.getAddress() + "/";
        //1. 查看mkdir的目录开头是不是「/」开始
        String fileName = "/".equals(StrUtil.sub(touch.getFileName(),0,1)) ? StrUtil.sub(touch.getFileName(),1,touch.getFileName().length()) : touch.getFileName();
        //进行目录地址拼接
        String filePath = address + fileName;
        if ( FileUtil.touch(new File(filePath)) ){
            logService.log("在「" + address + "」目录下创建了「" + fileName + "」文件");
            return new Result().result200("创建文件的成功",path);
        }else {
            logService.log("未在「" + address + "」目录下创建了「" + fileName + "」文件");
            return new Result().result409("创建文件失败",path);
        }

    }

    /**
     * [删除文件或者文件目录，如果删除的文件或者目录为全部则进行清空操作](Delete the file or file directory. If the deleted file or directory is all, clear it)
     * @description: zh - 删除文件或者文件目录，如果删除的文件或者目录为全部则进行清空操作
     * @description: en - Delete the file or file directory. If the deleted file or directory is all, clear it
     * @version: V1.0
     * @author XiaoXunYao
     * @since 2021/6/28 9:48 上午
     * @param removePath: 删除文件的地址
     * @param path: URL路径
     * @return com.xiaoTools.core.result.Result
     */
    @Override
    public Result remove(String removePath,String[] removeNames, String path) {
        //0. 获取该文件夹内的文件和文件目录的总数。
        File[] files = FileUtil.ls(removePath);
        int count = files.length;
        //日志输出
        log.debug("count --> " + count);
        //1.1 修改文件的格式 --> rootFile = /home/
        String address = "/".equals(StrUtil.sub(removePath,removePath.length() - 1 ,removePath.length() + 1)) ? removePath : removePath + "/";
        //1.2 修改文件的名称格式 --> fileName = string
        for (int i = 0; i < removeNames.length; i++) {
            String fileName = removeNames[i];
            removeNames[i] = "/".equals(StrUtil.sub(fileName,0,1)) ? StrUtil.sub(fileName,1,fileName.length()) : fileName;
        }
        //2. 判断文件数目是否相同
        if (removeNames.length == count) {
            //2.1 分支，清空文件内的所有文件夹
            if (!FileUtil.clean(new File(FileUtil.getAbsolutePath(removePath)))) {
                logService.log("删除「" + address + "」文件夹下所有的文件失败");
                return new Result().result408("删除失败",path);
            }
        }else {
            //2.2 分支，完成项目
            for (String fileName : removeNames) {
                File file = new File(FileUtil.getAbsolutePath(address + fileName));
                if (!FileUtil.rm(file)) {
                    logService.log("删除「" + address + "」文件夹下的"+ FileNameUtil.getName(file) + "失败");
                    return new Result().result408("删除失败",path);
                }
            }
        }
        logService.log("删除「" + address + "」文件夹下的"+ Arrays.toString(removeNames) + "成功");
        return new Result().result200("删除成功",path);
    }

    /**
     * [上传文件](Upload file)
     * @description: zh - 上传文件
     * @description: en - Upload file
     * @version: V1.0
     * @author XiaoXunYao
     * @since 2021/6/30 6:49 下午
     * @param files: 上传的文件集合
     * @param folder: 需要上传的文件路径
     * @param path: URL路径
     * @return com.xiaoTools.core.result.Result
     */
    @Override
    public Result upload(List<MultipartFile> files, Folder folder, String path) {
        if ( FileTemporaryUtil.saveMultiFile(folder.getRootPath(),files) ){
            logService.log("将" + files + "文件上传到「" + folder.getRootPath() + "」成功");
            return new Result().result200("文件上传完成",path);
        }else {
            logService.log("将" + files + "文件上传到「" + folder.getRootPath() + "」失败");
            return new Result().result414("文件上传失败",path);
        }
    }

    /**
     * [读取指定文件的内容](Read the contents of the specified file)
     * @description: zh - 读取指定文件的内容
     * @description: en - Read the contents of the specified file
     * @version: V1.0
     * @author XiaoXunYao
     * @since 2021/7/7 7:46 下午
     * @param filePath: 读取文件的内容
     * @param path: URL路径
     * @return com.xiaoTools.core.result.Result
     */
    @Override
    public Result read(String filePath, String path) {
        FileReader fileReader = new FileReader(filePath);
        return new Result().result200(fileReader.readString(),path);
    }
}
