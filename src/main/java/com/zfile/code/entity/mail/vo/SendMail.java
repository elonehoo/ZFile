package com.zfile.code.entity.mail.vo;

import cn.hutool.extra.mail.MailAccount;
import lombok.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.Serial;
import java.io.Serializable;


/**
 * [发送邮件的模块](Module for sending mail)
 * @description: zh - 发送邮件的模块
 * @description: en - Module for sending mail
 * @version: V1.0
 * @author XiaoXunYao
 * @since 2021/6/2 5:13 下午
*/
@Getter
@Setter
@ToString
@Component
@NoArgsConstructor
@AllArgsConstructor
public class SendMail implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 主机地址
     */
    @Value("${mail.host}")
    private String host;

    /**
     * 端口号
     */
    @Value("${mail.port}")
    private Integer port;

    /**
     * 发送的邮件
     */
    @Value("${mail.from}")
    private String from;

    /**
     * 发送的昵称
     */
    @Value("${mail.user}")
    private String user;

    /**
     * 发送的密码
     */
    @Value("${mail.pass}")
    private String pass;

    public MailAccount mailAccount(){
        return new MailAccount()
                .setHost(this.host)
                .setPort(this.port)
                .setAuth(true)
                .setStarttlsEnable(true)
                .setFrom(this.from)
                .setUser(this.user)
                .setPass(this.pass);
    }

}
