package com.zfile.code.entity.user.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;

/**
 * [注册时用户所需要输入的参数](Parameters that users need to input when registering)
 * @description: zh - 注册时用户所需要输入的参数
 * @description: en - Parameters that users need to input when registering
 * @version: V1.0
 * @author XiaoXunYao
 * @since 2021/6/2 9:26 上午
*/
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "注册的用户属性")
public class RegisterUser implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 邮箱
     */
    @ApiModelProperty(value = "邮箱" )
    private String email;

    /**
     * 第一次输入的密码
     */
    @ApiModelProperty(value = "第一次输入的密码" )
    private String onePassword;

    /**
     * 第二次输入的密码
     */
    @ApiModelProperty(value = "第二次输入的密码" )
    private String twoPassword;

    /**
     * 昵称
     */
    @ApiModelProperty(value = "昵称" )
    private String nickName;

    /**
     * 初始化的验证码
     */
    @ApiModelProperty(value = "验证码" )
    private String code;
}
