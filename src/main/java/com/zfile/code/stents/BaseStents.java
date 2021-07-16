package com.zfile.code.stents;


import com.xiaoTools.core.result.Result;

/**
 * 外观模式支架接口层
 * @author HCY
 * @since 2021/4/28 8:15 下午
*/
public interface BaseStents {

    /**
     * 判断是否已经完善了初始化
     * @author HCY
     * @since 2021/4/28 8:19 下午
     * @param path: URL路径
     * @return com.xiaoTools.core.result.Result
    */
    Result getInitialization(String path);

    /**
     * 查看某个文件夹以内的所有[文件](文件夹)
     * @author HCY
     * @since 2021/5/11 12:32 下午
     * @param value: 查看的文件夹起点
     * @param path: URL路径
     * @return com.xiaoTools.core.result.Result
    */
    Result getSeeContent(String value, String path);

    /**
     * [查看系统的基础配置](View the basic configuration of the system)
     * @description: zh - 查看系统的基础配置
     * @description: en - View the basic configuration of the system
     * @version: V1.0
     * @author XiaoXunYao
     * @since 2021/5/31 8:54 上午
     * @param path: URL路径
     * @return com.xiaoTools.core.result.Result
    */
    Result getSystemInfo(String path);

    /**
     * [判断用户是否在登陆中](Judge whether the user is logging in)
     * @description: zh - 判断用户是否在登陆中
     * @description: en - Judge whether the user is logging in
     * @version: V1.0
     * @author XiaoXunYao
     * @since 2021/7/16 11:04 上午
     * @param path: URL路径
     * @return com.xiaoTools.core.result.Result
    */
    Result is(String path);
}
