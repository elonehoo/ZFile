package com.zfile.code.stents.impl;

import com.xiaoTools.core.result.Result;
import com.zfile.code.entity.user.dto.RegisterUser;
import com.zfile.code.service.UserService;
import com.zfile.code.stents.UserStents;
import org.springframework.stereotype.Service;

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
        if (!userService.initialization()) {
            return new Result().result401("用户已经初始化过了，不需要继续进行初始化",path);
        }else {
            //完成注册的操作，还需考虑一点是否需要验证码
            return null;
        }
    }
}
