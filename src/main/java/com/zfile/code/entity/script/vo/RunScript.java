package com.zfile.code.entity.script.vo;

import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serial;
import java.io.Serializable;

/**
 * [运行脚本实体类](Run script entity class)
 * @description: zh - 运行脚本实体类
 * @description: en - Run script entity class
 * @version: V1.0
 * @author XiaoXunYao
 * @since 2021/7/7 10:50 上午
*/
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class RunScript implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 排序
     */
    private int digit;

    /**
     * 脚本
     */
    private String script;
}
