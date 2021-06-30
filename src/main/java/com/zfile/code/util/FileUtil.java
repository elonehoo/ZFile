package com.zfile.code.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * [文件工具类](File Util)
 * @description: zh - 文件工具类
 * @description: en - File Util
 * @version: V1.0
 * @author XiaoXunYao
 * @since 2021/6/30 1:24 下午
*/
public class FileUtil {

    /**
     * [将临时文件转换成为File](MultipartFile To File)
     * @description: zh - 将临时文件转换成为File
     * @description: en - MultipartFile To File
     * @version: V1.0
     * @author XiaoXunYao
     * @since 2021/6/30 7:03 下午
     * @param file: 临时文件
     * @return java.io.File
    */
    public static File transferToFile(MultipartFile file)throws Exception {
        File toFile = null;
        if ("".equals(file) || file.getSize() <= 0) {
            file = null;
        } else {
            InputStream ins = null;
            ins = file.getInputStream();
            toFile = new File(file.getOriginalFilename());
            inputStreamToFile(ins, toFile);
            ins.close();
        }
        return toFile;
    }

    /**
     * [输入流转换成为File](InputStream To File)
     * @description: zh - 输入流转换成为File
     * @description: en - InputStream To File
     * @version: V1.0
     * @author XiaoXunYao
     * @since 2021/6/30 7:06 下午
     * @param ins: 输入流
     * @param file: 文件
    */
    private static void inputStreamToFile(InputStream ins, File file) {
        try {
            OutputStream os = new FileOutputStream(file);
            int bytesRead = 0;
            byte[] buffer = new byte[8192];
            while ((bytesRead = ins.read(buffer, 0, 8192)) != -1) {
                os.write(buffer, 0, bytesRead);
            }
            os.close();
            ins.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
