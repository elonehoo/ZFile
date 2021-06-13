package com.zfile.code.exception;

import com.xiaoTools.core.result.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

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

    /**
     * [处理空指针异常](Handle null pointer exception)
     * @description: zh - 处理空指针异常
     * @description: en - Handle null pointer exception
     * @version: V1.0
     * @author XiaoXunYao
     * @since 2021/6/8 2:05 下午
     * @param request: [请求的URI](The URI of the request)
     * @param e: [异常处理](exception handling)
     * @return com.xiaoTools.core.result.Result
    */
    @ExceptionHandler(value = NullPointerException.class)
    public Result nullPointerException(HttpServletRequest request, NullPointerException e){
        return new Result().result500("出现空指针异常",request.getRequestURI());
    }

    /**
     * [处理特殊异常](Handling special exceptions)
     * @description: zh - 处理特殊异常
     * @description: en - Handling special exceptions
     * @version: V1.0
     * @author XiaoXunYao
     * @since 2021/6/8 2:05 下午
     * @param request: [请求的URI](The URI of the request)
     * @param e: [异常处理](exception handling)
     * @return com.xiaoTools.core.result.Result
    */
    @ExceptionHandler(value = Exception.class)
    public Result allException(HttpServletRequest request, Exception e){
        return new Result().result500("出现特殊异常，请联系管理员",request.getRequestURI());
    }

}
