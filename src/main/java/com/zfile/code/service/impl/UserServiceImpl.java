package com.zfile.code.service.impl;

import com.zfile.code.entity.user.po.User;
import com.zfile.code.entity.user.vo.ShowUser;
import com.zfile.code.mapper.UserMapper;
import com.zfile.code.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 用户基本信息表 服务实现类
 * </p>
 *
 * @author HCY
 * @since 2021-04-28
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Resource
    private UserMapper userMapper;

    /**
     * [判断用户是否已经初始化成功了](Judge whether the user has successfully initialized)
     * @description: zh - 判断用户是否已经初始化成功了
     * @description: en - Judge whether the user has successfully initialized
     * @version: V1.0
     * @author XiaoXunYao
     * @since 2021/6/2 10:25 上午
     * @return java.lang.Boolean
     */
    @Override
    public Boolean initialization() {
        //1.获取数据表中的总用户数据
        //2.如果 「 count > 0 」 则早已经初始化成功，反之则初始化失败。
        //3.返回「 true 」则表示无需初始化
        //4.返回「 false 」则表示需要初始化
        return this.count() > 0;
    }

    /**
     * [通过用户的加密邮件获取用户的主键](Get the user's primary key through the user's encrypted e-mail)
     * @description: zh - 通过用户的加密邮件获取用户的主键
     * @description: en - Get the user's primary key through the user's encrypted e-mail
     * @version: V1.0
     * @author XiaoXunYao
     * @since 2021/6/24 12:25 下午
     * @param emailHex: 用户的加密邮件
     * @return java.lang.String
     */
    @Override
    public String getByEmail(String emailHex) {
        return userMapper.selectByEmail(emailHex);
    }

    /**
     * [通过账号和密码进行登陆操作](Login through account and password)
     * @description: zh - 通过账号和密码进行登陆操作
     * @description: en - Login through account and password
     * @version: V1.0
     * @author XiaoXunYao
     * @since 2021/6/26 2:43 下午
     * @param account: 账号
     * @param cipher: 密码
     * @return com.zfile.code.entity.user.po.User
     */
    @Override
    public User login(String account, String cipher) {
        return userMapper.selectByLogin(account,cipher);
    }

    /**
     * [展示用户的信息](Display user information)
     * @description: zh - 展示用户的信息
     * @description: en - Display user information
     * @version: V1.0
     * @author XiaoXunYao
     * @since 2021/7/5 2:46 下午
     * @return com.zfile.code.entity.user.vo.ShowUser
     */
    @Override
    public ShowUser show() {
        return userMapper.show();
    }
}
