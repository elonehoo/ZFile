package com.zfile.code.controller.user;

import cn.dev33.satoken.annotation.SaCheckLogin;
import com.xiaoTools.core.result.Result;
import com.zfile.code.entity.file.dto.Mkdir;
import com.zfile.code.entity.file.dto.Touch;
import com.zfile.code.entity.user.dto.LoginUser;
import com.zfile.code.entity.user.dto.RegisterUser;
import com.zfile.code.stents.UserStents;
import io.swagger.annotations.Api;
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
    public Result postRegister(@Valid @RequestBody RegisterUser user){
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
    @GetMapping("/verification")
    public Result getVerification(@RequestParam(value = "email",defaultValue = "") String email){
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
    public Result postLogin(@RequestBody LoginUser user){
        return userStents.login(user,request.getRequestURI());
    }

    /**
     * [创建文件目录](Create file directory)
     * @description: zh - 创建文件目录
     * @description: en - Create file directory
     * @version: V1.3
     * @author XiaoXunYao
     * @since 2021/6/27 10:15 上午
     * @param mkdir: 创建文件地址
     * @return com.xiaoTools.core.result.Result
    */
    @SaCheckLogin
    @PostMapping("/mkdir")
    @Operation(summary = "创建文件目录")
    public Result postMkdir(@RequestBody Mkdir mkdir){
        return userStents.mkdir(mkdir,request.getRequestURI());
    }


    /**
     * [创建文件](create a file)
     * @description: zh - 创建文件
     * @description: en - create a file
     * @version: V1.0
     * @author XiaoXunYao
     * @since 2021/6/27 12:20 下午
     * @param touch: 创建文件
     * @return com.xiaoTools.core.result.Result
    */
    @SaCheckLogin
    @PostMapping("/touch")
    @Operation(summary = "创建文件")
    public Result postTouch(@RequestBody Touch touch){
        return userStents.touch(touch,request.getRequestURI());
    }

}
