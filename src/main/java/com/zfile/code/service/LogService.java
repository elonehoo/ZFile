package com.zfile.code.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zfile.code.entity.log.po.Log;
import com.zfile.code.entity.log.vo.ViewLog;

import java.util.List;

/**
 * [日志服务层](Log service layer)
 * @description: zh - 日志服务层
 * @description: en - Log service layer
 * @version: V1.0
 * @author XiaoXunYao
 * @since 2021/7/3 9:11 上午
*/
public interface LogService extends IService<Log> {
    /**
     * [保存日志](Save log)
     * @description: zh - 保存日志
     * @description: en - Save log
     * @version: V1.0
     * @author XiaoXunYao
     * @since 2021/7/3 9:37 上午
     * @param value: 日志需要保存的模块
    */
    void log(String value);

    /**
     * [展示日志](Show logs)
     * @description: zh - 展示日志
     * @description: en - Show logs
     * @version: V1.0
     * @author XiaoXunYao
     * @since 2021/7/3 5:22 下午
     * @return com.zfile.code.entity.log.vo.ViewLog
    */
    List<ViewLog> view();
}
