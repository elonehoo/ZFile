package com.zfile.code.entity.file.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serial;
import java.io.Serializable;

/**
 * [写入文件的地址和写入文件的内容](Write the address and content of the file)
 * @description: zh - 写入文件的地址和写入文件的内容
 * @description: en - Write the address and content of the file
 * @version: V1.0
 * @author XiaoXunYao
 * @since 2021/7/14 3:17 下午
*/
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Write implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 写入文件的地址
     */
    @ApiModelProperty( value = "写入文件的地址" )
    private String filePath;

    /**
     * 写入文件的内容
     */
    @ApiModelProperty( value = "写入文件的内容" )
    private String content;
}
