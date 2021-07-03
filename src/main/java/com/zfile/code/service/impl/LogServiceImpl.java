package com.zfile.code.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zfile.code.entity.log.po.Log;
import com.zfile.code.entity.log.vo.ViewLog;
import com.zfile.code.mapper.LogMapper;
import com.zfile.code.service.LogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 *
 * @description: zh - 日志的服务
 * @version: V1.0
 * @author XiaoXunYao
 * @since 2021/7/3 9:38 上午
*/
@Service
public class LogServiceImpl extends ServiceImpl<LogMapper, Log> implements LogService {

    @Resource
    private LogMapper logMapper;

    /**
     * [保存日志](Save log)
     * @description: zh - 保存日志
     * @description: en - Save log
     * @version: V1.0
     * @author XiaoXunYao
     * @since 2021/7/3 9:37 上午
     * @param value: 日志需要保存的模块
     */
    @Override
    public void log(String value) {
        this.save(new Log(value));
    }

    /**
     * [展示日志](Show logs)
     * @description: zh - 展示日志
     * @description: en - Show logs
     * @version: V1.0
     * @author XiaoXunYao
     * @since 2021/7/3 5:22 下午
     * @return com.zfile.code.entity.log.vo.ViewLog
     */
    @Override
    public List<ViewLog> view() {
        return logMapper.view();
    }
}
