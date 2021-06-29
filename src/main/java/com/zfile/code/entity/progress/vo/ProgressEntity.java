package com.zfile.code.entity.progress.vo;

import org.springframework.stereotype.Component;

/**
 * [文件监听实体类](File listening entity class)
 * @description: zh - 文件监听实体类
 * @description: en - File listening entity class
 * @version: V1.0
 * @author XiaoXunYao
 * @since 2021/6/29 8:55 上午
*/
@Component
public class ProgressEntity {

    /**
     * 读取的文件的比特数
     */
    private long pBytesRead = 0L;

    /**
     * 文件的总大小
     */
    private long pContentLength = 0L;

    /**
     * 目前正在读取第几个文件
     */
    private int pItems;

    private long startTime = System.currentTimeMillis();

    public ProgressEntity() {
        pBytesRead = 0L;
        pContentLength = 0L;
    }

    public long getPBytesRead() {
        return pBytesRead;
    }

    public void setPBytesRead(long bytesRead) {
        pBytesRead = bytesRead;
    }

    public String getPContentLength() {
        float tmp = (float) pBytesRead;
        float result = tmp / pContentLength * 100;
        return result + "%";
    }

    public void setPContentLength(long contentLength) {
        pContentLength = contentLength;
    }

    public int getPItems() {
        return pItems;
    }

    public void setPItems(int items) {
        pItems = items;
    }

    @Override
    public String toString() {
        float tmp = (float) pBytesRead;
        float result = tmp / pContentLength * 100;
        return "ProgressEntity [pBytesRead=" + pBytesRead + ", pContentLength="
                + pContentLength + ", percentage=" + result + "% , pItems=" + pItems + "]";
    }

}
