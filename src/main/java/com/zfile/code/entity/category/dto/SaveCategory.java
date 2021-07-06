package com.zfile.code.entity.category.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Size;
import java.io.Serial;
import java.io.Serializable;

/**
 * [保存脚本类别的实体类](The entity class that holds the script category)
 * @description: zh - 保存脚本类别的实体类
 * @description: en - The entity class that holds the script category
 * @version: V1.0
 * @author XiaoXunYao
 * @since 2021/7/6 8:51 上午
*/
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "保存脚本类别的实体类")
public class SaveCategory implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 类别的名称
     */
    @ApiModelProperty( value = "类别的名称" )
    @Length(max = 100,message = "类别的长度不能超过100")
    private String categoryName;
}
