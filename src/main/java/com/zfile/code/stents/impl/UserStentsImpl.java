package com.zfile.code.stents.impl;

import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.bean.BeanUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.SmUtil;
import cn.hutool.crypto.symmetric.AES;
import cn.hutool.extra.mail.MailUtil;
import com.xiaoTools.core.fileUtil.fileUtil.FileUtil;
import com.xiaoTools.core.randomUtil.RandomUtil;
import com.xiaoTools.core.regular.validation.Validation;
import com.xiaoTools.core.result.Result;
import com.xiaoTools.core.strUtil.StrUtil;
import com.zfile.code.entity.aes.Encryption;
import com.zfile.code.entity.cipher.po.Cipher;
import com.zfile.code.entity.file.dto.Mkdir;
import com.zfile.code.entity.file.dto.Touch;
import com.zfile.code.entity.log.po.Log;
import com.zfile.code.entity.log.vo.ViewLog;
import com.zfile.code.entity.mail.vo.SendMail;
import com.zfile.code.entity.user.dto.LoginUser;
import com.zfile.code.entity.user.dto.RegisterUser;
import com.zfile.code.entity.user.dto.UpdateUser;
import com.zfile.code.entity.user.po.User;
import com.zfile.code.entity.user.vo.ShowUser;
import com.zfile.code.service.CipherService;
import com.zfile.code.service.LogService;
import com.zfile.code.service.UserService;
import com.zfile.code.stents.UserStents;
import com.zfile.code.util.LocalCache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.annotation.Resource;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    
    private final Logger log = LoggerFactory.getLogger(UserStentsImpl.class);

    @Resource
    private UserService userService;

    @Resource
    private CipherService cipherService;

    @Resource
    private LogService logService;

    @Resource
    private SendMail sendMail;

    @Resource
    private Encryption encryption;


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
    public Result register(RegisterUser user, String path) {
        //判断用户是否已经初始化过了。
        if (userService.initialization()) {
            return new Result().result401("用户已经初始化过了，不需要继续进行初始化",path);
        }else {
            //完成注册的操作，还需考虑一点是否需要验证码
            log.debug("验证码",LocalCache.get(user.getEmail()));
            //校验验证码
            if (!LocalCache.get(user.getEmail()).equals(user.getCode())) {
                return new Result().result305("验证码不正确，请您重新输入",path);
            }
            //判断两次密码是否一致
            if (!user.getOnePassword().equals(user.getTwoPassword())) {
                return new Result().result400("两次输入的密码不一致，请重新输入。",path);
            }
            //进行邮箱sm4算法加密
            String emailHex = encryption.createAes().encryptHex((user.getEmail()));
            //判断是否存储成功
            if (!userService.save(new User(emailHex, user.getNickName()))) {
                return new Result().result409("用户注册失败",path);
            }
            //1. 通过邮箱获取用户主键
            String userID = userService.getByEmail(emailHex);
            //2. 进行密码MD5加密
            String cipher = SecureUtil.md5(user.getOnePassword());
            if (!cipherService.save(new Cipher(userID, cipher))) {
                if (userService.removeById(userID)) {
                    return new Result().result409("用户注册失败",path);
                }
            }
            return new Result().result200("用户注册成功",path);
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

    /**
     * [登陆操作](Login operation)
     * @description: zh - 登陆操作
     * @description: en - Login operation
     * @version: V1.0
     * @author XiaoXunYao
     * @since 2021/6/26 2:39 下午
     * @param user: 用户的账号 and 密码
     * @param path: URL path
     * @return com.xiaoTools.core.result.Result
     */
    @Override
    public Result login(LoginUser user, String path) {
        //0. 将账号进行sm4加密
        //1. 将密码进行md5加密
        //2. 进行数据库查询
        User loginUser = userService.login(
                encryption.createAes().encryptHex(user.getAccount()),
                SecureUtil.md5(user.getCipher()));
        //判断是否登陆成功
        if (loginUser == null){
            logService.log("用户登陆失败");
            return new Result().result503("账号或者密码错误，无法登陆",path);
        }
        //调用 sa-token 的登陆操作
        StpUtil.login(loginUser.getId());
        logService.log("用户登陆");
        return new Result().result200("登陆成功",path);
    }

    /**
     * [退出操作](Exit operation)
     * @description: zh - 退出操作
     * @description: en - Exit operation
     * @version: V1.0
     * @author XiaoXunYao
     * @since 2021/6/27 6:43 下午
     * @param path: URL路径
     * @return com.xiaoTools.core.result.Result
     */
    @Override
    public Result signOut(String path) {
        StpUtil.logoutByTokenValue(StpUtil.getTokenValue());
        logService.log("用户退出");
        return new Result().result200("退出成功",path);
    }


    /**
     * [查看日志](view log)
     * @description: zh - 查看日志
     * @description: en - view log
     * @version: V1.0
     * @author XiaoXunYao
     * @since 2021/7/3 4:07 下午
     * @param path: URL路径
     * @return com.xiaoTools.core.result.Result
     */
    @Override
    public Result log(String path) {
        return new Result().result200(logService.view(),path);
    }

    /**
     * [查看用户的信息](View user information)
     * @description: zh - 查看用户的信息
     * @description: en - View user information
     * @version: V1.0
     * @author XiaoXunYao
     * @since 2021/7/5 3:16 下午
     * @param path: URL路径
     * @return com.xiaoTools.core.result.Result
     */
    @Override
    public Result show(String path) {
        ShowUser showUser = userService.show();
        AES aes = encryption.createAes();
        showUser.setEmail(aes.decryptStr(showUser.getEmail()));
        return new Result().result200(showUser,path);
    }

    /**
     * [修改用户的信息](Modify user information)
     * @description: zh - 修改用户的信息
     * @description: en - Modify user information
     * @version: V1.0
     * @author XiaoXunYao
     * @since 2021/7/5 3:34 下午
     * @param updateUser: 可以修改的用户信息
     * @param path: URL路径
     * @return com.xiaoTools.core.result.Result
     */
    @Override
    public Result update(UpdateUser updateUser, String path) {
        String loginId = StpUtil.getLoginId().toString();
        return userService.updateById(new User(loginId,updateUser.getPhoto(),updateUser.getNickName())) ?
                new Result().result200("修改成功",path) :
                new Result().result403("修改失败",path);
    }
}
