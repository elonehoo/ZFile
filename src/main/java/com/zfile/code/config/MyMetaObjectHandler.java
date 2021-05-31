package com.zfile.code.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;
import java.util.Date;


/**
 * 插入时间的字段配置
 *
 * @author HCY
 * @since 2020/12/11 9:10 上午
 */
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {
    /**
     * 插入时的填充策略
     * @author HCY
     * @since 2020/12/11 9:31 上午
     * @param metaObject:
     * @return void
    */
    @Override
    public void insertFill(MetaObject metaObject) {
        this.setFieldValByName("gmtCreate", new Date(), metaObject);
        this.setFieldValByName("gmtModified", new Date(), metaObject);
    }

    /**
     * 更新时的填充策略
     * @author HCY
     * @since 2020/12/11 9:32 上午
     * @param metaObject:
     * @return void
    */
    @Override
    public void updateFill(MetaObject metaObject) {
        this.setFieldValByName("gmtModified", new Date(), metaObject);
    }
}
