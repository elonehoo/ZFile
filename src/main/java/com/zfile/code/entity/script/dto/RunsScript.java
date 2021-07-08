package com.zfile.code.entity.script.dto;

import io.swagger.annotations.ApiModel;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;

/**
 * [运行脚本集合的类别序号](The class number of the run script collection)
 * @description: zh - 运行脚本集合的类别序号
 * @description: en - The class number of the run script collection
 * @version: V1.0
 * @author XiaoXunYao
 * @since 2021/7/8 1:10 下午
*/
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "运行脚本集合的类别序号")
public class RunsScript implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 脚本类别的序号
     */
    private String categoryId;
}
