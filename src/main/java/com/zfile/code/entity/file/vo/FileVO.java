package com.zfile.code.entity.file.vo;

import cn.hutool.core.date.DateTime;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.xiaoTools.core.IdUtil.IdUtil;
import lombok.*;

import java.util.Date;

/**
 * 展示文件的展示类
 * @author HCY
 * @since 2021/5/11 3:24 下午
*/
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class FileVO {

    private String id;
    /**
     * 文件的名字
     */
    private String fileName;

    /**
     * 文件的类型
     */
    private String fileType;

    /**
     * 文件大小
     */
    private String fileSize;

    /**
     * 修改时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date dateTime;

    public FileVO(String fileName, String fileType, String fileSize, Date dateTime) {
        this.id = IdUtil.fastSimpleUUID();
        this.fileName = fileName;
        this.fileType = fileType;
        this.fileSize = fileSize;
        this.dateTime = dateTime;
    }
}
