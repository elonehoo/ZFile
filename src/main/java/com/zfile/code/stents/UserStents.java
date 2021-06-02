package com.zfile.code.stents;


import com.xiaoTools.core.result.Result;
import com.zfile.code.entity.user.dto.RegisterUser;

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
}
