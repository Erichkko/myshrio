package com.wl.myshrio.service.serviceImpl;

import com.wl.myshrio.service.LoginService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;


@Service
public class LoginServiceImpl implements LoginService {
    @Override
    public String login(String name, String pwd) {
        UsernamePasswordToken upToken = new UsernamePasswordToken(name, pwd);
        Subject subject = SecurityUtils.getSubject();
        subject.login(upToken);
        return null;
    }
}
