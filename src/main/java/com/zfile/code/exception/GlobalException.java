package com.zfile.code.exception;

import com.xiaoTools.core.result.Result;
import com.zfile.code.exception.custom.CustomException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * [定义全局异常类](Define global exception classes)
 * @description: zh - 定义全局异常类
 * @description: en -  Define global exception classes
 * @version: V1.0
 * @author XiaoXunYao
 * @since 2021/5/27 8:56 上午
*/
@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(value = CustomException.class)
    public Result processException(CustomException e){
        return e.getResult();
    }

    @ExceptionHandler(value = NullPointerException.class)
    public Result nullPointerException(NullPointerException e){
        for (StackTraceElement stackTraceElement : e.getStackTrace()) {
            System.out.println( "stackTraceElement.getMethodName == >" + stackTraceElement.getMethodName());
            System.out.println( "stackTraceElement.getClassName == >" + stackTraceElement.getClassName());
            System.out.println("stackTraceElement.getFileName == >" + stackTraceElement.getFileName());
        }
        return new Result().result500("出现空指针异常","/null");
    }

}
