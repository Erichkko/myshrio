package com.wl.myshrio.controller.base;

import com.wl.myshrio.model.dto.UserInfoDto;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;


/**
 * @desc:
 * 
 * @author: jwy
 * @date: 2018/1/2
 */
public class BaseApi {


    /**
     * 获取 request
     *
     * @return
     */
    protected HttpServletRequest getRequest() {

        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes())
                .getRequest();
        return request;

    }

    /**
     * 获取用户名称
     * @return
     */
    protected String getUserName() {

        Subject subject = SecurityUtils.getSubject();
        UserInfoDto user = (UserInfoDto) subject.getPrincipal();
        if (null == user) {
            return null;
        }
        return user.getUsername();

    }

    /**
     * 获取用户名id
     * @return
     */
    protected String getUserId() {

        Subject subject = SecurityUtils.getSubject();
        UserInfoDto user = (UserInfoDto) subject.getPrincipal();
        if (null == user) {
            return null;
        }
        return user.getId();

    }

    /**
     * 获取角色id
     * @return
     */
    protected String getRoleId() {

        Subject subject = SecurityUtils.getSubject();
        UserInfoDto user = (UserInfoDto) subject.getPrincipal();
        if (null == user) {
            return null;
        }
        return user.getRoleid();

    }

    /**
     * 获取角色名称
     * @return
     */
    protected String getRoleName() {

        Subject subject = SecurityUtils.getSubject();
        UserInfoDto user = (UserInfoDto) subject.getPrincipal();
        if (null == user) {
            return null;
        }
        return user.getRoleName();

    }

}
