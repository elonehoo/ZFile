package com.zfile.code.util;

import cn.hutool.cache.CacheUtil;
import cn.hutool.cache.impl.TimedCache;
import cn.hutool.core.date.DateUnit;

/**
 * [缓存cache的使用](The use of cache)
 * @description: zh - 缓存cache的使用
 * @description: en - The use of cache
 * @version: V1.0
 * @author XiaoXunYao
 * @since 2021/6/5 10:47 上午
*/
public class LocalCache {
    /**
     * 默认缓存时长 单位s
     */
    private static final Long DEFAULT_TIMEOUT = 15 * 60 * 1000L;

    /**
     * 默认清理间隔时间 单位s
     */
    private static final Long CLEAN_TIMEOUT = 15 * 60 * 1000L;

    /**
     * 缓存对象
     */
    public static TimedCache<String, String> timedCache = CacheUtil.newTimedCache(DEFAULT_TIMEOUT);

    static {
        /**
         * 启动定时任务
         */
        timedCache.schedulePrune(CLEAN_TIMEOUT);
    }

    public static void put(String key,String value) {
        timedCache.put(key, value);
    }

    public static void put(String key,String value,Integer expire) {
        timedCache.put(key, value, DateUnit.SECOND.getMillis() * expire);
    }

    /**
     * 禁止延迟缓存 isUpdateLastAccess = false
     * @param key
     * @param isUpdateLastAccess
     */
    public static String get(String key,boolean isUpdateLastAccess){
        return timedCache.get(key,isUpdateLastAccess);
    }

    public static String get(String key){
        return timedCache.get(key);
    }

    public static void remove(String key){
        timedCache.remove(key);
    }

    public static void clear(){
        timedCache.clear();
    }

}
