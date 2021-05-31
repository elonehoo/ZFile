package com.zfile.code.exception.custom;

import com.xiaoTools.core.result.Result;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * [自定义异常](Custom exception)
 * @description: zh - 自定义异常
 * @description: en -  Custom exception
 * @version: V1.0
 * @author XiaoXunYao
 * @since 2021/5/27 9:06 上午
*/
@Data
@EqualsAndHashCode(callSuper = false)
public class CustomException extends RuntimeException{

    private Result result;

    public CustomException(Result result) {
        this.result = result;
    }
}
