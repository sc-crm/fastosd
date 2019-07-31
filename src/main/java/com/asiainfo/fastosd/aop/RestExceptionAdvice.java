package com.asiainfo.fastosd.aop;

import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.asiainfo.fastosd.common.Result;
import com.asiainfo.fastosd.exception.ErrorKind;
import com.asiainfo.fastosd.exception.cases.AlreadyExistException;
import com.asiainfo.fastosd.exception.cases.NotFoundException;
import com.asiainfo.fastosd.utils.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static org.springframework.http.HttpStatus.OK;

/**
 * 实现全局异常的拦截处理, 注: @ControllerAdvice 和 @RestControllerAdvice 都会自动注册
 *
 * @author Steven
 * @date 2019-04-26
 */
@Slf4j
@RestControllerAdvice
public class RestExceptionAdvice {

    @ExceptionHandler(NotFoundException.class)
    @ResponseBody
    @ResponseStatus(OK)
    public Result handleResourceNotFoundException(NotFoundException e) {
        log.error(e.getMessage(), e);
        return ResultUtil.failure(e.getCode(), e.getMessage());
    }

    @ExceptionHandler(AlreadyExistException.class)
    @ResponseBody
    @ResponseStatus(OK)
    public Result handleResourceAlreadyExistException(AlreadyExistException e) {
        log.error(e.getMessage(), e);
        return ResultUtil.failure(e.getCode(), e.getMessage());
    }

    @ExceptionHandler(MybatisPlusException.class)
    @ResponseBody
    @ResponseStatus(OK)
    public Result handleMybatisPlusException(MybatisPlusException e) {
        log.error(e.getMessage(), e);
        return ResultUtil.failure(ErrorKind.MABATIS_PLIUS_EXCEPTION.getCode(), e.getMessage());
    }

    /**
     * 处理所有不可知的异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    @ResponseStatus(OK)
    public Result handleException(Exception e) {
        log.error(e.getMessage(), e);
        return ResultUtil.failure(400000, e.getMessage());
    }

}