package com.zfile.code.entity.script.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;

/**
 * [保存脚本的内容](Save the contents of the script)
 * @description: zh - 保存脚本的内容
 * @description: en - Save the contents of the script
 * @version: V1.0
 * @author XiaoXunYao
 * @since 2021/7/6 4:27 下午
*/
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "保存脚本的内容")
public class ScriptValue implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 脚本的内容
     */
    @ApiModelProperty( value = "脚本的内容" )
    private String script;

    /**
     * 排序
     */
    @ApiModelProperty( value = "排序" )
    private int digit;

}
