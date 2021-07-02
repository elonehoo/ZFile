package com.zfile.code.listener;

import cn.hutool.core.date.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.apache.commons.fileupload.ProgressListener;
import javax.servlet.http.HttpSession;

/**
 * [监听文件上传](Monitor file upload)
 * @description: zh - 监听文件上传
 * @description: en - Monitor file upload
 * @version: V1.0
 * @author XiaoXunYao
 * @since 2021/6/29 8:48 上午
*/
@Component
public class UploadProgressListener implements ProgressListener {

    private final Logger log = LoggerFactory.getLogger(UploadProgressListener.class);

    /**
     * session 监听
     */
    private HttpSession session;

    public void setSession(HttpSession session){
        this.session = session;
        log.warn(" upload_percent ---------------- 0 ---------------- {}", DateUtil.now());
        session.setAttribute("upload_percent", 0.00);
    }

    /**
     * [监听上传逻辑](Monitor upload logic)
     * @description: zh - 监听上传逻辑
     * @description: en - Monitor upload logic
     * @version: V1.0
     * @author XiaoXunYao
     * @since 2021/6/29 8:51 上午
     * @param pBytesRead: 到目前为止读取文件的比特数
     * @param pContentLength: 文件总大小
     * @param pItems: 目前正在读取第几个文件
    */
    @Override
    public void update(long pBytesRead, long pContentLength, int pItems) {
        double percent = pBytesRead * 100.0 / pContentLength;
        log.debug("上传文件的进度 --> {}",percent);
        session.setAttribute("upload_percent", percent);
    }
}
