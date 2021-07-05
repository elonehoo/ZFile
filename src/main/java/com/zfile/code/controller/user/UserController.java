package com.zfile.code.controller.user;

import cn.dev33.satoken.annotation.SaCheckLogin;
import com.xiaoTools.core.result.Result;
import com.zfile.code.entity.user.dto.LoginUser;
import com.zfile.code.entity.user.dto.RegisterUser;
import com.zfile.code.entity.user.dto.UpdateUser;
import com.zfile.code.stents.UserStents;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * [用户的控制层](User control layer)
 * @description: zh - 用户的控制层
 * @description: en - User control layer
 * @version: V1.0
 * @author XiaoXunYao
 * @since 2021/6/2 8:40 上午
*/
@CrossOrigin
@RestController
@RequestMapping("/user")
@Api(tags = {"用户控制层的操作"})
public class UserController {

    @Resource
    private UserStents userStents;

    @Resource
    private HttpServletRequest request;

    /**
     * [如果用户尚未进行初始化操作，则进行初始化操作的第一步，注册用户基本的信息](If the user has not done the initialization operation, the first step of the initialization operation is to register the basic information of the user)
     * @description: zh - 如果用户尚未进行初始化操作，则进行初始化操作的第一步，注册用户基本的信息
     * @description: en - If the user has not done the initialization operation, the first step of the initialization operation is to register the basic information of the user
     * @version: V1.0
     * @author XiaoXunYao
     * @since 2021/6/2 9:23 上午
     * @return com.xiaoTools.core.result.Result
    */
    @Operation(summary = "如果用户尚未进行初始化操作，则进行初始化操作的第一步，注册用户基本的信息")
    @PostMapping("/register")
    public Result register(@Valid @RequestBody RegisterUser user){
        return userStents.register(user,request.getRequestURI());
    }

    /**
     * [通过输入的邮箱发送验证码，验证码保留十五分钟。](Send the verification code through the input email, and keep the verification code for 15 minutes.)
     * @description: zh - 通过输入的邮箱发送验证码，验证码保留十五分钟。
     * @description: en - Send the verification code through the input email, and keep the verification code for 15 minutes.
     * @version: V1.0
     * @author XiaoXunYao
     * @since 2021/6/2 1:12 下午
     * @param email: [需要发送验证码的邮箱](Email address to send verification code)
     * @return com.xiaoTools.core.result.Result
    */
    @Operation(summary = "通过输入的邮箱发送验证码，验证码保留十五分钟。")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "email",value = "用户注册的邮箱",dataTypeClass = String.class,dataType = "String",paramType = "query",defaultValue = ""),
    })
    @GetMapping("/verification")
    public Result verification(@RequestParam(value = "email",defaultValue = "") String email){
        return userStents.verification(email,request.getRequestURI());
    }

    /**
     * [用户输入账号和密码进行登陆操作](The user enters the account number and password to log in)
     * @description: zh - 用户输入账号和密码进行登陆操作
     * @description: en - The user enters the account number and password to log in
     * @version: V1.0
     * @author XiaoXunYao
     * @since 2021/6/26 4:29 下午
     * @param user: 用户输入的账号和密码
     * @return com.xiaoTools.core.result.Result
    */
    @PostMapping("/login")
    @Operation(summary = "用户输入账号和密码进行登陆操作")
    public Result login(@RequestBody LoginUser user){
        return userStents.login(user,request.getRequestURI());
    }

    /**
     * [展示用户的信息](Display user information)
     * @description: zh - 展示用户的信息
     * @description: en - Display user information
     * @version: V1.0
     * @author XiaoXunYao
     * @since 2021/7/5 3:14 下午
     * @return com.xiaoTools.core.result.Result
    */
    @SaCheckLogin
    @GetMapping("/show")
    @Operation(summary = "展示用户的信息")
    public Result show(){
        return userStents.show(request.getRequestURI());
    }

    /**
     * [修改用户的信息](Modify user information)
     * @description: zh - 修改用户的信息
     * @description: en - Modify user information
     * @version: V1.0
     * @author XiaoXunYao
     * @since 2021/7/5 3:57 下午
     * @param updateUser: 修改的用户的信息
     * @return com.xiaoTools.core.result.Result
    */
    @SaCheckLogin
    @PutMapping("/user")
    @Operation(summary = "修改用户的信息")
    public Result update(@RequestBody UpdateUser updateUser){
        return userStents.update(updateUser,request.getRequestURI());
    }

    /**
     * [退出登陆](Log out)
     * @description: zh - 退出登陆
     * @description: en - Log out
     * @version: V1.0
     * @author XiaoXunYao
     * @since 2021/6/27 6:45 下午
     * @return com.xiaoTools.core.result.Result
    */
    @SaCheckLogin
    @GetMapping("/signOut")
    @Operation(summary = "退出登陆")
    public Result signOut(){
        return userStents.signOut(request.getRequestURI());
    }

    /**
     * [查看日志](view log)
     * @description: zh - 查看日志
     * @description: en - view log
     * @version: V1.0
     * @author XiaoXunYao
     * @since 2021/7/3 5:34 下午
     * @return com.xiaoTools.core.result.Result
    */
    @SaCheckLogin
    @GetMapping("/log")
    @Operation(summary = "查看日志")
    public Result log(){
        return userStents.log(request.getRequestURI());
    }
}
