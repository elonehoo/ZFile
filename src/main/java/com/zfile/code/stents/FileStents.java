package com.zfile.code.stents;

import com.xiaoTools.core.result.Result;
import com.zfile.code.entity.file.dto.Folder;
import com.zfile.code.entity.file.dto.Mkdir;
import com.zfile.code.entity.file.dto.Touch;
import com.zfile.code.entity.file.dto.Write;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * [文件中间层](File middle layer)
 * @description: zh - 文件中间层
 * @description: en - File middle layer
 * @version: V1.0
 * @author XiaoXunYao
 * @since 2021/6/28 8:57 上午
*/
public interface FileStents {

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
    Result mkdir(Mkdir mkdir, String path);

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
    Result touch(Touch touch, String path);

    /**
     * [删除文件或者文件目录，如果删除的文件或者目录为全部则进行清空操作](Delete the file or file directory. If the deleted file or directory is all, clear it)
     * @description: zh - 删除文件或者文件目录，如果删除的文件或者目录为全部则进行清空操作
     * @description: en - Delete the file or file directory. If the deleted file or directory is all, clear it
     * @version: V1.0
     * @author XiaoXunYao
     * @since 2021/6/28 9:48 上午
     * @param removePath: 删除文件的路径
     * @param removeNames: 删除文件的名字
     * @param path: URL路径
     * @return com.xiaoTools.core.result.Result
    */
    Result remove(String removePath,String[] removeNames, String path);

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
    Result upload(List<MultipartFile> files, Folder folder, String path);

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
    Result read(String filePath, String path);

    /**
     * [写入文本内容](Write text content)
     * @description: zh - 写入文本内容
     * @description: en - Write text content
     * @version: V1.0
     * @author XiaoXunYao
     * @since 2021/7/14 3:22 下午
     * @param write: 写入内容的实体类
     * @param path: URL路径
     * @return com.xiaoTools.core.result.Result
    */
    Result write(Write write, String path);
}
