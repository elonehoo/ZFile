package com.zfile.code.mapper;

import com.zfile.code.entity.user.po.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

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
}
