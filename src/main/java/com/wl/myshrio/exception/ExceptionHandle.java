package com.wl.myshrio.exception;

import com.alibaba.fastjson.JSONArray;
import com.wl.myshrio.Enum.EnumCode;
import com.wl.myshrio.controller.base.BaseApi;
import com.wl.myshrio.generator.jooq.tables.pojos.SysOperatingRecord;
import com.wl.myshrio.service.OperatingRecordService;
import com.wl.myshrio.utils.LocalDateUtil;
import com.wl.myshrio.utils.ResultUtil;
import org.apache.shiro.authc.AuthenticationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @desc: 统一异常处理
 * 
 * @author: jwy
 * @date: 2017/12/15
 */
@ControllerAdvice
public class ExceptionHandle  extends BaseApi {

    @Autowired
    private OperatingRecordService operatingRecordService;

    private final  static Logger log = LoggerFactory.getLogger(ExceptionHandle.class);

    @ExceptionHandler(value = {Exception.class})
    @ResponseBody
    public Object handle(Exception e) {

        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        String remoteAddr = request.getRemoteAddr();
        String method = request.getMethod();

        SysOperatingRecord or = new SysOperatingRecord();
        or.setRequesturl(request.getRequestURI());
        or.setRemoteaddr(remoteAddr);
        or.setMethod(method);
        or.setCreateTime(LocalDateUtil.date2LocalDateTime(new Date()));
        or.setUid(super.getUserId());
        or.setFlag("请求出错");
        operatingRecordService.insert(or);


        if (e instanceof MyException) {
           MyException myException = (MyException)e;
           return myException.getResult();
        } else if (e instanceof AuthenticationException) {
            AuthenticationException authenticationException = (AuthenticationException)e;
            return JSONArray.toJSON(ResultUtil.result(EnumCode.LOGIN_FAIL.getValue(), authenticationException.getMessage()));
        } else {
            log.info("系统异常 {}",e);
            return ResultUtil.result(-1, "未知错误");
        }
    }
}
