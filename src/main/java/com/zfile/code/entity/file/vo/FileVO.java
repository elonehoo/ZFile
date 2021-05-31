package com.zfile.code.entity.file.vo;

import lombok.*;

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
    /**
     * 文件的名字
     */
    private String fileName;

    /**
     * 文件的类型
     */
    private String fileType;
}
