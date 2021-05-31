package com.zfile.code.entity.user.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class LoginUser {
    private String account;
    private String cipher;
}
