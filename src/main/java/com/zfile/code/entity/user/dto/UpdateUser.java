package com.zfile.code.entity.user.dto;

import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serial;
import java.io.Serializable;

/**
 * [修改用户的信息](Modify user information)
 * @description: zh - 修改用户的信息
 * @description: en - Modify user information
 * @version: V1.0
 * @author XiaoXunYao
 * @since 2021/7/5 3:29 下午
*/
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class UpdateUser implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 头像
     */
    private String photo;
}
