package com.zfile.code.entity.user.vo;

import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serial;
import java.io.Serializable;

/**
 * [展示用户信息](Display user information)
 * @description: zh - 展示用户信息
 * @description: en - Display user information
 * @version: V1.0
 * @author XiaoXunYao
 * @since 2021/7/5 2:56 下午
*/
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class ShowUser implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 邮件
     */
    private String email;

    /**
     * 用户信息
     */
    private String nickName;

    /**
     * 头像
     */
    private String photo;

}
