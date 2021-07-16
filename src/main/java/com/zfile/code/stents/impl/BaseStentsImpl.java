package com.zfile.code.stents.impl;

import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.FileTypeUtil;
import com.xiaoTools.core.fileUtil.fileUtil.FileUtil;
import com.xiaoTools.core.result.Result;
import com.zfile.code.entity.file.vo.FileVO;
import com.zfile.code.entity.systemInfo.systemInfo.vo.SystemInfo;
import com.zfile.code.service.UserService;
import com.zfile.code.stents.BaseStents;
import com.zfile.code.util.FileTemporaryUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 外观模式的支架实现层
 * @author HCY
 * @since 2021/4/28 8:14 下午
*/
@Service
public class BaseStentsImpl implements BaseStents {

    private final Logger log = LoggerFactory.getLogger(BaseStentsImpl.class);

    /**
     * 用户服务接口层
     */
    @Resource
    private UserService userService;

    /**
     * 判断是否已经完善了初始化
     * @author HCY
     * @since 2021/4/28 8:19 下午
     * @param path: URL路径
     * @return com.xiaoTools.core.result.Result
     */
    @Override
    public Result getInitialization(String path) {
        return new Result().result200(userService.initialization(),path);

    }

    /**
     * 查看某个文件夹以内的所有[文件](文件夹)
     * @author HCY
     * @since 2021/5/11 12:32 下午
     * @param value: 查看的文件夹起点
     * @param path: URL路径
     * @return com.xiaoTools.core.result.Result
     */
    @Override
    public Result getSeeContent(String value, String path) {
        //先定义[泛型](FileVo)的[List](集合)
        List<FileVO> lists = new ArrayList<>();
        //接下来的操作，因为设计到了IO流的操作所以可能会产生异常，故而使用了异常。
        try {
            //通过查看文件夹的起点路径，查看该文件夹下面的路径所有的文件或者目录
            File[] files = FileUtil.ls(value);
            //循环该数组
            for (File file : files) {
                //判断文件是否是目录
                if (!file.isDirectory()) {
                    //如果不是目录，则获取该文件的文件类型
                    lists.add(new FileVO(file.getName(),FileTypeUtil.getType(file), FileTemporaryUtil.size(cn.hutool.core.io.FileUtil.size(file)),cn.hutool.core.io.FileUtil.lastModifiedTime(file)));
                }else {
                    //是目录，则进行集合添加
                    lists.add(new FileVO(file.getName(), "Directory", FileTemporaryUtil.size(cn.hutool.core.io.FileUtil.size(file)),cn.hutool.core.io.FileUtil.lastModifiedTime(file)));
                }
            }
        }catch (Exception e){ /*无任何需要制作的操作*/ }
        return new Result().result200(lists,path);
    }

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
    @Override
    public Result getSystemInfo(String path) {
        return new Result().result200(new SystemInfo(),path);
    }

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
    @Override
    public Result is(String path) {
        return new Result().result200(StpUtil.isLogin(),path);
    }
}

