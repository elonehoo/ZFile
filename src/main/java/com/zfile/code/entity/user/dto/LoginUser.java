package com.zfile.code.entity.user.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.validation.constraints.Email;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class LoginUser {

    /**
     * 账号
     */
    @ApiModelProperty(value = "账号" )
    @Email(message = "您的邮箱可能不正确，请您检查后重新进行注册。")
    private String account;

    /**
     * 密码
     */
    @ApiModelProperty(value = "密码" )
    private String cipher;
}
