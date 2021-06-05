package com.zfile.code.controller.user;

import com.xiaoTools.core.result.Result;
import com.zfile.code.entity.user.dto.RegisterUser;
import com.zfile.code.stents.UserStents;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

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
    public Result postRegister(@RequestBody RegisterUser user){
        return userStents.register(user,"/user/register");
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
    public Result getVerification(@RequestParam(value = "email",defaultValue = "")String email){
        return userStents.verification(email,"/user/verification");
    }

}
