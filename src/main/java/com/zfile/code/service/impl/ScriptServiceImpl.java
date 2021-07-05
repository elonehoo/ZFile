package com.zfile.code.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zfile.code.entity.script.po.Script;
import com.zfile.code.mapper.ScriptMapper;
import com.zfile.code.service.ScriptService;
import org.springframework.stereotype.Service;

/**
 * [脚本信息](Script information)
 * @description: zh - 脚本信息
 * @description: en - Script information
 * @version: V1.0
 * @author XiaoXunYao
 * @since 2021/7/5 8:16 下午
*/
@Service
public class ScriptServiceImpl extends ServiceImpl<ScriptMapper, Script> implements ScriptService {
}
