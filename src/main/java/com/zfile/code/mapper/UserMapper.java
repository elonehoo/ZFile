package com.zfile.code.mapper;

import com.zfile.code.entity.user.po.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zfile.code.entity.user.vo.ShowUser;

/**
 * <p>
 * 用户基本信息表 Mapper 接口
 * </p>
 *
 * @author HCY
 * @since 2021-04-28
 */
public interface UserMapper extends BaseMapper<User> {

    /**
     * [通过用户的加密邮件获取用户的主键](Get the user's primary key through the user's encrypted e-mail)
     * @description: zh - 通过用户的加密邮件获取用户的主键
     * @description: en - Get the user's primary key through the user's encrypted e-mail
     * @version: V1.0
     * @author XiaoXunYao
     * @since 2021/6/24 12:25 下午
     * @param email: 用户的加密邮件
     * @return java.lang.String
     */
    String selectByEmail(String email);

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
    User selectByLogin(String account, String cipher);

    /**
     * [展示用户的信息](Display user information)
     * @description: zh - 展示用户的信息
     * @description: en - Display user information
     * @version: V1.0
     * @author XiaoXunYao
     * @since 2021/7/5 2:46 下午
     * @return com.zfile.code.entity.user.vo.ShowUser
     */
    ShowUser show();
}
