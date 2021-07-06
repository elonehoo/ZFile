package com.zfile.code.util;

import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 实体类的工具类
 *
 * @author HCY
 * @since 2020/12/11 下午 08:37
 */
public class BeanUtil {
    /**
     * 对象之间的拷贝
     *
     * @author HCY
     * @since 2020/12/11 下午 08:37
     * @param source: 来源
     * @param classType: 接收
     * @return E
     */
    public static <T, E> E copy(T source, Class<E> classType) {

        if (source == null) {
            return null;
        }
        E targetInstance = null;
        try {
            targetInstance = classType.newInstance();
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        BeanUtils.copyProperties(source, targetInstance);
        return targetInstance;
    }
    /**
     * 集合之间对象的拷贝
     *
     * @author HCY
     * @since 2020/12/11 下午 08:38
     * @param sourceList: 来源
     * @param classType: 接收
     * @return java.util.List<E>
     */
    public static <T, E> List<E> batchCopy(List<T> sourceList, Class<E> classType) {
        if (sourceList == null) {
            return null;
        }
        List<E> result = new ArrayList<E>();
        for (T t : sourceList) {
            result.add(copy(t, classType));
        }
        return result;
    }
}
