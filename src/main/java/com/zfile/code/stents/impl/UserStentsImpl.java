package com.zfile.code.stents.impl;

import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.SmUtil;
import cn.hutool.extra.mail.MailUtil;
import com.xiaoTools.core.randomUtil.RandomUtil;
import com.xiaoTools.core.regular.validation.Validation;
import com.xiaoTools.core.result.Result;
import com.zfile.code.entity.mail.vo.SendMail;
import com.zfile.code.entity.user.dto.RegisterUser;
import com.zfile.code.entity.user.po.User;
import com.zfile.code.service.CipherService;
import com.zfile.code.service.UserService;
import com.zfile.code.stents.UserStents;
import com.zfile.code.util.LocalCache;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.annotation.Resource;

/**
 * [外观设计模式用户层次分层](User hierarchy of exterior design pattern)
 * @description: zh - 外观设计模式用户层次分层
 * @description: en - User hierarchy of exterior design pattern
 * @version: V1.0
 * @author XiaoXunYao
 * @since 2021/6/2 8:45 上午
*/
@Service
public class UserStentsImpl implements UserStents {

    @Resource
    private UserService userService;

    @Resource
    private CipherService cipherService;

    @Resource
    private SendMail sendMail;

    /**
     * [如果用户没有进行初始化操作，则进行初始化操作](If the user does not perform the initialization operation, perform the initialization operation)
     * @description: zh - 如果用户没有进行初始化操作，则进行初始化操作
     * @description: en - If the user does not perform the initialization operation, perform the initialization operation
     * @version: V1.0
     * @author XiaoXunYao
     * @since 2021/6/2 9:46 上午
     * @param user: [注册的用户信息](Registered user information)
     * @param path: [URL路径](URL path)
     * @return com.xiaoTools.core.result.Result
     */
    @Override
    @ExceptionHandler(value = Exception.class)
    public Result register(RegisterUser user, String path) {
        //判断用户是否已经初始化过了。
        if (!userService.initialization()) {
            return new Result().result401("用户已经初始化过了，不需要继续进行初始化",path);
        }else {
            //完成注册的操作，还需考虑一点是否需要验证码
            //判断邮箱是否正确。
            if (!Validation.isEmail(user.getEmail())) {
                return new Result().result401("您的邮箱可能不正确，请您检查后重新进行注册。",path);
            }
            //校验验证码
            if (!LocalCache.get(user.getEmail()).equals(user.getCode())) {
                return new Result().result305("验证码不正确，请您重新输入",path);
            }
            //判断两次密码是否一致
            if (!user.getOnePassword().equals(user.getTwoPassword())) {
                return new Result().result400("两次输入的密码不一致，请重新输入。",path);
            }
            //进行邮箱sm4算法加密
            String emailHex = SmUtil.sm4().encryptHex(user.getEmail());
            //进行密码MD5加密
            String cipher = SecureUtil.md5(user.getOnePassword());
            //判断是否存储成功
            userService.save(new User(emailHex,user.getNickName()));
            return null;
        }
    }

    /**
     * [通过输入的邮箱发送一个存储时间为15分钟的验证码](Send a verification code with a storage time of 15 minutes through the input mailbox)
     * @description: zh - 通过输入的邮箱发送一个存储时间为15分钟的验证码
     * @description: en - Send a verification code with a storage time of 15 minutes through the input mailbox
     * @version: V1.0
     * @author XiaoXunYao
     * @since 2021/6/2 1:16 下午
     * @param email: [需要发送验证码的邮箱](Email address to send verification code)
     * @param path: [URL 路径](url path)
     * @return com.xiaoTools.core.result.Result
     */
    @Override
    public Result verification(String email, String path) {
        //判断邮箱是否正确
        if (!Validation.isEmail(email)) {
            return new Result().result404("您的邮箱可能不正确，请您检查。",path);
        }
        //如果邮箱判断准确，则进行发送验证码邮箱
        //产生验证码
        String code = RandomUtil.randomStringLow(4);
        //进行邮箱的发送
        MailUtil.send(
                sendMail.mailAccount(),
                email
                ,"ZFile 初始化邮件"
                ,"ZFile的初始化验证码为「 " + code + "」有效时间为15分钟。"
                ,false);
        LocalCache.put(email,code,15);
        return new Result().result200("ZFile初始化验证码发送成功，请在十五分钟内完成注册哦",path);
    }
}
