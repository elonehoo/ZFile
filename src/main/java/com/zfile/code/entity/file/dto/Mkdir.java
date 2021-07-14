package com.zfile.code.entity.file.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serial;
import java.io.Serializable;

/**
 * [创建文件夹的实体类](Create the entity class of the folder)
 * @description: zh - 创建文件夹的实体类
 * @description: en - Create the entity class of the folder
 * @version: V1.0
 * @author XiaoXunYao
 * @since 2021/6/26 11:04 上午
*/
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Mkdir implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 创建文件夹的地址
     */
    @ApiModelProperty( value = "创建文件夹的地址" )
    private String address;

    /**
     * 创建的文件夹的名字
     */
    @ApiModelProperty( value = "创建的文件夹的名字" )
    private String fileName;
}
