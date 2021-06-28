package com.zfile.code.entity.file.dto;

import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serial;
import java.io.Serializable;

/**
 * [删除的文件](Deleted files)
 * @description: zh - 删除的文件
 * @description: en - Deleted files
 * @version: V1.0
 * @author XiaoXunYao
 * @since 2021/6/28 9:23 上午
*/
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Remove implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 删除文件的目录
     */
    private String rootFile;

    /**
     * 删除的文件的名字
     */
    private String[] fileNames;
}
