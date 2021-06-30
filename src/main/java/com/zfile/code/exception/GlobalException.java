package com.zfile.code.exception;

import cn.dev33.satoken.exception.NotLoginException;
import cn.hutool.extra.mail.MailException;
import com.xiaoTools.core.result.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
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

    private final Logger log = LoggerFactory.getLogger(GlobalException.class);

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
        log.error(e.toString());
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
        log.error(e.toString());
        return new Result().result500("出现特殊异常，请联系管理员",request.getRequestURI());
    }

    /**
     * [字段验证错误](Field validation error)
     * @description: zh - 字段验证错误
     * @description: en - Field validation error
     * @version: V1.0
     * @author XiaoXunYao
     * @since 2021/6/26 10:31 上午
     * @param request: [请求的URI](The URI of the request)
     * @param e: [异常处理](exception handling)
     * @return com.xiaoTools.core.result.Result
    */
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public Result methodArgumentNotValidException(HttpServletRequest request,MethodArgumentNotValidException e) {
        log.error(e.toString());
        // 从异常对象中拿到ObjectError对象
        ObjectError objectError = e.getBindingResult().getAllErrors().get(0);
        // 然后提取错误提示信息进行返回
        return new Result().result401(objectError.getDefaultMessage(),request.getRequestURI());
    }

    /**
     * [产生了邮箱功能错误](A mailbox function error occurred)
     * @description: zh - 产生了邮箱功能错误
     * @description: en - A mailbox function error occurred
     * @version: V1.0
     * @author XiaoXunYao
     * @since 2021/6/26 10:34 上午
     * @param e: [异常处理](exception handling)
     * @param request: [请求的URI](The URI of the request)
     * @return com.xiaoTools.core.result.Result
    */
    @ExceptionHandler(value = MailException.class)
    public Result mailException(MailException e, HttpServletRequest request){
        log.error(e.toString());
        return new Result().result403("邮箱产生了错误，可以检查您输入的邮箱是否拥有操作的服务",request.getRequestURI());
    }

    /**
     * [产生了未登录的错误](An unregistered error occurred)
     * @description: zh - 产生了未登录的错误
     * @description: en - An unregistered error occurred
     * @version: V1.0
     * @author XiaoXunYao
     * @since 2021/6/27 12:40 下午
     * @param e: [异常处理](exception handling)
     * @param request: [请求的URI](The URI of the request)
     * @return com.xiaoTools.core.result.Result
    */
    @ExceptionHandler(value = NotLoginException.class)
    public Result notLoginException(NotLoginException e,HttpServletRequest request){
        log.error(e.toString());
        return new Result().result503("未登陆，无法进行操作",request.getRequestURI());
    }

    /**
     * [产生了 Http消息不可读异常](An unreadable HTTP message exception was generated)
     * @description: zh - 产生了 Http消息不可读异常
     * @description: en - An unreadable HTTP message exception was generated
     * @version: V1.0
     * @author XiaoXunYao
     * @since 2021/6/28 9:35 上午
     * @param e: [异常处理](exception handling)
     * @param request: [请求的URI](The URI of the request)
     * @return com.xiaoTools.core.result.Result
    */
    @ExceptionHandler(value = HttpMessageNotReadableException.class)
    public Result httpMessageNotReadableException(HttpMessageNotReadableException e, HttpServletRequest request){
        log.error(e.toString());
        return new Result().result400("Http消息不可读",request.getRequestURI());
    }
}
