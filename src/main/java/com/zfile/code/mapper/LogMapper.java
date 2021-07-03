package com.zfile.code.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zfile.code.entity.log.po.Log;
import com.zfile.code.entity.log.vo.ViewLog;

import java.util.List;

/**
 * [日志mapper层](Log mapper layer)
 * @description: zh - 日志mapper层
 * @description: en - Log mapper layer
 * @version: V1.0
 * @author XiaoXunYao
 * @since 2021/7/3 9:14 上午
*/
public interface LogMapper extends BaseMapper<Log> {
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
