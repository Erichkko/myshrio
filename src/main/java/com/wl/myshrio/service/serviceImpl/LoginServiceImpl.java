package com.wl.myshrio.service.serviceImpl;

import com.wl.myshrio.model.dto.UserInfoDto;
import com.wl.myshrio.service.LoginService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Service
public class LoginServiceImpl implements LoginService {
    @Override
    public String login(String name, String pwd,HttpSession session, HttpServletRequest request) {
        UsernamePasswordToken upToken = new UsernamePasswordToken(name, pwd);
        Subject subject = SecurityUtils.getSubject();
        subject.login(upToken);

        UserInfoDto userInfoDto = (UserInfoDto) subject.getPrincipal();
        session.setAttribute("user", userInfoDto);

        return null;
    }
}
