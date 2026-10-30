package com.imlyb.tlias.exception;

import com.imlyb.tlias.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public Result handlerException(Exception e){
        log.error("程序出错啦",e);
        return Result.error("出错，请联系管理");
    }

    @ExceptionHandler
    public Result studentsRemainException(ClazzHasStudentsException c){
        log.warn("删除班级失败{}",c.getMessage());
        return Result.error(c.getMessage());
    }


}
