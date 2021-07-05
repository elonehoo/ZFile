package com.zfile.code.stents;


import com.xiaoTools.core.result.Result;
import com.zfile.code.entity.file.dto.Mkdir;
import com.zfile.code.entity.file.dto.Touch;
import com.zfile.code.entity.user.dto.LoginUser;
import com.zfile.code.entity.user.dto.RegisterUser;
import com.zfile.code.entity.user.dto.UpdateUser;

/**
 * [外观模式的用户接口分层](User interface layering of appearance mode)
 * @description: zh - 外观模式的用户接口分层
 * @description: en - User interface layering of appearance mode
 * @version: V1.0
 * @author XiaoXunYao
 * @since 2021/6/2 8:44 上午
*/

public interface UserStents {
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
    Result register(RegisterUser user, String path);

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
    Result verification(String email, String path);

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
    Result login(LoginUser user, String path);

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
    Result signOut(String path);

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
    Result log(String path);

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
    Result show(String path);

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
    Result update(UpdateUser updateUser, String path);
}
