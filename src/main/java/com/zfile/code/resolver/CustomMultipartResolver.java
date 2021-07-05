package com.zfile.code.resolver;

import com.zfile.code.listener.UploadProgressListener;
import org.apache.commons.fileupload.*;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * [自定义多部分解析器](Custom multipart parser)
 * @description: zh - 自定义多部分解析器
 * @description: en - Custom multipart parser
 * @version: V1.0
 * @author XiaoXunYao
 * @since 2021/6/29 9:56 上午
*/
public class CustomMultipartResolver extends CommonsMultipartResolver {

    @Resource
    private UploadProgressListener uploadProgressListener;

    @Override
    protected MultipartParsingResult parseRequest(HttpServletRequest request) throws MultipartException {
        String encoding = determineEncoding(request);
        FileUpload fileUpload = prepareFileUpload(encoding);
        // 文件上传进度监听器设置session用于存储上传进度
        uploadProgressListener.setSession(request.getSession());
        // 将文件上传进度监听器加入到 fileUpload 中
        fileUpload.setProgressListener(uploadProgressListener);
        try {
            List<FileItem> fileItems = ((ServletFileUpload) fileUpload).parseRequest(request);
            return parseFileItems(fileItems, encoding);
        } catch (FileUploadException e) {
            e.printStackTrace();
        }
        return null;
    }

}
