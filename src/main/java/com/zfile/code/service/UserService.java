package com.zfile.code.service;

import com.zfile.code.entity.user.po.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zfile.code.entity.user.vo.ShowUser;

/**
 * <p>
 * 用户基本信息表 服务类
 * </p>
 *
 * @author HCY
 * @since 2021-04-28
 */
public interface UserService extends IService<User> {

    /**
     * [判断用户是否已经初始化成功了](Judge whether the user has successfully initialized)
     * @description: zh - 判断用户是否已经初始化成功了
     * @description: en - Judge whether the user has successfully initialized
     * @version: V1.0
     * @author XiaoXunYao
     * @since 2021/6/2 10:25 上午
     * @return java.lang.Boolean
    */
    Boolean initialization();

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
    String getByEmail(String emailHex);

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
    User login(String account, String cipher);

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
