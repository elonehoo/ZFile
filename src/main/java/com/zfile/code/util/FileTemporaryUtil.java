package com.zfile.code.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.List;

/**
 * [文件工具类](File Util)
 * @description: zh - 文件工具类
 * @description: en - File Util
 * @version: V1.0
 * @author XiaoXunYao
 * @since 2021/6/30 1:24 下午
*/
public class FileTemporaryUtil {

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

    /**
     * [保存文件](save file)
     * @description: zh - 保存文件
     * @description: en - save file
     * @version: V1.0
     * @author XiaoXunYao
     * @since 2021/7/1 9:58 上午
     * @param basePath: 基础路径
     * @param files: 文件数组
    */
    public static boolean saveMultiFile(String basePath, List<MultipartFile> files) {
        if (files == null || files.size() == 0) {
            return false;
        }

        if (basePath.endsWith("/")) {
            basePath = basePath.substring(0, basePath.length() - 1);
        }
        for (MultipartFile file : files) {
            String replaceAll = file.getOriginalFilename().replaceAll("!", "/");
            String filePath = basePath + "/" + replaceAll;
            makeDir(filePath);
            File dest = new File(filePath);
            try {
                file.transferTo(dest);
            } catch (IllegalStateException | IOException e) {
                return false;
            }
        }
        return true;
    }

    /**
     * [确保目录存在，不存在则创建](Make sure that the directory exists and create it if it does not)
     * @description: zh - 确保目录存在，不存在则创建
     * @description: en - Make sure that the directory exists and create it if it does not
     * @version: V1.0
     * @author XiaoXunYao
     * @since 2021/7/1 10:02 上午
     * @param filePath: 文件路径
    */
    private static void makeDir(String filePath) {
        if (filePath.lastIndexOf('/') > 0) {
            String dirPath = filePath.substring(0, filePath.lastIndexOf('/'));
            File dir = new File(dirPath);
            if (!dir.exists()) {
                dir.mkdirs();
            }
        }
    }

    /**
     *
     * @description:
     * @version: V1.0
     * @author XiaoXunYao
     * @since 2021/7/5 4:44 下午
     * @param fileSize: 将bytes转换成为KB或者MB或者GB
     * @return java.lang.String
    */
    public static String size(long fileSize){

        if (fileSize < 1024){
            return fileSize + " b";
        }else if ( (fileSize / 1024) < 1024){
            //计算KB
            return fileSize / 1024 + " KB";
        }else if ((fileSize / 1024 / 1024) < 1024){
            //计算MB
            return fileSize / 1024 / 1024 + " MB";
        }else if ((fileSize / 1024 / 1024 / 1024) < 1024){
            //计算GB
            return fileSize / 1024 / 1024 / 1024 + " GB";
        }else{
            //计算TB
            return fileSize / 1024 / 1024 / 1024 / 1024 + " TB";
        }
    }
}
