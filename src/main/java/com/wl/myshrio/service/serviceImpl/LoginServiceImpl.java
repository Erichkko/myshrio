package com.wl.myshrio.service.serviceImpl;

import com.wl.myshrio.generator.jooq.tables.pojos.SysLoginLog;
import com.wl.myshrio.model.dto.UserInfoDto;
import com.wl.myshrio.service.LoginLogService;
import com.wl.myshrio.service.LoginService;
import com.wl.myshrio.utils.LocalDateUtil;
import com.wl.myshrio.utils.UUIDUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.UUID;


@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    LoginLogService loginLogService;

    @Override
    public String login(String name, String pwd,HttpSession session, HttpServletRequest request) {
        UsernamePasswordToken upToken = new UsernamePasswordToken(name, pwd);
        Subject subject = SecurityUtils.getSubject();
        subject.login(upToken);

        UserInfoDto userInfoDto = (UserInfoDto) subject.getPrincipal();
        session.setAttribute("user", userInfoDto);

        // 登录日志
        SysLoginLog loginLog = new SysLoginLog();
        loginLog.setId(UUIDUtil.getUUID());
        loginLog.setUid(userInfoDto.getId());
        loginLog.setLogintime(LocalDateUtil.date2LocalDateTime(new Date()));
        loginLog.setLoginip(request.getRemoteAddr());
        loginLog.setLogintotal(loginLogService.findVisitCountByUserId(userInfoDto.getId())); // 登录总次数
        loginLogService.insert(loginLog);


        return null;
    }
}
