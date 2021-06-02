package com.zfile.code.service.impl;

import com.zfile.code.entity.user.po.User;
import com.zfile.code.mapper.UserMapper;
import com.zfile.code.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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
}
