package com.zfile.code.entity.file.dto;

import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serial;
import java.io.Serializable;

/**
 * [创建文件](create a file)
 * @description: zh - 创建文件
 * @description: en - create a file
 * @version: V1.0
 * @author XiaoXunYao
 * @since 2021/6/27 11:39 上午
*/
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Touch implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 地址
     */
    private String address;

    /**
     * 文件名字
     */
    private String fileName;
}
